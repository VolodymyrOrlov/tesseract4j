package com.codeminders.tesseract4j;

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
    
}
