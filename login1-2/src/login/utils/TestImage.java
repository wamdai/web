package login.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestImage {
	public static void main(String[] args) {
		CreateCodeImage cc=new CreateCodeImage();
		String randomCode =cc.createCode();
		
		BufferedImage createImage = cc.createImage(randomCode);
		File file =new File("G:/zuoye/eclipase`s/login/WebContent/login/images/test.jpeg");
		try {
			ImageIO.write(createImage, "jpeg", file);
			System.out.println("保存图片成功");
		} catch (IOException e) {
			System.out.println("保存失败");
			e.printStackTrace();
		}
	}
}
