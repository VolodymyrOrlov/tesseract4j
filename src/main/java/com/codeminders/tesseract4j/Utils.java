package com.codeminders.tesseract4j;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Utils {

    public static ByteBuffer bufferedImageToByteArray(BufferedImage image) throws IOException, InterruptedException {
        PixelGrabber pg = new PixelGrabber(image, 0, 0, -1, -1, true);

        pg.grabPixels();
        
        int[] pixels = (int[]) pg.getPixels();
        
        ByteBuffer out = ByteBuffer.allocate(pixels.length * 4);
        
        out.order(ByteOrder.nativeOrder());
        for (int i = 0; i < pixels.length; i++) {
            out.putInt(pixels[i]);
        }
        out.flip();
        
        return out;
    }
    
    public static BufferedImage getTwoLevelImage(BufferedImage image) {
        return cloneImage(image, BufferedImage.TYPE_BYTE_BINARY);
    }
    
    public static BufferedImage getGrayscaleImage(BufferedImage image) {
    	return cloneImage(image, BufferedImage.TYPE_BYTE_GRAY);
    }
    
    public static String normalizeOutput(String in){
    	String out = in;
    	
    	while(out.endsWith("\n")){
    		out = in.substring(0, out.length() - 1);
    	}
    	return out;
    }
    
    protected static BufferedImage cloneImage(BufferedImage image, int imageType) {
    	BufferedImage tmp = new BufferedImage(image.getWidth(), image.getHeight(), imageType);
        Graphics2D g2 = tmp.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return tmp;
    }

}
