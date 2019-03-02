package com.qa.mobile.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.util.Arrays;


public class ImageCompareUtil {
	
	public enum Result{Matched,SizeMismatch,PixelMismatch};
	
	static Result compareImage(String basefile,String actualfile) {
		
		Result compareResult = Result.PixelMismatch;
		
		Image baseImage = Toolkit.getDefaultToolkit().getImage(basefile);
		Image actualImage = Toolkit.getDefaultToolkit().getImage(actualfile);
		
		try {
			PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
			PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
			
			int[] baseImageData = null;
			int[] actualImageData = null;
			
			if(baseImageGrab.grabPixels()) {
				int width = baseImageGrab.getWidth();
				int height = baseImageGrab.getHeight();
				baseImageData = new int[width*height];
				baseImageData = (int[]) baseImageGrab.getPixels();
			}
			
			if(actualImageGrab.grabPixels()) {
				int width = actualImageGrab.getWidth();
				int height = actualImageGrab.getHeight();
				actualImageData = new int[width*height];
				actualImageData = (int[]) actualImageGrab.getPixels();
			}
			
			System.out.println(baseImageGrab.getHeight()+"<>"+actualImageGrab.getHeight());
			System.out.println(baseImageGrab.getWidth()+"<>"+actualImageGrab.getWidth());
			
			if(baseImageGrab.getHeight()!=actualImageGrab.getHeight() || baseImageGrab.getWidth()!=actualImageGrab.getWidth())
				compareResult = Result.SizeMismatch;
			else if(Arrays.equals(baseImageData, actualImageData))
				compareResult=Result.Matched;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return compareResult;
		
	}
	
	public static void main(String[] args) {
		
		String srcfile = new File("/home/ckumar/Pictures/Madhu.jpg").getAbsolutePath();
		String actfile = new File("/home/ckumar/Pictures/Madhu.jpg").getAbsolutePath();
		
		System.out.println(compareImage(srcfile, actfile));
		
	}

}
