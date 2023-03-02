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
    List<String> cabecera;
    List<Double> linea0;
    List<Double> linea1;
    List<Double> linea2;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        myCSV= new CSV();
        table=myCSV.readTableWithLabels("iris.csv");

        cabecera=new ArrayList<>();
        cabecera.add("sepal length");
        cabecera.add("sepal width");
        cabecera.add("petal length");
        cabecera.add("petal width");
        cabecera.add("class");

        linea0=new ArrayList<>();
        linea0.add(5.4);
        linea0.add(3.9);
        linea0.add(1.7);
        linea0.add(0.4);

        linea1=new ArrayList<>();
        linea1.add(5.4);
        linea1.add(3.9);
        linea1.add(1.3);
        linea1.add(0.4);

        linea2=new ArrayList<>();
        linea2.add(4.4);
        linea2.add(2.9);
        linea2.add(1.4);
        linea2.add(0.2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRowAt() {
        assertEquals(linea0,table.getRowAt(4).getData());
        assertEquals(linea1,table.getRowAt(15).getData());
        assertEquals(linea2,table.getRowAt(7).getData());
    }
    @Test
    void numeroCorrecto() {
        assertEquals(1,table.getRowAt(4).getNumberClass());
        assertEquals(1,table.getRowAt(15).getNumberClass());
        assertEquals(1,table.getRowAt(7).getNumberClass());
        assertEquals(1, table.getRowAt(0).getNumberClass());
        assertEquals(3, table.getRowAt(148).getNumberClass());
        assertEquals(2, table.getRowAt(89).getNumberClass());
    }
    @Test //Número de filas leido
    void getFilas() {
        assertEquals(150,table.getRows().size());
    }
    @Test //Número de columnas leido
    void getColumnas() {
        assertEquals(5,table.getHeaders().size());
    }
    @Test
    void comprobarCabeceras() {
        assertEquals(cabecera,table.getHeaders());
    }
}