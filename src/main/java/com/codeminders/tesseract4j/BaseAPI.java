package com.codeminders.tesseract4j;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import com.codeminders.tesseract4j.mapping.CAPI;
import com.codeminders.tesseract4j.mapping.structs.TessBaseAPI;

public class BaseAPI {
    
    private TessBaseAPI handle;
    private CAPI api = CAPI.INSTANCE;

    public BaseAPI(String datapath, String language){
        handle = api.TessBaseAPICreate();
        api.TessBaseAPIInit3(handle, datapath, language);
    }

    public BaseAPI(String language) {
        this(null, language);
    }
    
    @Override
    protected void finalize() throws Throwable {
        if(handle != null){
            api.TessBaseAPIDelete(handle);
        }
    }

    public void clear() {
        if(handle != null){
            api.TessBaseAPIClear(handle);
        }
    }

    public void end() {
        if(handle != null){
            api.TessBaseAPIEnd(handle);
        }
    }
    
    public String version() {
        return api.TessVersion();
        
    }
    
    public String tesseractRect(byte[] data) throws IOException, InterruptedException{
        return tesseractRect(ImageIO.read(new ByteArrayInputStream(data)));
    }
    
    public String tesseractRect(InputStream in) throws IOException, InterruptedException{
        return tesseractRect(ImageIO.read(in));
    }
    
    public String tesseractRect(ByteBuffer imageData, int bytesPerPixel, int bytesPerLine, int left, int top, int width, int height){
        return Utils.normalizeOutput(api.TessBaseAPIRect(handle, imageData, bytesPerPixel, bytesPerLine, left, top, width, height));
    }
    
    public String tesseractRect(BufferedImage image) throws IOException, InterruptedException{
        return tesseractRect(Utils.bufferedImageToByteArray(Utils.getTwoLevelImage(image)), 4, image.getWidth() * 4, 0, 0, image.getWidth(), image.getHeight());
    }
    
    public String tesseractRect(File image) throws IOException, InterruptedException{
        return tesseractRect(ImageIO.read(image));
    }
    
    public String getUTF8Text(){
        return api.TessBaseAPIGetUTF8Text(handle);
    }
    
}
