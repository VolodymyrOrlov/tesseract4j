package com.codeminders.tesseract4j.mapping;

import com.codeminders.tesseract4j.mapping.structs.TessBaseAPI;
import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CAPI extends Library {
    
    static final CAPI INSTANCE = (CAPI) Native.loadLibrary("tesseract", CAPI.class);
    
    String TessVersion();

    TessBaseAPI TessBaseAPICreate();

    void TessBaseAPIDelete(TessBaseAPI handle);

    int TessBaseAPIInit3(TessBaseAPI handle, String datapath, String language);

    void TessBaseAPIClear(TessBaseAPI handle);
  
    void TessBaseAPIEnd(TessBaseAPI handle);

}
