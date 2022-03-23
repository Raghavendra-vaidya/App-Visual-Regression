package com.visual.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GetData {


    public static String fromProperties(String key, String fileName) {
        String data = null;
        File configFile = new File("src/main/resources/" + fileName + ".properties");

        try {
            FileInputStream fis = new FileInputStream(configFile);
            Properties prop = new Properties();
            prop.load(fis);
            data = (String) prop.get(key);
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String fromExcel(String fileName, String sheetName, int rIndex, int cIndex ){
        String data  = null;
        File file  = new File("test-data/"+fileName);
        try{
            FileInputStream fis  =  new FileInputStream(file);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Row row = sheet.getRow(rIndex);
            Cell c = row.getCell(cIndex);
            DataFormatter formatter =  new DataFormatter();
            data = formatter.formatCellValue(c);
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("Unable to fetch data");
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println(fromProperties("HOST", "configFile"));
    }
}
