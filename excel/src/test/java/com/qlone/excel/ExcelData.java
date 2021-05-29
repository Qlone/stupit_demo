package com.qlone.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author heweinan
 * @date 2021-05-29 11:13
 */
@Data
public class ExcelData {

    @ExcelProperty(value = "row1")
    private String cow_1;

    @ExcelProperty(value = "row2")
    private String cow_2;

    @ExcelProperty(value = "row3")
    private String cow_3;

    @ExcelProperty(value = "row4")
    private String cow_4;

    @ExcelProperty(value = "row5")
    private String cow_5;

    @ExcelProperty(value = "row6")
    private String cow_6;
}
