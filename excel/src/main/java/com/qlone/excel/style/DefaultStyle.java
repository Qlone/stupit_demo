package com.qlone.excel.style;

import org.apache.poi.ss.usermodel.*;

import java.io.IOException;

/**
 * @author heweinan
 * @date 2021-05-29 10:51
 */
public class DefaultStyle extends AbstractThreadLocalStyle {
    @Override
    public CellStyle doCreateSytle(Cell cell) {
        try (Workbook workbook = cell.getSheet().getWorkbook()) {
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 12);
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(font);
            DataFormat dataFormat = workbook.createDataFormat();
            cellStyle.setDataFormat(dataFormat.getFormat("@"));
            return cellStyle;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
