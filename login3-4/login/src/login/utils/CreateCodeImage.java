package login.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreateCodeImage {
	private static final int WIDTH=100;
	private static final int HEIGHT=30;
	private static final int LENGTH=4; //验证码是长度为4
	private static final int LINECOUNT=20; //干扰线数目
	
	private static final String str="23456789"
	+"ABCDEFGHJKMNPQRSTUVWXYZ"+"abcdefghjkmnpqrstuvwxyz";
	
	private static Random random =new Random();
	
	//随机选取四位字符组成字符串
	public String createCode(){
		String code ="";
		for (int i = 0; i < LENGTH; i++) {
			char c=str.charAt(random.nextInt(str.length()));
			code=code+c;
			
		}
		return code;
	}
	
	//随机获取颜色
	public Color getColor(){
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	}
	
	//设置字体样式
	public Font getFont() {
		return new Font("Fixedsys",Font.CENTER_BASELINE,30);
	}
	
	//绘制字符
	public void drawChar(Graphics g,String code) {
		g.setFont(getFont());
		for (int i = 0; i <LENGTH; i++) {
			char c=code.charAt(i);
			g.setColor(getColor());
			g.drawString(c+"", 20*i+10, 20);
		}
	}
	
	//绘制随机线条
	public void drawLine(Graphics g) {
		int x=random.nextInt(WIDTH);
		int y=random.nextInt(LENGTH);
		int x1=random.nextInt(13);
		int y1=random.nextInt(15);
		g.setColor(getColor());
		g.drawLine(x, y, x+x1, y+y1);
		
	}
	
	//绘制图片
	public BufferedImage createImage(String code) {
		//获取画笔
		BufferedImage image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		
		Graphics graphics=image.getGraphics();
		//设置背景颜色并绘制背景
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
		//绘制验证码
		drawChar(graphics, code);
		
		//绘制随机线
		for (int i = 0; i <LINECOUNT; i++) {
			drawLine(graphics);
		}
		//绘制图片
		graphics.dispose();
		return image;
	}
	
}
