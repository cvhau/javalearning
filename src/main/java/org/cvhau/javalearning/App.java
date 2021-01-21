package org.cvhau.javalearning;

import com.itextpdf.text.DocumentException;
import org.cvhau.javalearning.pdf.Html2Pdf;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, DocumentException {
        Html2Pdf html2Pdf = new Html2Pdf("/home/cvhau/Desktop/abc.html");
        html2Pdf.saveToPdf2("/home/cvhau/Desktop/abc.pdf");
    }
}