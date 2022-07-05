package com.example.comptabilite.rapports;

import com.example.comptabilite.models.Depenses;
import com.example.comptabilite.models.Recettes;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepenseExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Depenses> listDepense;
    public DepenseExcel(List<Depenses> listDepense) {
        this.listDepense = listDepense;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderRow(){
        sheet=  workbook.createSheet("Depenses");
        Row row = sheet.createRow(0);
        CellStyle style =workbook.createCellStyle();
        XSSFFont font =workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
//        createCell(row,0,"Id",style);
        createCell(row,0,"Montant",style);
        createCell(row,1,"Montif",style);
        createCell(row,3,"Date Depense",style);
        createCell(row,4,"Author",style);

    }
    private void createCell(Row row,int columnCount,Object value,CellStyle style){

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if(value instanceof Boolean){
            cell.setCellValue((String)value);

        }else if(value instanceof Long){
            cell.setCellValue((String)value);

        }else{
            cell.setCellValue((String)value);
        }
        cell.setCellStyle(style);
    }
    private  void writeDataRows(){
        int rowCount=1;
        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontHeight(15);
        style.setFont(font);
        for(Depenses dep:listDepense){
            Row row = sheet.createRow(rowCount++);
            int columnCount=0;
//            createCell(row,columnCount++,""+recettes.getId(),style);
            createCell(row,columnCount++,""+dep.getMontant(),style);
            createCell(row,columnCount++,""+dep.getMotif(),style);
            createCell(row,columnCount++,""+dep.getDatedepense(),style);
            createCell(row,columnCount++,""+dep.getAuthor(),style);
        }

    }
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRows();
        ServletOutputStream outputStream= response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
