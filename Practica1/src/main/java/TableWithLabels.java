import java.util.HashMap;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String,Integer> labelsToIndex= new HashMap<>();

    @Override
    public RowWithLabel getRowAt(int n) {
        return (RowWithLabel) super.getRowAt(n);
    }
    public void addLabelsToIndex(RowWithLabel nueva_fila){
        for(int i=0;i<nueva_fila.getData().size();i++){

        }
    }
}