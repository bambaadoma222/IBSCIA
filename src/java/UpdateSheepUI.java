import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateSheepUI extends JFrame {

    private JButton backToMainMenuButton;
    private JPanel panel1;
    private JButton updateSheepButton;
    private JTextField textField1;
    private JComboBox comboBox1;

    public UpdateSheepUI() {
        //define da6abase & utilities class
        DataBaseFunctions dataBaseFunctions = new DataBaseFunctions();// data base function use

        //return to main menu function
        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                dispose();
                MainM m = new MainM();
            }
        });







        //update sheep
        updateSheepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //saves values from combobox and text field (sheep's new group and ID)
                String temp1 = comboBox1.getSelectedItem().toString();
                String temp2 = textField1.getText();

                //checks if there are only numbers inside the textField
                if (dataBaseFunctions.CheckIfNumber(temp2) ==  true )
                {
                    int i = Integer.valueOf(temp2);
                    //update value in the data base using method from 'databasefunction'
                    if (dataBaseFunctions.UpdateSheep(i, temp1))
                    {
                        //brings up the window that says the operation had worked
                        successform sf = new successform();

                    }

                    //if for some resson it didnt sucseed bring up a window saying it didnt work
                    else
                    {

                        //bring up the window
                        DataBaseerror dbe = new DataBaseerror();

                    }

                }

                //open error window if there are something which is not numerical values inside the textBox
                else if (dataBaseFunctions.CheckIfNumber(temp2) ==  false )
                {

                    DataBaseerror dbe = new DataBaseerror();

                }
            }
        });


        setContentPane(panel1);
        setTitle("Sheepfoldmanager");
        setVisible(true);
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
