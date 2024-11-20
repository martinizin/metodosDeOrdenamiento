import javax.swing.*;
import java.lang.management.MemoryType;

public class Ordenamiento {
    private JTextArea textDesordenado;
    private JButton ORDENARButton;
    private JTextArea textOrdenado;
    private JComboBox cbMetodos;

    int [] array=new int[20];
    public Ordenamiento() {
    }

    public static int aleatorio(int max, int min){
        return (int)(Math.round(Math.random()*(max-min))+min);  //CASTING

    }
    public int burbuja(int []array){
        int n=array.length;
        int iteraciones=0;

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                iteraciones++;
                if(array[j]>array[j+1]){
                    int aux=array[j];
                    array[j]=array[j+1];
                    array[j+1]=aux;
                }
            }
        }
        return iteraciones;

    }
    public void burbujaGUI(){

    }
}
