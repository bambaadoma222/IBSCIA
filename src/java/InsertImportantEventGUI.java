import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertImportantEventGUI extends JFrame {

    private JPanel panel1;
    private JTextField FieldSheepID;
    private JComboBox TypeEventCombo;
    private JTextField FieldDescribe;
    private JButton insertButton;
    private JButton backToInsertUpdateButton;

    public InsertImportantEventGUI() {
        //import datat base functions
        DataBaseFunctions DataBaseActions = new DataBaseFunctions();

        //update when pressed
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = FieldSheepID.getText();
                if (DataBaseActions.CheckIfNumber(temp)) {
                    //covert ID to int in order to insert to sql
                    int Sheep_id = Integer.parseInt(temp);
                    //save current date
                    long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    //gets description of event
                    String Describe = FieldDescribe.getText();
                    //gets event type
                    String Type = TypeEventCombo.getSelectedItem().toString();

                    //Try To insert to Data Base
                    if (DataBaseActions.InsertEvent(Sheep_id, Type, date, Describe))
                    {
                        successform s = new successform();
                    }
                    else
                    {
                        DataBaseerror d = new DataBaseerror();
                    }
                }
            }
        });

        backToInsertUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                dispose();
                MainM MM = new MainM();
            }
        });


        // window settings
        setContentPane(panel1);
        setTitle("SheepfoldManager");
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
