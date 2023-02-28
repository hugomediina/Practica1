import java.util.ArrayList;
import java.util.List;

public class Table {
    public List<String> headers;
    public List<Row> lineas;
    public Table(){
        headers=new ArrayList<>();
        lineas=new ArrayList<>();
    }
    public Row getRowAt(int n){
        return lineas.get(n);
    }
}
