import java.util.ArrayList;
import java.util.List;

public class Row {
    public List<Double> data;
    public Row(){
        data=new ArrayList<>();
    }
    public List<Double> getData() {
        return data;
    }

    @Override
    public String toString() {
        String constructor_cadena = "";
        for(int i=0;i<data.size()-1;i++){    //SE PUEDE MEJORAR MUCHO
            constructor_cadena=constructor_cadena+data.get(i)+',';
        }
        constructor_cadena=constructor_cadena + data.get(data.size()-1);
        return constructor_cadena;
    }
}
