import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CSV {
    public Table readTable(String fichero) throws FileNotFoundException {
        String separador = File.separator;
        Table tabla=new Table();
        Scanner sc=new Scanner(new File("Practica1"+separador+fichero));
        int contador=0;
        while(sc.hasNext()){
            String[] linea_separada=sc.next().split(",");
            if(contador==0){
                tabla.headers.addAll(Arrays.asList(linea_separada));
                contador++;
            }
            Row fila=new Row();
            for(String palabra:linea_separada){
                fila.data.add(Double.parseDouble(palabra));
            }
            tabla.lineas.add(fila);
        }
        sc.close();
        return tabla;
    }
}
