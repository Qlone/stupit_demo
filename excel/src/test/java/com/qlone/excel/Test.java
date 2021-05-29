package com.qlone.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author heweinan
 * @date 2021-05-29 11:00
 */
public class Test {

    public static void main(String[] str) throws IOException {
        int num = 0;
        int size = 0;
        while (size++ < 30000) {
            List<ExcelData> datas = new ArrayList<>();
            for (int i = 0; i < 600; i++) {
                ExcelData excelData = new ExcelData();
                excelData.setCow_1("*" + UUID.randomUUID().toString());
                excelData.setCow_2(UUID.randomUUID().toString());
                excelData.setCow_3(UUID.randomUUID().toString());
                excelData.setCow_4(UUID.randomUUID().toString());
                datas.add(excelData);
            }
            String fileName = "./Documents/temp/" + UUID.randomUUID().toString() + ".xls";
            File file = new File(fileName);
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println(String.format("%s , %s, %s", num++, newFile, fileName));
            }
            try (InputStream write = ExcelFormatFatory.easyExcelWriter(ExcelData.class, datas).write();
                 FileOutputStream fos = new FileOutputStream(fileName)) {
                byte[] b = new byte[1024];
                int length;
                while ((length = write.read(b)) > 0) {
                    fos.write(b, 0, length);
                }
            }
        }
    }
}
