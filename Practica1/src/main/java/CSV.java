import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
                Row nueva_fila = fila.addRow(linea_separada, fila);
                tabla.addLine(nueva_fila);
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
                RowWithLabel nueva_fila= (RowWithLabel) fila.addRow(linea_separada,fila);
                String etiqueta = linea_separada[linea_separada.length - 1];
                if (!tabla.getLabelsToIndex().containsKey(etiqueta)) {
                    nueva_fila.addNumberClass(numberClass);
                    tabla.addLabelsToIndex(etiqueta,numberClass);
                    contador++;
                } else {
                    numberClass = tabla.getLabelsToIndex().get(etiqueta);
                    fila.addNumberClass(numberClass);
                }
                tabla.addLine(nueva_fila);
            }
        }
        sc.close();
        return tabla;
    }
}