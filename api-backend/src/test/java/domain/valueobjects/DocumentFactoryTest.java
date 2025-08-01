package domain.valueobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import finance.api.domain.valueobjects.Document;
import finance.api.domain.valueobjects.DocumentFactory;
import finance.api.domain.valueobjects.Cpf;
import finance.api.domain.valueobjects.Cnpj;


public class DocumentFactoryTest {

    @Test
    public void shouldCreateCPFWhenLengthIs11() {
        Document doc = DocumentFactory.create("123.456.789-09");
        assertTrue(doc instanceof Cpf);
        assertEquals("12345678909", doc.getValue());
    }

    @Test
    public void shouldCreateCNPJWhenLengthIs14() {
        Document doc = DocumentFactory.create("12.345.678/0001-95");
        assertTrue(doc instanceof Cnpj);
        assertEquals("12345678000195", doc.getValue());
    }

    @Test
    public void shouldThrowExceptionOnInvalidLength() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            DocumentFactory.create("999");
        });
        assertEquals("Invalid document length. Must be 11 digits for CPF or 14 digits for CNPJ.", e.getMessage());
    }

    @Test
    public void shouldThrowExceptionOnNullInput() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            DocumentFactory.create(null);
        });
        assertEquals("Document cannot be null or empty", e.getMessage());
    }

    @Test
    public void shouldThrowExceptionOnEmptyInput() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            DocumentFactory.create("    ");
        });
        assertEquals("Document cannot be null or empty", e.getMessage());
    }

    @Test
    public void shouldThrowExceptionOnNonDigitCharacters() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            DocumentFactory.create("abc.def.ghi-jk");
        });
        assertEquals("Invalid document length. Must be 11 digits for CPF or 14 digits for CNPJ.", e.getMessage());
    }

    @Test
    public void shouldTrimWhitespaceBeforeProcessing() {
        Document doc = DocumentFactory.create("  123.456.789-09  ");
        assertTrue(doc instanceof Cpf);
        assertEquals("12345678909", doc.getValue());
    }

    @Test
    public void shouldCreateCpfWithoutFormatting() {
        Document doc = DocumentFactory.create("12345678909");
        assertTrue(doc instanceof Cpf);
        assertEquals("12345678909", doc.getValue());
    }

    @Test
    public void shouldCreateCnpjWithoutFormatting() {
        Document doc = DocumentFactory.create("12345678000195");
        assertTrue(doc instanceof Cnpj);
        assertEquals("12345678000195", doc.getValue());
    }

}
