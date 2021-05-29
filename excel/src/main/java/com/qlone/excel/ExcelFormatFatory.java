package com.qlone.excel;

import com.qlone.excel.pharse.EasyExcelReader;
import com.qlone.excel.pharse.EasyExcelWriter;

import java.util.List;

/**
 * @author heweinan
 * @date 2021-05-29 09:45
 */
public class ExcelFormatFatory {

    public static <T> EasyExcelWriter<T> easyExcelWriter(Class<T> type, List<T> data) {
        return new EasyExcelWriter<>(type, data);
    }

    public static <T> EasyExcelReader<T> easyExcelReader(Class<T> type) {
        return new EasyExcelReader<>(type);
    }


}
