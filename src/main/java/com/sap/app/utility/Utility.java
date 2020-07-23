package com.sap.app.utility;

import com.sap.app.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class Utility extends BaseClass {

    public static String TESTDATA_SHEET_PATH=System.getProperty("user.dir")+"/src/main/java/com/sap/app/testdata/TestData.xlsx";
    public static Object[][] data;

    public static Object[][] getData(String testCaseName, String sheetName){
        {
            Xls_Reader xls = new Xls_Reader(TESTDATA_SHEET_PATH);
            int testStartRowNum = 1;
            while (!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)) {
                testStartRowNum++;
            }
            int colStartRowNum = testStartRowNum + 1;
            int dataStartRowNum = testStartRowNum + 2;
            int rows = 0;
            while (!xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
                rows++;
            }
            int cols = 0;
            while (!xls.getCellData(sheetName, cols, colStartRowNum).equals("")) {
                cols++;
            }
            data = new Object[rows][1];
            Hashtable<Object,Object> hashtable= null;
            int dataRow=0;
            for (int rnum = dataStartRowNum; rnum < dataStartRowNum + rows; rnum++) {
                hashtable= new Hashtable<Object, Object>();
                for (int cnum = 0; cnum < cols; cnum++) {
                    String key=xls.getCellData(sheetName,cnum,colStartRowNum);
                    String value=xls.getCellData(sheetName,cnum,rnum);
                    hashtable.put(key,value);
                }
                data[dataRow][0]=hashtable;
                dataRow++;
            }
        }
        return data;
    }

    public static String captureScreenShot(String methodname){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/Screenshots/"+methodname+"_"+timeStamp+".png";
        File destination=new File(path);
        try {
            FileUtils.copyFile(source,destination);
        } catch (Exception e) {
            System.out.println("Exception While Taking ScreenShot"+e.getMessage());
        }

        return path;

    }
}
