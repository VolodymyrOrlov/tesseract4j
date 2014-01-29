package com.codeminders.tesseract4j.bridj.enums;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

public enum TessPageSegMode implements IntValuedEnum<TessPageSegMode> {
	
	PSM_OSD_ONLY(0),
	PSM_AUTO_OSD(1),
	PSM_AUTO_ONLY(2),
	PSM_AUTO(3),
	PSM_SINGLE_COLUMN(4),
	PSM_SINGLE_BLOCK_VERT_TEXT(5),
    PSM_SINGLE_BLOCK(6),
    PSM_SINGLE_LINE(7),
    PSM_SINGLE_WORD(8),
    PSM_CIRCLE_WORD(9),
    PSM_SINGLE_CHAR(10),
    PSM_SPARSE_TEXT(11),
    PSM_SPARSE_TEXT_OSD(12),
    PSM_COUNT(13);
	
	TessPageSegMode(long value) {
            this.value = value;
    }
	
    public final long value;
    
    public long value() {
            return this.value;
    }
    
    public Iterator<TessPageSegMode > iterator() {
            return Collections.singleton(this).iterator();
    }
    
    public static IntValuedEnum<TessPageSegMode > fromValue(int value) {
            return FlagSet.fromValue(value, values());
    }

}
