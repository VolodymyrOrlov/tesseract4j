package com.codeminders.tesseract4j.bridj.enums;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

public enum TessOcrEngineMode implements IntValuedEnum<TessOcrEngineMode> {

	OEM_TESSERACT_ONLY(0), OEM_CUBE_ONLY(1), OEM_TESSERACT_CUBE_COMBINED(2), OEM_DEFAULT(
			3);

	TessOcrEngineMode(long value) {
		this.value = value;
	}

	public final long value;

	public long value() {
		return this.value;
	}

	public Iterator<TessOcrEngineMode> iterator() {
		return Collections.singleton(this).iterator();
	}

	public static IntValuedEnum<TessOcrEngineMode> fromValue(int value) {
		return FlagSet.fromValue(value, values());
	}

}
