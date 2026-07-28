package io.aidevcopilot.rag.util;

import lombok.experimental.UtilityClass;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.nio.file.Path;

@UtilityClass
public class PdfUtils {

    public String extractText(Path pdfPath) {

        try (PDDocument document = Loader.loadPDF(pdfPath.toFile())) {

            PDFTextStripper stripper = new PDFTextStripper();

            return stripper.getText(document);

        } catch (IOException exception) {

            throw new RuntimeException("Unable to parse pdf", exception);

        }

    }

}