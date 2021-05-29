package com.qlone.excel.style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * @author heweinan
 * @date 2021-05-29 10:33
 */
public abstract class AbstractThreadLocalStyle implements CellStyleCreator {

    private final ThreadLocal<CellStyle> THREAD_LOCAL_STYLE = new ThreadLocal<>();

    @Override
    public CellStyle createStyle(Cell cell) {
        CellStyle cellStyle = THREAD_LOCAL_STYLE.get();
        if (cellStyle == null) {
            cellStyle = doCreateSytle(cell);
            THREAD_LOCAL_STYLE.set(cellStyle);
        }
        return cellStyle;
    }

    public abstract CellStyle doCreateSytle(Cell cell);

    public void releaseStyle() {
        THREAD_LOCAL_STYLE.remove();
    }
}
