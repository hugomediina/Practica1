import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> lineas;
    public Table(){
        headers=new ArrayList<>();
        lineas=new ArrayList<>();
    }
    public Row getRowAt(int n){
        return lineas.get(n);
    }
    public void addHeaders(String[] linea_separada){
        List<String> linea= Arrays.asList(linea_separada);
        headers.addAll(linea);
    }
    public void addLine(Row nueva_fila){
        lineas.add(nueva_fila);
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<Row> getLineas() {
        return lineas;
    }
}
