package com.splitscale.reems;

import com.splitscale.reems.services.FileExporter;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelExporterInteractor implements FileExporter {

  @Override
  public Workbook createFile() {
    ExcelExporter excelExporter = new ExcelExporter();

    // TODO: Generate or fetch the data to export
    List<List<Object>> data = generateData();

    // Export the data to Excel workbook
    Workbook workbook = excelExporter.exportToExcel(data);

    return workbook;
  }

  @Override
  public Byte[] fileToBytes(Object file) {
    if (file instanceof Workbook) {
      Workbook workbook = (Workbook) file;

      // Create an instance of FileToByteConverter
      FileToByteConverter converter = new FileToByteConverter();

      // Convert the workbook to byte array
      byte[] bytes;
      try {
        bytes = converter.convertToBytes(workbook);
      } catch (IOException e) {
        return null; // Return null to indicate failure
      }

      // Convert byte[] to Byte[]
      Byte[] byteObjects = new Byte[bytes.length];
      for (int i = 0; i < bytes.length; i++) {
        byteObjects[i] = bytes[i];
      }

      return byteObjects;
    } else {
      throw new IllegalArgumentException("Invalid file format. Expected Workbook.");
    }
  }

  private List<List<Object>> generateData() {
    // This is just a sample data for demonstration
    List<List<Object>> data = new ArrayList<>();

    List<Object> row1 = Arrays.asList("Name", "Age", "Salary");
    List<Object> row2 = Arrays.asList("John Doe", 30, 5000.0);
    List<Object> row3 = Arrays.asList("Jane Smith", 25, 4000.0);

    data.add(row1);
    data.add(row2);
    data.add(row3);

    return data;
  }
}
