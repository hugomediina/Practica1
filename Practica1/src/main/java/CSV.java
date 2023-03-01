import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class CSV {
    public Table readTable(String fichero) throws FileNotFoundException {
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
                for(String elemento:linea_separada){
                    fila.addRow(Double.valueOf(elemento));
                }
                tabla.addLine(fila);
            }
        }
        sc.close();
        return tabla;
    }

    public TableWithLabels readTableWithLabels(String fichero) throws FileNotFoundException{
        TableWithLabels tabla= new TableWithLabels();
        Scanner sc = new Scanner(new File(fichero));
        int contador = 0;
        int numberClass=0;
        while (sc.hasNext()){
            String [] linea_separada= sc.next().split(",");
            if(contador==0){
                tabla.addHeaders(linea_separada);
                contador++;
            }else{
                RowWithLabel fila = new RowWithLabel();
                for(int i=0;i<=linea_separada.length-1;i++){
                    fila.addRow(Double.parseDouble(linea_separada[i]));
                }
                String etiqueta = linea_separada[linea_separada.length - 1];
                if (!tabla.getLabelsToIndex().containsKey(etiqueta)) {
                    fila.addNumberClass(numberClass);
                    tabla.addLabelsToIndex(etiqueta,numberClass);
                    contador++;
                } else {
                    numberClass = tabla.getLabelsToIndex().get(etiqueta);
                    fila.addNumberClass(numberClass);
                }
                tabla.addLine(fila);
            }
        }
        sc.close();
        return tabla;
    }
}