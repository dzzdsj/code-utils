package com.dzzdsj.demo.codeutils.Excel.JXL;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

/**
 * 似乎不支持xlsx
 */
public class JXLWriteDemo {
    public static void main(String[] args) throws IOException, WriteException
    {
//        File xlsFile = new File("D:\\test\\jxl.xls");
        File xlsFile = new File("D:\\/test\\/jxl.xls");
        // 创建一个工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
        // 创建一个工作表
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                // 向工作表中添加数据
                sheet.addCell(new Label(col, row, "data" + row + col));
            }
        }
        workbook.write();
        workbook.close();
    }
}
