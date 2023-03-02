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
        String separador=File.separator;            //PONER EN TODOS
        TableWithLabels tabla= new TableWithLabels();
        Scanner sc = new Scanner(new File(fichero));
        int contador = 0;
        int numberClass=0;
        while (sc.hasNextLine()){
            String [] linea_separada= sc.nextLine().split(",");
            if(contador==0){
                tabla.addHeaders(linea_separada);
                contador++;
            }else{
                RowWithLabel fila = new RowWithLabel();
                String etiqueta = linea_separada[linea_separada.length - 1];
                for(int i=0;i<linea_separada.length-1;i++){
                    fila.addRow(Double.parseDouble(linea_separada[i]));
                }
                if (!tabla.getLabelsToIndex().containsKey(etiqueta)) {
                    numberClass++;
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