package com.codeminders.tesseract4j.bridj.enums;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

public enum TessPageIteratorLevel implements IntValuedEnum<TessPageIteratorLevel> {
	
	RIL_BLOCK(0),
	RIL_PARA(1),
	RIL_TEXTLINE(2),
	RIL_WORD(3),
	RIL_SYMBOL(4);
	
	TessPageIteratorLevel(long value) {
            this.value = value;
    }
	
    public final long value;
    
    public long value() {
            return this.value;
    }
    
    public Iterator<TessPageIteratorLevel> iterator() {
            return Collections.singleton(this).iterator();
    }
    
    public static IntValuedEnum<TessPageIteratorLevel> fromValue(int value) {
            return FlagSet.fromValue(value, values());
    }

}
