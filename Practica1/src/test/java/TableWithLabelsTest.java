import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableWithLabelsTest {
    CSV myCSV;
    TableWithLabels table;
    List<Double> linea0;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        myCSV= new CSV();
        table=myCSV.readTableWithLabels("iris.csv");

        linea0=new ArrayList<>();
        linea0.add(5.4);
        linea0.add(3.9);
        linea0.add(1.7);
        linea0.add(0.4);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRowAt() {
        assertEquals(linea0,table.getRowAt(4).getData());
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