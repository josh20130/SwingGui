
package application;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;



public class DetailsPanel extends JPanel {
    
    private EventListenerList listenerList = new EventListenerList();
    
    
    public DetailsPanel(){     // Sets attributes of window
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        
        setBorder(BorderFactory.createTitledBorder("Personal Details"));
        
        //Creates Labels
        JLabel nameLabel = new JLabel("Name: ");
        JLabel occupationLabel = new JLabel("Occupation: ");
        JLabel addressLabel = new JLabel("Address: ");
        JLabel stateLabel = new JLabel("State: ");
        JLabel countryLabel = new JLabel("Country: ");
        
        //Creates fields for data to be entered
        final JTextField nameField = new JTextField(10);
        final JTextField occupationField = new JTextField(10);
        final JTextField addressField = new JTextField(10);
        final JTextField stateField = new JTextField(10);
        final JTextField countryField = new JTextField(10);
       //Creates button 
       JButton addBtn = new JButton("Add");
       //Creates action listener for the button
       addBtn.addActionListener(new ActionListener()
       {    //When action is performed, method gathers text for variables name and occupation
           public void actionPerformed(ActionEvent e){
               
           
           String name = nameField.getText();
           String occupation = occupationField.getText();
           String address = addressField.getText();
           String state = stateField.getText();
           String country = countryField.getText();
           
           String text = name + ": " + occupation + ": " + address + ": " + state + ": " + country + "\n";
           
           
           
           fireDetailEvent(new DetailEvent(this, text));
           }
           });
       
       setLayout(new GridBagLayout());
       
       GridBagConstraints gc = new GridBagConstraints();
       
       //// First Column ////
       gc.anchor = GridBagConstraints.LINE_END;
       
       gc.weightx = 0.5;
       gc.weighty = 0.5;
       
       //Position for nameLabel
       gc.gridx = 0;
       gc.gridy = 0; 
       add(nameLabel,gc);
       
       //Position for occupationLabel
       gc.gridx = 0;
       gc.gridy = 1;
       add(occupationLabel, gc);
       
       //Position for addressLabel
       gc.gridx = 0;
       gc.gridy = 2;
       add(addressLabel, gc);
       
       //Position for stateLabel
       gc.gridx = 0;
       gc.gridy = 3;
       add(stateLabel, gc);
       
       //Position for countryLabel
       gc.gridx = 0;
       gc.gridy = 4;
       add(countryLabel, gc);
       
       //// Second Column ////
       gc.anchor = GridBagConstraints.LINE_START;
       
       //Position for nameField
       gc.gridx = 1;
       gc.gridy = 0;
       add(nameField, gc);
       
       //Position for occupationField
       gc.gridx = 1;
       gc.gridy = 1;
       add(occupationField, gc);
       
       //Position for addressLabel
       gc.gridx = 1;
       gc.gridy = 2;
       add(addressField, gc);
       
       //Position for stateLabel
       gc.gridx = 1;
       gc.gridy = 3;
       add(stateField, gc);
       
       //Position for countryLabel
       gc.gridx = 1;
       gc.gridy = 4;
       add(countryField, gc);
       
       // Final Row //
       gc.weighty = 10;
       
       gc.anchor = GridBagConstraints.FIRST_LINE_START;
       gc.gridx = 1;
       gc.gridy = 5;
       add(addBtn, gc);
    }  
        public void fireDetailEvent(DetailEvent event)//Begins DetailEvent methods
        {
            Object[] listeners = listenerList.getListenerList();//Puts listeners into an array to itterate through
            
            for( int i=0; i < listeners.length; i += 2)
            {
                if(listeners[i] == DetailListener.class)
                {
                    ((DetailListener)listeners[i+1]).detailEventOccurred(event);
                }
            }
        }
    
        //Adds or removes detail listeners when needed
        public void addDetailListener(DetailListener listener)
       {
            listenerList.add(DetailListener.class, listener);
       }
        public void removeDetailListener(DetailListener listener)
       {
           listenerList.remove(DetailListener.class, listener);
       }
       
       
       
       
    }
    
    
    
