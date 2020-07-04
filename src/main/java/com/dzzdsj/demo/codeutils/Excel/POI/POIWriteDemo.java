package com.dzzdsj.demo.codeutils.Excel.POI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIWriteDemo {
    public static void main(String[] args) throws IOException {
        /**xls*/
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");

        for (int row = 0; row < 10; row++) {
            HSSFRow rows = sheet.createRow(row);
            for (int col = 0; col < 10; col++) {
                // 向工作表中添加数据
                rows.createCell(col).setCellValue("data" + row + col);
            }
        }

//        File xlsFile = new File("poi.xls");
        File xlsFile = new File("D:/test/poi.xls");
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
        /**xlsx*/
        // 创建工作薄
        XSSFWorkbook xworkbook = new XSSFWorkbook();
        // 创建工作表
        XSSFSheet xsheet = xworkbook.createSheet("sheet1");

        for (int row = 0; row < 10; row++) {
            XSSFRow rows = xsheet.createRow(row);
            for (int col = 0; col < 10; col++) {
                // 向工作表中添加数据
                rows.createCell(col).setCellValue("data" + row + col);
            }
        }
        File xlsxFile = new File("D:/test/poi.xlsx");
        FileOutputStream xlsxStream = new FileOutputStream(xlsxFile);
        xworkbook.write(xlsxStream);

    }
}
