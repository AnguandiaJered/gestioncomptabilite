package com.example.comptabilite.rapports;

import com.example.comptabilite.models.Recettes;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RecetteRapport {

    private List<Recettes> listRecette;

    public RecetteRapport(List<Recettes> listRecette) {
        this.listRecette = listRecette;
    }

    private void WriteTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
//        cell.setPhrase(new Phrase("Id"));
//        table.addCell(cell);
        cell.setPhrase(new Phrase("Montant"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Motif"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Vente"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Date recette"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Autor"));
        table.addCell(cell);

    }
    private void WriteTableData(PdfPTable table){
        for (Recettes rece : listRecette) {
//            table.addCell(String.valueOf(rece.getId()));
            table.addCell(String.valueOf(rece.getMontant()));
            table.addCell(rece.getMotif());
            table.addCell(rece.getRefvente());
            table.addCell(rece.getDaterecette());
            table.addCell(rece.getAuthor());
        }

    }
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        document.add(new Paragraph("Listes des recettes"));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        WriteTableHeader(table );
        WriteTableData(table);
        document.add(table);
        document.close();

    }
}
