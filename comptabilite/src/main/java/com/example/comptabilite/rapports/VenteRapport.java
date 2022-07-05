package com.example.comptabilite.rapports;

import com.example.comptabilite.models.Recettes;
import com.example.comptabilite.models.Ventes;
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

public class VenteRapport {

    private List<Ventes> listVente;

    public VenteRapport(List<Ventes> listVente) {
        this.listVente = listVente;
    }

    private void WriteTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
//        cell.setPhrase(new Phrase("Id"));
//        table.addCell(cell);
        cell.setPhrase(new Phrase("Produits"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Quantité"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Prix"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Date vente"));
        table.addCell(cell);

    }
    private void WriteTableData(PdfPTable table){
        for (Ventes vente : listVente) {
//            table.addCell(String.valueOf(rece.getId()));
            table.addCell(vente.getRefproduit());
            table.addCell(String.valueOf(vente.getQuantite()));
            table.addCell(String.valueOf(vente.getPrix()));
            table.addCell(vente.getDatevente());
        }

    }
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        document.add(new Paragraph("Listes des ventes"));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        WriteTableHeader(table );
        WriteTableData(table);
        document.add(table);
        document.close();

    }
}
