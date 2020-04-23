package Muthu.Framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class initialVariables {
	
	protected static Properties property;
	static FileInputStream inputStream;
	static Workbook Wb;
	static Sheet sheet;
	static Row row;
	static Cell cell_Val;
	static String fpath;
	static Workbook WbTestData;
	static Sheet sheetTestData;
	static Row rowTestKey;
	static Row rowTestVal;
	static Cell cell_ValTestDatakey;
	static Cell cell_ValTestDataVal;
	static String TCname;
	static File file;
	protected static BufferedReader reader;
	protected static WebDriver driver;
	protected WebDriverWait waitdriver;
	protected static BufferedReader br;

	protected HashMap<String,String> hashMapData;
	protected static int GCounter;
	protected static long StartTime;
	protected static String tcName;
	protected static Boolean globalFlag=true;
	
}
