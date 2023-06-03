package ML_part.ML;

import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Conversion {


    public class ReplaceAndSaveCsv{
        // Replace characters in a cell of an Excel spreadsheet and save it in csv file using opencsv 5.2
        public static void replaceCharactersInExcelAndSaveAsCsv(String excelFilePath, String csvFilePath, String oldString, String newString) throws Exception {
            // Open the Excel file
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0); // assume the sheet you want to modify is the first sheet

            sheet.shiftColumns(1, 1, -1);



            for (Row row: sheet){
                for (Cell cell : row){
                    String cellValue = cell.getStringCellValue();
                    cellValue = cellValue.replaceAll(oldString, newString); // replace oldChar with newChar in the cell value
                    cell.setCellValue(cellValue); // update the cell value

                    if (cellValue.isBlank() || cellValue.isEmpty()){
                        cell.setCellValue("Na");
                    }
                }
            }




            // Write the modified sheet to a csv file using opencsv
            FileOutputStream fos = new FileOutputStream(csvFilePath);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            CSVWriter writer = new CSVWriter(osw);
            List<String[]> data = new ArrayList<>();
            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    if (cell.getStringCellValue().isBlank() || cell.getStringCellValue().isEmpty() ){
                        cell.setCellValue("Na");
                    }
                    rowData.add(cell.getStringCellValue());
                }
                while (rowData.size()<21) {
                    rowData.add("Na");
                }
                data.add(rowData.toArray(new String[0]));
            }
            writer.writeAll(data);
            writer.close();
        }


    }

    public class ConvertArff{
        // Convert a csv file to arff file using weka
        public static void convertCsvToArff(String csvFilePath, String arffFilePath) throws Exception {
            // Load the csv file
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(csvFilePath));
            Instances data = loader.getDataSet();

            // Save the data as an arff file
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File(arffFilePath));
            saver.writeBatch();
        }
    }





    public static void main(String[] args) throws Exception {

        ReplaceAndSaveCsv.replaceCharactersInExcelAndSaveAsCsv("src/main/java/org/example/data/data.xlsx","src/main/java/org/example/data/dataFinale1.csv","[??*�????+'\",$:!)(\\[\\]{}�]","");
        ConvertArff.convertCsvToArff("src/main/java/org/example/data/dataFinale1.csv","src/main/java/org/example/data/dataFinale2.arff");
    }
}

