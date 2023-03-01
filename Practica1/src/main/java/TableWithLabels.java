import java.util.HashMap;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String,Integer> labelsToIndex;

    public TableWithLabels(){
        this.labelsToIndex=new HashMap<>();
    }
    @Override
    public RowWithLabel getRowAt(int n) {
        return (RowWithLabel) super.getRowAt(n);
    }
    public void addLabelsToIndex(String etiqueta, int numberClass){
        labelsToIndex.put(etiqueta,numberClass);
    }
    public Map<String, Integer> getLabelsToIndex() {
        return labelsToIndex;
    }
    public int getEjemplares() {
        return super.getEjemplares();
    }
}