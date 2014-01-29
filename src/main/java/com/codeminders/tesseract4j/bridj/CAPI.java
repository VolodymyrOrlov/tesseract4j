package com.codeminders.tesseract4j.bridj;

import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.ann.Library;

import com.codeminders.tesseract4j.bridj.enums.TessOcrEngineMode;
import com.codeminders.tesseract4j.bridj.enums.TessOrientation;
import com.codeminders.tesseract4j.bridj.enums.TessPageIteratorLevel;
import com.codeminders.tesseract4j.bridj.enums.TessPageSegMode;
import com.codeminders.tesseract4j.bridj.enums.TessTextlineOrder;
import com.codeminders.tesseract4j.bridj.enums.TessWritingDirection;
import com.codeminders.tesseract4j.bridj.structs.Boxa;
import com.codeminders.tesseract4j.bridj.structs.ETEXT_DESC;
import com.codeminders.tesseract4j.bridj.structs.Pix;
import com.codeminders.tesseract4j.bridj.structs.Pixa;
import com.codeminders.tesseract4j.bridj.structs.TessBaseAPI;
import com.codeminders.tesseract4j.bridj.structs.TessMutableIterator;
import com.codeminders.tesseract4j.bridj.structs.TessPageIterator;
import com.codeminders.tesseract4j.bridj.structs.TessPolyBlockType;
import com.codeminders.tesseract4j.bridj.structs.TessResultIterator;

@Library("tesseract")
public class CAPI {

    static {
        BridJ.register();
    }

    protected native Pointer<Byte> TessVersion();

    protected native void TessDeleteText(Pointer<Byte> text);

    protected native void TessDeleteTextArray(Pointer<Pointer<Byte>> arr);

    protected native void TessDeleteIntArray(Pointer<Integer> arr);

    protected native Pointer<TessBaseAPI> TessBaseAPICreate();

    protected native void TessBaseAPIDelete(Pointer<TessBaseAPI> handle);

    protected native void TessBaseAPISetInputName(Pointer<TessBaseAPI> handle, Pointer<Byte> name);

    protected native void TessBaseAPISetOutputName(Pointer<TessBaseAPI> handle, Pointer<Byte> name);

    protected native boolean TessBaseAPISetVariable(Pointer<TessBaseAPI> handle, Pointer<Byte> name, Pointer<Byte> value);

    protected native boolean TessBaseAPISetDebugVariable(Pointer<TessBaseAPI> handle, Pointer<Byte> name, Pointer<Byte> value);

    protected native boolean TessBaseAPIGetIntVariable(Pointer<TessBaseAPI> handle, Pointer<Byte> name, Pointer<Integer> value);

    protected native boolean TessBaseAPIGetbooleanVariable(Pointer<TessBaseAPI> handle, Pointer<Byte> name, Pointer<Boolean> value);

    protected native boolean TessBaseAPIGetDoubleVariable(Pointer<TessBaseAPI> handle, Pointer<Byte> name, Pointer<Double> value);

    protected native Pointer<Byte> TessBaseAPIGetStringVariable(Pointer<TessBaseAPI> handle, Pointer<Byte> name);

    protected native boolean TessBaseAPIPrintVariablesToFile(Pointer<TessBaseAPI> handle, Pointer<Byte> filename);

    protected native int TessBaseAPIInit1(Pointer<TessBaseAPI> handle, Pointer<Byte> datapath, Pointer<Byte> language, TessOcrEngineMode oem,
            Pointer<Pointer<Byte>> configs, int configs_size);

    protected native int TessBaseAPIInit2(Pointer<TessBaseAPI> handle, Pointer<Byte> datapath, Pointer<Byte> language, TessOcrEngineMode oem);

    protected native int TessBaseAPIInit3(Pointer<TessBaseAPI> handle, Pointer<Byte> datapath, Pointer<Byte> language);

    protected native Pointer<Byte> TessBaseAPIGetInitLanguagesAsString(Pointer<TessBaseAPI> handle);

    protected native Pointer<Pointer<Byte>> TessBaseAPIGetLoadedLanguagesAsVector(Pointer<TessBaseAPI> handle);

    protected native Pointer<Pointer<Byte>> TessBaseAPIGetAvailableLanguagesAsVector(Pointer<TessBaseAPI> handle);

    protected native int TessBaseAPIInitLangMod(Pointer<TessBaseAPI> handle, Pointer<Byte> datapath, Pointer<Byte> language);

    protected native void TessBaseAPIInitForAnalysePage(Pointer<TessBaseAPI> handle);

    protected native void TessBaseAPIReadConfigFile(Pointer<TessBaseAPI> handle, Pointer<Byte> filename);

    protected native void TessBaseAPIReadDebugConfigFile(Pointer<TessBaseAPI> handle, Pointer<Byte> filename);

    protected native void TessBaseAPISetPageSegMode(Pointer<TessBaseAPI> handle, TessPageSegMode mode);

    protected native TessPageSegMode TessBaseAPIGetPageSegMode(Pointer<TessBaseAPI> handle);

    protected native Pointer<Byte> TessBaseAPIRect(Pointer<TessBaseAPI> handle, Pointer<Byte> imagedata, int bytes_per_pixel, int bytes_per_line, int left,
            int top, int width, int height);

    protected native void TessBaseAPIClearAdaptiveClassifier(Pointer<TessBaseAPI> handle);

    protected native void TessBaseAPISetImage(Pointer<TessBaseAPI> handle, Pointer<Byte> imagedata, int width, int height, int bytes_per_pixel, int bytes_per_line);

    protected native void TessBaseAPISetImage2(Pointer<TessBaseAPI> handle, Pointer<Pix> pix);

    protected native void TessBaseAPISetSourceResolution(Pointer<TessBaseAPI> handle, int ppi);

    protected native void TessBaseAPISetRectangle(Pointer<TessBaseAPI> handle, int left, int top, int width, int height);

    protected native Pointer<Pix> TessBaseAPIGetThresholdedImage(Pointer<TessBaseAPI> handle);

    protected native Pointer<Boxa> TessBaseAPIGetRegions(Pointer<TessBaseAPI> handle, Pointer<Pointer<Pixa>> pixa);

    protected native Pointer<Boxa> TessBaseAPIGetTextlines(Pointer<TessBaseAPI> handle, Pointer<Pointer<Pixa>> pixa, Pointer<Pointer<Integer>> blockids);

    protected native Pointer<Boxa> TessBaseAPIGetStrips(Pointer<TessBaseAPI> handle, Pointer<Pointer<Pixa>> pixa, Pointer<Pointer<Integer>> blockids);

    protected native Pointer<Boxa> TessBaseAPIGetWords(Pointer<TessBaseAPI> handle, Pointer<Pointer<Pixa>> pixa);

    protected native Pointer<Boxa> TessBaseAPIGetConnectedComponents(Pointer<TessBaseAPI> handle, Pointer<Pointer<Pixa>> cc);

    protected native Pointer<Boxa> TessBaseAPIGetComponentImages(Pointer<TessBaseAPI> handle, TessPageIteratorLevel level, boolean text_only,
            Pointer<Pointer<Pixa>> pixa, Pointer<Pointer<Integer>> blockids);

    protected native int TessBaseAPIGetThresholdedImageScaleFactor(Pointer<TessBaseAPI> handle);

    protected native void TessBaseAPIDumpPGM(Pointer<TessBaseAPI> handle, Pointer<Byte> filename);

    protected native Pointer<TessPageIterator> TessBaseAPIAnalyseLayout(Pointer<TessBaseAPI> handle);

    protected native int TessBaseAPIRecognize(Pointer<TessBaseAPI> handle, Pointer<ETEXT_DESC> monitor);

    protected native int TessBaseAPIRecognizeForChopTest(Pointer<TessBaseAPI> handle, Pointer<ETEXT_DESC> monitor);

    protected native Pointer<Byte> TessBaseAPIProcessPages(Pointer<TessBaseAPI> handle, Pointer<Byte> filename, Pointer<Byte> retry_config, int timeout_millisec);

    protected native Pointer<Byte> TessBaseAPIProcessPage(Pointer<TessBaseAPI> handle, Pointer<Pix> pix, int page_index, Pointer<Byte> filename,
            Pointer<Byte> retry_config, int timeout_millisec);

    protected native Pointer<TessResultIterator> TessBaseAPIGetIterator(Pointer<TessBaseAPI> handle);

    protected native Pointer<TessMutableIterator> TessBaseAPIGetMutableIterator(Pointer<TessBaseAPI> handle);

    protected native Pointer<Byte> TessBaseAPIGetUTF8Text(Pointer<TessBaseAPI> handle);

    protected native Pointer<Byte> TessBaseAPIGetHOCRText(Pointer<TessBaseAPI> handle, int page_number);

    protected native Pointer<Byte> TessBaseAPIGetBoxText(Pointer<TessBaseAPI> handle, int page_number);

    protected native Pointer<Byte> TessBaseAPIGetUNLVText(Pointer<TessBaseAPI> handle);

    protected native int TessBaseAPIMeanTextConf(Pointer<TessBaseAPI> handle);

    protected native Pointer<Integer> TessBaseAPIAllWordConfidences(Pointer<TessBaseAPI> handle);

    protected native boolean TessBaseAPIAdaptToWordStr(Pointer<TessBaseAPI> handle, TessPageSegMode mode, Pointer<Byte> wordstr);

    protected native void TessBaseAPIClear(Pointer<TessBaseAPI> handle);

    protected native void TessBaseAPIEnd(Pointer<TessBaseAPI> handle);

    protected native int TessBaseAPIIsValidWord(Pointer<TessBaseAPI> handle, Pointer<Byte> word);

    protected native boolean TessBaseAPIGetTextDirection(Pointer<TessBaseAPI> handle, Pointer<Integer> out_offset, Pointer<Float> out_slope);

    protected native Pointer<Byte> TessBaseAPIGetUnichar(Pointer<TessBaseAPI> handle, int unichar_id);

    protected native void TessBaseAPISetMinOrientationMargin(Pointer<TessBaseAPI> handle, double margin);

    /* Page iterator */

    protected native void TessPageIteratorDelete(Pointer<TessPageIterator> handle);

    protected native Pointer<TessPageIterator> TessPageIteratorCopy(Pointer<TessPageIterator> handle);

    protected native void TessPageIteratorBegin(Pointer<TessPageIterator> handle);

    protected native boolean TessPageIteratorNext(Pointer<TessPageIterator> handle, TessPageIteratorLevel level);

    protected native boolean TessPageIteratorIsAtBeginningOf(Pointer<TessPageIterator> handle, TessPageIteratorLevel level);

    protected native boolean TessPageIteratorIsAtFinalElement(Pointer<TessPageIterator> handle, TessPageIteratorLevel level, TessPageIteratorLevel element);

    protected native boolean TessPageIteratorBoundingBox(Pointer<TessPageIterator> handle, TessPageIteratorLevel level, Pointer<Integer> left,
            Pointer<Integer> top, Pointer<Integer> right, Pointer<Integer> bottom);

    protected native TessPolyBlockType TessPageIteratorBlockType(Pointer<TessPageIterator> handle);

    protected native Pointer<Pix> TessPageIteratorGetBinaryImage(Pointer<TessPageIterator> handle, TessPageIteratorLevel level);

    protected native Pointer<Pix> TessPageIteratorGetImage(Pointer<TessPageIterator> handle, TessPageIteratorLevel level, int padding, Pointer<Integer> left,
            Pointer<Integer> top);

    protected native boolean TessPageIteratorBaseline(Pointer<TessPageIterator> handle, TessPageIteratorLevel level, Pointer<Integer> x1, Pointer<Integer> y1,
            Pointer<Integer> x2, Pointer<Integer> y2);

    protected native void TessPageIteratorOrientation(Pointer<TessPageIterator> handle, Pointer<TessOrientation> orientation,
            Pointer<TessWritingDirection> writing_direction, Pointer<TessTextlineOrder> textline_order, Pointer<Float> deskew_angle);

    /* Result iterator */

    protected native void TessResultIteratorDelete(Pointer<TessResultIterator> handle);

    protected native Pointer<TessResultIterator> TessResultIteratorCopy(Pointer<TessResultIterator> handle);

    protected native Pointer<TessPageIterator> TessResultIteratorGetPageIterator(Pointer<TessResultIterator> handle);

    protected native Pointer<TessPageIterator> TessResultIteratorGetPageIteratorConst(Pointer<TessResultIterator> handle);

    protected native Pointer<Byte> TessResultIteratorGetUTF8Text(Pointer<TessResultIterator> handle, TessPageIteratorLevel level);

    protected native float TessResultIteratorConfidence(Pointer<TessResultIterator> handle, TessPageIteratorLevel level);

    protected native Pointer<Byte> TessResultIteratorWordFontAttributes(Pointer<TessResultIterator> handle, Pointer<Boolean> is_bold, Pointer<Boolean> is_italic,
            Pointer<Boolean> is_underlined, Pointer<Boolean> is_monospace, Pointer<Boolean> is_serif, Pointer<Boolean> is_smallcaps,
            Pointer<Integer> pointsize, Pointer<Integer> font_id);

    protected native boolean TessResultIteratorWordIsFromDictionary(Pointer<TessResultIterator> handle);

    protected native boolean TessResultIteratorWordIsNumeric(Pointer<TessResultIterator> handle);

    protected native boolean TessResultIteratorSymbolIsSuperscript(Pointer<TessResultIterator> handle);

    protected native boolean TessResultIteratorSymbolIsSubscript(Pointer<TessResultIterator> handle);

    protected native boolean TessResultIteratorSymbolIsDropcap(Pointer<TessResultIterator> handle);

}
