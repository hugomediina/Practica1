import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSV {
    public Table readTable(String fichero) throws FileNotFoundException {
        String separador = File.separator;
        Table tabla=new Table();
        Scanner sc=new Scanner(new File(fichero));
        int contador=0;
        while(sc.hasNext()){
            String[] linea_separada = sc.next().split(",");
            if(contador==0){
                addHeaders(linea_separada,tabla);
                contador++;
            }
            else{
                Row fila=new Row();
                for(String palabra:linea_separada){
                    fila.data.add(Double.parseDouble(palabra));
                }
                tabla.lineas.add(fila);
            }
        }
        sc.close();
        return tabla;
    }
    private void addHeaders(String[] linea_separada, Table tabla){
        List<String> linea=Arrays.asList(linea_separada);
        tabla.headers.addAll(linea);
    }
//METER UN METODO ADDROW
}
