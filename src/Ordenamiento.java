import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ordenamiento {
    private JTextArea textDesordenado;
    private JButton ORDENARButton;
    private JTextArea textOrdenado;
    private JComboBox cbMetodos;
    private JPanel pGeneral;
    private JButton LIMPIARButton;

    int [] array=new int[20];
    public Ordenamiento() {
        ORDENARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbMetodos.getSelectedIndex()==1){
                    textDesordenado.setText("");
                    textOrdenado.setText("");
                    burbujaGUI();
                }
                if(cbMetodos.getSelectedIndex()==2){
                    textDesordenado.setText("");
                    textOrdenado.setText("");
                    seleccionGUI();
                }
            }
        });

        LIMPIARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
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
        int tam=array.length;
        for (int i=0; i<tam; i++)
            array[i]=aleatorio(255,0);

        for(int i=0; i<tam; i++)
            textDesordenado.append("\n"+array[i]);

        int pasos=burbuja(array);

        for(int i=0; i<tam; i++)
            textOrdenado.append("\n"+array[i]);
        JOptionPane.showMessageDialog(null,"Iteraciones"+pasos);
    }

    public int seleccion(int []array){
        int n=array.length;
        int pasos=0;
        for(int i=0; i<n-1;i++){
            int min=i;
            for(int j=i+1; j<n;j++){
                pasos++;
                if(array[j]<array[min]){
                    min=j;
                }
            }
            pasos++;
            int aux=array[min];
            array[min]=array[i];
            array[i]=array[aux];
        }
        return pasos;

    }

    public void seleccionGUI(){
        int tam=array.length;
        for (int i=0; i<tam; i++)
            array[i]=aleatorio(255,0);

        for(int i=0; i<tam; i++)
            textDesordenado.append("\n"+array[i]);

        int pasos=seleccion(array);

        for(int i=0; i<tam; i++)
            textOrdenado.append("\n"+array[i]);
        JOptionPane.showMessageDialog(null,"Iteraciones"+pasos);
    }

    public void limpiar(){
        textOrdenado.setText("");
        textDesordenado.setText("");

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ordenamiento");
        frame.setContentPane(new Ordenamiento().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
