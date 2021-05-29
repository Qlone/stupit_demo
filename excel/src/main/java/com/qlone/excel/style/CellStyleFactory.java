package com.qlone.excel.style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * @author heweinan
 * @date 2021-05-29 10:38
 */
public class CellStyleFactory {
    private static final FontRedStyle FONT_RED_STYLE = new FontRedStyle();
    private static final DefaultStyle NORMAL_STYLE_BUILD = new DefaultStyle();

    public static CellStyle style(Cell cell) {
        String value = cell.getStringCellValue();
        if (value.startsWith("*")) {
            return FONT_RED_STYLE.createStyle(cell);
        } else {
            return NORMAL_STYLE_BUILD.createStyle(cell);
        }
    }

    public static void release() {
        FONT_RED_STYLE.releaseStyle();
        NORMAL_STYLE_BUILD.releaseStyle();
    }
}
