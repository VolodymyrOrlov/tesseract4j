package com.codeminders.tesseract4j.bridj.enums;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

public enum TessTextlineOrder implements IntValuedEnum<TessTextlineOrder> {

	TEXTLINE_ORDER_LEFT_TO_RIGHT(0),
	TEXTLINE_ORDER_RIGHT_TO_LEFT(1),
	TEXTLINE_ORDER_TOP_TO_BOTTOM(2);

	TessTextlineOrder(long value) {
		this.value = value;
	}

	public final long value;

	public long value() {
		return this.value;
	}

	public Iterator<TessTextlineOrder> iterator() {
		return Collections.singleton(this).iterator();
	}

	public static IntValuedEnum<TessTextlineOrder> fromValue(int value) {
		return FlagSet.fromValue(value, values());
	}

}
