import java.util.List;

public class Table {
    public List<String> headers;
    public List<Row> lineas;
    public Row getRowAt(int n){
        return lineas.get(n);
    }
}
