package output;

import analyzer.Analyzer;
import analyzer.Reflector;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import org.apache.poi.xssf.usermodel.charts.XSSFLineChartData;
import org.apache.poi.xssf.usermodel.charts.XSSFValueAxis;
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
     * The number of title rows in Excel file.
     */
    private static final int NUM_OF_TITLE_ROWS = 2;
    /**
     * The number of rows assigned to define the size of the array.
     */
    private static final int NUM_OF_ARRAY_SIZE_ROWS = 10;
    /**
     * The number of columns.
     */
    private static final int NUM_OF_COLUMNS = 9;
    /**
     * The collection of sorter names which is used to insert values ​​in the legend.
     */
    private ArrayList<String> sorterNames;
    /**
     * This method is used to write all results in an Excel file.
     * Creates sheets in a book that match the name of the filler via reflection.
     */
    public void writeToFile(){
        try (FileOutputStream stream = new FileOutputStream(new File("Results.xlsx"))){

            sorterNames = new ArrayList<>();
            Reflector reflector = new Reflector();
            Set<Method> methods = new HashSet<>();
            Analyzer analyzer = new Analyzer();

            int[] arraySizes = analyzer.generateArraySizes(NUM_OF_ARRAY_SIZE_ROWS);

            XSSFWorkbook workbook = new XSSFWorkbook();
            for (Method method : reflector.getFillers(methods)) {
                XSSFSheet sheet = workbook.createSheet(reflector.getFillerName(method));
                createTitleRow(sheet);

                XSSFRow sorterNamesRow = sheet.createRow(1);

                XSSFRow[] arraySizeRows = new XSSFRow[NUM_OF_ARRAY_SIZE_ROWS];
                for (int rowIndex = 0; rowIndex < NUM_OF_ARRAY_SIZE_ROWS; rowIndex++) {
                    Set<AbstractSorter> sorters = new LinkedHashSet<>();
                    arraySizeRows[rowIndex] = sheet.createRow(rowIndex+ NUM_OF_TITLE_ROWS);

                    int colIndex = 0;
                    for (AbstractSorter sorter : reflector.getObjects(sorters)) {
                        sorterNames.add(reflector.getSorterName(sorter));
                        sorterNamesRow.createCell(colIndex+1).setCellValue(sorterNames.get(colIndex));
                        arraySizeRows[rowIndex].createCell(0).setCellValue(arraySizes[rowIndex]);
                        arraySizeRows[rowIndex].createCell(colIndex+1)
                                .setCellValue(analyzer.getSortTime(method, sorter, arraySizes[rowIndex]));
                        sheet.autoSizeColumn(colIndex);
                        colIndex++;
                    }
                }
                createChart(sheet);
            }
            workbook.write(stream);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is used to create title row in Excel file.
     *
     * @param sheet sheet of the book in which the row is created.
     * @see #writeToFile().
     */
    private void createTitleRow(XSSFSheet sheet){
        XSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("ARRAY SIZE");
        titleRow.createCell(1).setCellValue("SORTER NAME");
    }

    /**
     * This method is used to draw charts on each sheet of workbook.
     *
     * @param sheet the sheet of workbook in Excel file.
     * @see #writeToFile().
     */
    private void createChart(XSSFSheet sheet){
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0,0,0,0,0,12,10,24);

        XSSFChart chart = drawing.createChart(anchor);
        XSSFChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.BOTTOM);

        XSSFLineChartData data = chart.getChartDataFactory().createLineChartData();

        XSSFValueAxis bottomAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.BOTTOM);
        XSSFValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        createSeries(createChartDataSources(sheet), data);

        chart.plot(data, bottomAxis, leftAxis);
    }

    /**
     * This method is used to define Data sources for the chart.
     *
     * @param sheet the sheet of workbook in Excel file.
     * @return the collection of <b>ChartDataSource<Number> </b> which is used to create chart series.
     * @see #createSeries(ArrayList, XSSFLineChartData).
     */
    private ArrayList<ChartDataSource<Number>>  createChartDataSources(XSSFSheet sheet){
        ArrayList<ChartDataSource<Number>> chartDataSources = new ArrayList<>();
        for(int i = 0; i < NUM_OF_COLUMNS; i++) {
            chartDataSources.add(DataSources.fromNumericCellRange(sheet,
                    new CellRangeAddress(2, 11, i , i )));
        }
        return chartDataSources;
    }

    /**
     * This method is used to set title on each chart.
     *
     * @param chartDataSources the collection is used to
     * @param data values for the chart.
     * @see #writeToFile().
     */
    private void createSeries(ArrayList<ChartDataSource<Number>> chartDataSources, XSSFLineChartData data){
        ArrayList<LineChartSeries> series = new ArrayList<>();
        for(int j=0; j < chartDataSources.size()-1; j++) {
            series.add(data.addSeries(chartDataSources.get(0), chartDataSources.get(j + 1)));
            series.get(j).setTitle(sorterNames.get(j));
        }
    }

    public static void main(String[] args) {
        ExcelWorker worker = new ExcelWorker();
        worker.writeToFile();
    }
}
