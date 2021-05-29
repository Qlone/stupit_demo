package com.qlone.excel.style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

/**
 * @author heweinan
 * @date 2021-05-29 10:39
 */
public class FontRedStyle extends AbstractThreadLocalStyle {
    @Override
    public CellStyle doCreateSytle(Cell cell) {
        try {
            try (Workbook workbook = cell.getSheet().getWorkbook()) {
                Font font = workbook.createFont();
                font.setColor(Font.COLOR_RED);
                font.setFontHeightInPoints((short) 12);
                //这玩意不能创建太多
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setFont(font);
                return cellStyle;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
