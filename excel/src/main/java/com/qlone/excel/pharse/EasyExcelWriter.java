package com.qlone.excel.pharse;

import com.Ostermiller.util.CircularByteBuffer;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author heweinan
 * @date 2021-05-29 10:00
 */
public class EasyExcelWriter<T> {

    public Class<T> type;

    public List<T> datas;

    /**
     * 将output转换为input，此处为单线程案例
     * CircularByteBuffer cbb = new CircularByteBuffer(CircularByteBuffer.INFINITE_SIZE);
     * class1.putDataOnOutputStream(cbb.getOutputStream);
     * class2.processDataFromInputStream(cbb.getInputStream)
     */
    CircularByteBuffer cbb = new CircularByteBuffer(CircularByteBuffer.INFINITE_SIZE);

    public EasyExcelWriter(Class<T> type, List<T> datas) {
        this.type = type;
        this.datas = datas;
    }

    public InputStream write() throws IOException {
        try (OutputStream outputStream = cbb.getOutputStream();
             StyleHandler styleHandler = new StyleHandler()) {
            EasyExcel.write(outputStream, this.type)
                    .registerWriteHandler(styleHandler)
                    //此处为 .xls结尾都文件,决定最终生成都workbook
                    .excelType(ExcelTypeEnum.XLS)
                    .sheet()
                    .doWrite(this.datas);
        }
        return cbb.getInputStream();
    }

}
