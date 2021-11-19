package bigcalculator;

import java.awt.Image;
import java.awt.Toolkit;

public class BigCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainForm main = new MainForm();
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL OS\\Desktop\\BigCalculator\\src\\bigcalculator\\img\\iconframe1.png");    
        main.setIconImage(icon);    
        main.setTitle("BigInteger Calculator");
    }
    
}
