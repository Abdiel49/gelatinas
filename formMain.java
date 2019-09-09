import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class formMain extends JFrame {

    private int sizeX = 500, sizeY = 480;
    private JLabel label_JL;
    private JTextField nameSweet_TF;
    private JButton searchButton_JB;

    public formMain(){
        super("Registro de Postres");
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    public void initComponents(){
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        label_JL =  new JLabel("Ingrese ell nombre del postre a registrar");
        nameSweet_TF = new JTextField(20);
        //searchButton_JB = new JButton("subir").addActionListener(new ActionEvent ());



        cp.add(label_JL);
        cp.add(nameSweet_TF);
        cp.add(searchButton_JB);

        setVisible(true);
    }

    private void showsms(String cad){

    }
    private void sms(String cad){ System.out.println(cad); }
}
