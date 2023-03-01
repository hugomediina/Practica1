import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    CSV myCSV;
    Table tabla;
    List<Double> linea0;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        myCSV=new CSV();
        tabla=myCSV.readTable("miles_dollars.csv");

        linea0=new ArrayList<>();
        linea0.add(1849.0);
        linea0.add(2332.0);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRowAt() {
        assertEquals( linea0,tabla.getRowAt(4).getData());
    }

    @Test
    void getEjemplares() {
        assertEquals(25,tabla.getEjemplares());
    }

    @Test
    void testGetRowAt() {
    }

    @Test
    void addHeaders() {
    }

    @Test
    void addLine() {
    }
}