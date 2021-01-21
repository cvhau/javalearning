package org.cvhau.javalearning.pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontInfo;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.font.FontSet;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

import java.io.*;

public class Html2Pdf {
    public String htmlFile;

    public Html2Pdf(String htmlFile) {
        this.htmlFile = htmlFile;
    }

    public void saveToPdf(String pdfFile) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(pdfFile)) {
            try (InputStream inputStream = new FileInputStream(htmlFile)) {
                ConverterProperties converterProperties = new ConverterProperties();

                FontSet fontSet = new FontSet();
                fontSet.addDirectory("/home/cvhau/Desktop/font_dir", true);
                String fontFamily = "\"ヒラギノ角ゴ ProN W3\", \"Hiragino Kaku Gothic ProN\", メイリオ, Meiryo, \"ＭＳ Ｐゴシック\", \"MS PGothic\", sans-serif";

                FontProvider fontProvider = new FontProvider(fontSet, fontFamily);
                converterProperties.setFontProvider(fontProvider);

                HtmlConverter.convertToPdf(inputStream, outputStream, converterProperties);
            }
        }
    }

    public void saveToPdf2(String pdfFile) throws IOException, DocumentException {
        try (OutputStream outputStream = new FileOutputStream(pdfFile)) {
            try (InputStream inputStream = new FileInputStream(htmlFile)) {
                ConverterProperties converterProperties = new ConverterProperties();

                FontProvider fontProvider = new FontProvider();

//                fontProvider.addFont("");
                fontProvider.addStandardPdfFonts();
//                fontProvider.addSystemFonts();

//                fontProvider.addFont("HeiseiMin-W3", "UniJIS-UCS2-H");
//                fontProvider.addFont("HeiseiKakuGo-W5", "UniJIS-UCS2-V");
//                fontProvider.addFont("KozMinPro-Regular", "UniJIS-UCS2-HW-H");
//                fontProvider.addFont("KozMinPro-Regular", "UniJIS-UCS2-HW-V");

                BaseFont bf = BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-H", true);
                Font font = new Font(bf);


                converterProperties.setFontProvider(fontProvider);

                HtmlConverter.convertToPdf(inputStream, outputStream, converterProperties);
            }
        }
    }
}
