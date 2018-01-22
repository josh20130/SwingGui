
package application;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
    private DetailsPanel detailsPanel;
    
    public MainFrame(String title){
        super(title);
       
        //Setting Layout Manager
        setLayout(new BorderLayout());
        
        //Swing Component Constructors
        final JTextArea textArea = new JTextArea();
        
        detailsPanel = new DetailsPanel(); //Instantiates detailspanel
        
        detailsPanel.addDetailListener(new DetailListener()//Connects DetailListener class methods with mainframe
            {
                public void detailEventOccurred(DetailEvent event){
                    String text = event.getText();
                        
                    textArea.append(text);
                    }
            });
        
        //Add swing components to content pane
        Container c = getContentPane();
        
        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.WEST);
        
        
        
        
            
        
        
       
    }
}
