package com.codeminders.tesseract4j.bridj.enums;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

public enum TessOrientation implements IntValuedEnum<TessOrientation> {

	ORIENTATION_PAGE_UP(0),
	ORIENTATION_PAGE_RIGHT(1),
	ORIENTATION_PAGE_DOWN(2),
	ORIENTATION_PAGE_LEFT(3);

	TessOrientation(long value) {
		this.value = value;
	}

	public final long value;

	public long value() {
		return this.value;
	}

	public Iterator<TessOrientation> iterator() {
		return Collections.singleton(this).iterator();
	}

	public static IntValuedEnum<TessOrientation> fromValue(int value) {
		return FlagSet.fromValue(value, values());
	}

}
