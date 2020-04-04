package com.dzzdsj.demo.codeutils.Excel.JXL;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class JXLReadDemo {
    public static void main(String[] args) throws BiffException, IOException
    {
//        File xlsFile = new File("jxl.xls");
        File xlsFile = new File("D:\\思源\\e福州\\周边新增服务\\20191028\\工伤保险定点医疗机构bak.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表
        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                for (int row = 0; row < rows; row++)
                {
                    for (int col = 0; col < cols; col++)
                    {
                        System.out.printf("%-40s", sheet.getCell(col, row)
                                .getContents());
                    }
                    System.out.println();
                }
            }
        }
        workbook.close();
    }
}
