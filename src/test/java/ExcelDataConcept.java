import org.apache.poi.ss.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Workbook;
        import org.apache.poi.ss.usermodel.WorkbookFactory;

        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;

public class ExcelDataConcept {

    FileInputStream fileInputStream= null;

    static Workbook workbook;
    static  Sheet sheet;
    static  Object data[][];

    public static Object[][] getData(String Sheetname) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(Sheetname);

        workbook= WorkbookFactory.create(fileInputStream);

        sheet= workbook.getSheet(Sheetname);

        for(int i=1; i<=sheet.getLastRowNum();i++)
            for(int j=1;j<=sheet.getRow(i).getLastCellNum();j++)
                data[i][j]=sheet.getRow(i).getCell(j).toString();

        return data;
    }

}
