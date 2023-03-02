import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {
    CSV myCSV;
    KNN myKNN;
    TableWithLabels table;
    private List<Double> linea0_source;
    private List<Double> linea1_source;
    private List<Double> linea0;
    private List<Double> linea1;
    private List<Double> linea2;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        myCSV=new CSV();
        myKNN=new KNN();

        linea0_source=new ArrayList<>();
        linea1_source=new ArrayList<>();
        linea0=new ArrayList<>();
        linea1=new ArrayList<>();
        linea2=new ArrayList<>();

        table=myCSV.readTableWithLabels("iris.csv");
        myKNN.train(table);
        linea0_source.add(5.4);
        linea0_source.add(3.9);
        linea0_source.add(1.3);
        linea0_source.add(0.4);

        linea1_source.add(6.7);
        linea1_source.add(3.0);
        linea1_source.add(5.0);
        linea1_source.add(1.7);

        linea0.add(5.0);
        linea0.add(3.0);
        linea0.add(10.0);
        linea0.add(1.0);

        linea1.add(8.0);
        linea1.add(8.0);
        linea1.add(8.0);
        linea1.add(8.0);

        linea2.add(4.6);
        linea2.add(3.4);
        linea2.add(1.4);
        linea2.add(0.4);
    }
    @Test
    void estimate() {
        assertEquals(3,myKNN.estimate(linea0));
        assertEquals(3,myKNN.estimate(linea1));
        assertEquals(1,myKNN.estimate(linea2));
    }

    @Test
    void distancia() {
        assertEquals(8.719,myKNN.distancia(linea0_source,linea0),0.001);
        assertEquals(5.233,myKNN.distancia(linea1_source,linea0),0.001);
        assertEquals(11.19,myKNN.distancia(linea0_source,linea1),0.001);
        assertEquals(8.624,myKNN.distancia(linea1_source,linea1),0.001);
    }
}