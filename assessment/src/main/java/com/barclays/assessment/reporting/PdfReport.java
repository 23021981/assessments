package com.barclays.assessment.reporting;

import com.barclays.assessment.computing.NetWorthComputing;
import com.barclays.assessment.enums.ProductType;
import com.barclays.assessment.exceptions.AccountProductException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/* Author : Atul Kumar */

@Component
public class PdfReport implements Report {

    @Autowired
    private NetWorthComputing netWorthComputing;

    @Override
    public ByteArrayInputStream generateReport() {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            Paragraph netWorthLabel = new Paragraph();
            netWorthLabel.add(new Paragraph(" " ));
            netWorthLabel.add(new Paragraph("Banks Net Worth value (in GBP): " +
                    netWorthComputing.calculateNetWorthValue()));
            netWorthLabel.add(new Paragraph(" "));

            Paragraph srwaLabel = new Paragraph();
            srwaLabel.add(new Paragraph(" "));
            srwaLabel.add(new Paragraph("Sum of Simple Risk Weighted Assets (SRWA) values (in GBP): " +
                    netWorthComputing.sumOfRiskWeightedAsset().setScale(2, RoundingMode.FLOOR)));

            srwaLabel.add(new Paragraph("  "));

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(createHeadingParagraph(ProductType.Asset.name()));
            document.add(createTable(netWorthComputing.mapAssetProductValue(), netWorthComputing.sumOfAssetProductValue()));
            document.add(createHeadingParagraph(ProductType.Liability.name()));
            document.add(createTable(netWorthComputing.mapLiabilityProductValue(), netWorthComputing.sumOfLiabilityProductValue()));
            document.add(netWorthLabel);
            document.add(srwaLabel);

            document.close();

        } catch (DocumentException |  AccountProductException ex) {
            System.out.println("Error while creating pdf");
            System.out.println(ex.getMessage());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private Paragraph createHeadingParagraph(String label){
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph(' '));
        paragraph.add(new Paragraph(label));
        paragraph.add(new Paragraph(' '));
        return paragraph;
    }

    private PdfPTable createTable(Map<String, BigDecimal> productTypeWithValue, BigDecimal totalValue) throws DocumentException{
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(60);
        table.setWidths(new int[]{3, 3});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("ProductType", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Value (in GBP)", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        for (Map.Entry productValue : productTypeWithValue.entrySet()) {

            PdfPCell cell;

            cell = new PdfPCell(new Phrase(productValue.getKey().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(productValue.getValue().toString()));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

        }

        hcell = new PdfPCell(new Phrase("Total", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase(totalValue!=null?totalValue.toString():  "0.00", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        return table;
    }
}
