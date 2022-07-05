package com.example.comptabilite.rapports;

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

public class RecetteExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    List<Recettes> listRecette;

    public RecetteExcel(List<Recettes> listRecette) {
        this.listRecette = listRecette;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderRow(){
        sheet=  workbook.createSheet("Recettes");
        Row row = sheet.createRow(0);
        CellStyle style =workbook.createCellStyle();
        XSSFFont font =workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
//        createCell(row,0,"Id",style);
        createCell(row,1,"Montant",style);
        createCell(row,2,"Motif",style);
        createCell(row,3,"Vente",style);
        createCell(row,3,"Date Recette",style);
        createCell(row,3,"Author",style);
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
        for(Recettes rece:listRecette){
            Row row = sheet.createRow(rowCount++);
            int columnCount=0;

            createCell(row,columnCount++,""+rece.getMontant(),style);
            createCell(row,columnCount++,""+rece.getMotif(),style);
            createCell(row,columnCount++,""+rece.getRefvente(),style);
            createCell(row,columnCount++,""+rece.getDaterecette(),style);
            createCell(row,columnCount++,""+rece.getAuthor(),style);


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
