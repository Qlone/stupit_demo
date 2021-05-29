package com.qlone.excel.pharse;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.InputStream;
import java.util.List;

/**
 * @author heweinan
 * @date 2021-05-29 10:14
 */
public class EasyExcelReader<T> {
    public Class<T> type;

    public EasyExcelReader(Class<T> type){
        this.type = type;
    }

    public List<T> read(InputStream inputStream){
        return EasyExcel.read(inputStream)
                .head(type)
                .excelType(ExcelTypeEnum.XLS)
                .sheet()
                .doReadSync();
    }
}
