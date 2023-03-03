import java.util.List;

public class KNN {
    private TableWithLabels table;
    public void train(TableWithLabels data){
        this.table=data;
    }
    public Integer estimate(List<Double> data){
        double euclidea;
        double dist_min=-1;
        int numberClass=-1;
        for(int i=0;i<table.getRows().size();i++){
            RowWithLabel fila=(RowWithLabel) table.getRows().get(i);
             euclidea=distancia(fila.getData(),data);
             if(euclidea<dist_min || dist_min==-1){
                 dist_min=euclidea;
                 numberClass=table.getRowAt(i).getNumberClass();
             }
        }
        return numberClass;
    }
    public double distancia(List<Double> data_source, List<Double> data){
        double amount=-1;
        for(int i=0;i<data_source.size();i++){
            amount+=Math.pow((data_source.get(i)-data.get(i)),2);
        }
        return Math.sqrt(amount);
    }
}
