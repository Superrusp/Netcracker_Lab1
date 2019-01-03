package output;

import analyzer.Analyzer;
import analyzer.Reflector;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sorters.abstraction.AbstractSorter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * This class is used to work with Excel.
 * Creates results about sorting time of different arrays and
 * write them to a file with <b>xlsx</b> format.
 *
 * @author Amir Dogmosh
 */
public class ExcelWorker {
    /**
     * This method is used to write all results in an Excel file.
     * Creates sheets in a book that match the name of the filler via reflection.
     */
    public void writeToFile(){
        try (FileOutputStream stream = new FileOutputStream(new File("C:\\Users\\PC\\Documents\\Results.xlsx"))){

            Reflector reflector = new Reflector();
            Set<Method> methods = new HashSet<>();
            Analyzer analyzer = new Analyzer();

            int[] array = analyzer.generateArraySizes(10);

            XSSFWorkbook workbook = new XSSFWorkbook();
            for (Method method : reflector.getFillers(methods)) {
                XSSFSheet sheet = workbook.createSheet(reflector.getFillerName(method));
                createTittleRow(sheet);

                XSSFRow sorterNamesRow = sheet.createRow(1);

                XSSFRow[] arraySizeRows = new XSSFRow[array.length];
                for (int i = 0; i < arraySizeRows.length; i++) {
                    Set<AbstractSorter> sorters = new LinkedHashSet<>();
                    arraySizeRows[i] = sheet.createRow(i+2);

                    int j = 1;
                    for (AbstractSorter sorter : reflector.getObjects(sorters)) {
                        sorterNamesRow.createCell(j).setCellValue(reflector.getSorterName(sorter));
                        arraySizeRows[i].createCell(0).setCellValue(array[i]);
                        arraySizeRows[i].createCell(j)
                                .setCellValue(analyzer.getSortTime(method, sorter, array[i]));
                        sheet.autoSizeColumn(j-1);
                        j++;
                    }
                }
            }
            workbook.write(stream);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is used to create tittle row in Excel file.
     *
     * @param sheet sheet of the book in which the row is created.
     * @see #writeToFile().
     */
    private void createTittleRow(XSSFSheet sheet){
        XSSFRow tittleRow = sheet.createRow(0);
        tittleRow.createCell(0).setCellValue("ARRAY SIZE");
        tittleRow.createCell(1).setCellValue("SORTER NAME");
    }

    public static void main(String[] args) {
        ExcelWorker worker = new ExcelWorker();
        worker.writeToFile();
    }
}
