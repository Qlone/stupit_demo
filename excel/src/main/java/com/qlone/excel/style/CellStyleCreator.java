package com.qlone.excel.style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * @author heweinan
 * @date 2021-05-29 10:28
 */
public interface CellStyleCreator {

    CellStyle createStyle(Cell cell);

}
