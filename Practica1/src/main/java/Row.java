import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> data;
    public Row(){
        data=new ArrayList<>();
    }
    public List<Double> getData() {
        return data;
    }
    public Row addRow(String[] linea_separada, Row fila){
        for(String palabra:linea_separada){
            fila.data.add(Double.parseDouble(palabra));
        }
        return fila;
    }
}
