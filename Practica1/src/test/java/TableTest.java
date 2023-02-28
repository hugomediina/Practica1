import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    CSV myCSV;
    Table tabla;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        myCSV=new CSV();
        tabla=myCSV.readTable("miles_dollars.csv");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRowAt() {
        assertEquals("1849.0,2332.0",tabla.getRowAt(4).toString()); //COMPARAR MEJOR VALORES
    }
}