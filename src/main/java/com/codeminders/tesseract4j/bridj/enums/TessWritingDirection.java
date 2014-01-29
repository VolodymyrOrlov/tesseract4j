package com.codeminders.tesseract4j.bridj.enums;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

public enum TessWritingDirection implements IntValuedEnum<TessWritingDirection> {

	WRITING_DIRECTION_LEFT_TO_RIGHT(0),
	WRITING_DIRECTION_RIGHT_TO_LEFT(1),
	WRITING_DIRECTION_TOP_TO_BOTTOM(2);

	TessWritingDirection(long value) {
		this.value = value;
	}

	public final long value;

	public long value() {
		return this.value;
	}

	public Iterator<TessWritingDirection> iterator() {
		return Collections.singleton(this).iterator();
	}

	public static IntValuedEnum<TessWritingDirection> fromValue(int value) {
		return FlagSet.fromValue(value, values());
	}

}
