import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TableWithLabelsTest {
    CSV myCSV;
    TableWithLabels table;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        myCSV= new CSV();
        table=myCSV.readTableWithLabels("iris.csv");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRowAt() {
        assertEquals("Souble",table.getRowAt(4).getData());
    }

    @Test
    void addLabelsToIndex() {
    }

    @Test
    void getLabelsToIndex() {
    }

    @Test
    void getEjemplares() {
        assertEquals(150,table.getEjemplares());
    }
}