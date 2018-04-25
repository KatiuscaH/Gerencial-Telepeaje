package co.udec.gerencial.presentacion;

import javax.swing.UnsupportedLookAndFeelException;

public class Gerencial {

    public static void main(String[] args) {
        
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Error de interfaz: "+ex.getMessage());
        }
        
        Main frame = new Main();
        frame.setVisible(true);
      
    }
 
}