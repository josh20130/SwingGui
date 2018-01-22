
package application;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Application {

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
        public void run(){ //Initializes frame, takes care of basic needs like close button, makes window visible and sets the size
          JFrame frame = new MainFrame("Application");
        frame.setSize(500,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        }
        }
);
        
      
    
}
}