package com.codeminders.tesseract4j;

import org.bridj.Pointer;

import com.codeminders.tesseract4j.bridj.CAPI;
import com.codeminders.tesseract4j.bridj.structs.TessBaseAPI;

public class BaseAPI extends CAPI {

    private Pointer<TessBaseAPI> handle;

    public BaseAPI(String datapath, String language) {
        handle = this.TessBaseAPICreate();
        TessBaseAPIInit3(handle, Pointer.pointerToCString(datapath), Pointer.pointerToCString(language));
    }

    public BaseAPI(String language) {
        this(null, language);
    }

    public void clear() {
        TessBaseAPIClear(handle);
    }

    public void end() {
        TessBaseAPIEnd(handle);
    }

    public String version() {
        return TessVersion().getCString();
    }

}
