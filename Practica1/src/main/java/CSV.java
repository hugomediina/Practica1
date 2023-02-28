import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {
    public Table readTable(String fichero) throws FileNotFoundException {
        //String separador = File.separator;
        Table tabla=new Table();
        Scanner sc=new Scanner(new File(fichero));
        int contador=0;
        while(sc.hasNext()){
            String[] linea_separada = sc.next().split(",");
            if(contador==0){
                tabla.addHeaders(linea_separada);
                contador++;
            }
            else{
                Row fila=new Row();
                Row nueva_fila = fila.addRow(linea_separada, fila);
                tabla.addLine(nueva_fila);
            }
        }
        sc.close();
        return tabla;
    }

    public TableWithLabels readTableWithLabels(String fichero) throws FileNotFoundException{
        TableWithLabels tabla=new TableWithLabels();
        Scanner sc=new Scanner(new File(fichero));
        int contador=0;
        while(sc.hasNext()){
            String[] linea_separada = sc.next().split(",");
            if(contador==0){
                tabla.addHeaders(linea_separada);
                contador++;
            }
            else{
                RowWithLabel fila=new RowWithLabel();
                RowWithLabel nueva_fila = (RowWithLabel) fila.addRow(linea_separada, fila);
                tabla.addLine(nueva_fila);
                tabla.addLabelsToIndex(nueva_fila);
            }
        }
        sc.close();
        return tabla;
    }
}
