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
    List<String> cabecera;
    List<Double> linea0;
    List<Double> linea1;
    List<Double> linea2;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        myCSV=new CSV();
        tabla=myCSV.readTable("miles_dollars.csv");

        cabecera=new ArrayList<>();
        linea0=new ArrayList<>();
        linea1=new ArrayList<>();
        linea2=new ArrayList<>();

        linea0.add(1849.0);
        linea0.add(2332.0);
        linea1.add(2468.0);
        linea1.add(3694.0);
        linea2.add(3466.0);
        linea2.add(4244.0);
        cabecera.add("Miles");
        cabecera.add("Dollars");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRowAt() { //El número que se le asigna a cada fila es correcto
        assertEquals( linea0,tabla.getRowAt(4).getData());
        assertEquals( linea1,tabla.getRowAt(9).getData());
        assertEquals( linea2,tabla.getRowAt(14).getData());
    }

    @Test
    void getFilas() {
        assertEquals(25,tabla.getLineas().size());
    }

    @Test
    void getColumnas() {
        assertEquals(2,tabla.getHeaders().size());
    }
    @Test
    void comprobarCabeceras() {
        assertEquals(cabecera, tabla.getHeaders());
    }
}