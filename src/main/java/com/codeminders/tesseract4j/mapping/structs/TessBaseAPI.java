package com.codeminders.tesseract4j.mapping.structs;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class TessBaseAPI extends PointerType {
	
	public TessBaseAPI(Pointer address) {
        super(address);
    }

    public TessBaseAPI() {
        super();
    }

}
