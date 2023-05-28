package com.splitscale.reems;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcelExporterInteractorTest {

  private ExcelExporterInteractor exporterInteractor;

  @Before
  public void setUp() {
    exporterInteractor = new ExcelExporterInteractor();
  }

  @Test
  public void testCreateFile() {
    Workbook workbook = exporterInteractor.createFile();
    Assert.assertNotNull(workbook);
    // Additional assertions can be added to validate the workbook if needed
  }

  @Test
  public void testFileToBytes() {
    Workbook workbook = exporterInteractor.createFile();
    Byte[] bytes = exporterInteractor.fileToBytes(workbook);
    Assert.assertNotNull(bytes);
    // Additional assertions can be added to validate the converted byte array if
    // needed
  }
}
