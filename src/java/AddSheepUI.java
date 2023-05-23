import javax.swing.*;
import java.util.Objects;

public class AddSheepUI extends JFrame {

    private JPanel panel1;
    private JButton addToFlockButton;
    private JTextField sheepSNumberTextField;
    private JComboBox SheepGroupComboBox;
    private JButton exitToMainMenuButton;

    public AddSheepUI() {
        DataBaseFunctions DataBaseActions = new DataBaseFunctions();

        //go back to main menu
        exitToMainMenuButton.addActionListener(e -> {
            panel1.setVisible(false);
            dispose();
            MainM homescreen = new MainM();
        });



        // when button is pressed add sheep to BD
        addToFlockButton.addActionListener(e ->
        {
            // check if entry is a number
            if (DataBaseActions.CheckIfNumber(sheepSNumberTextField.getText()))
            {
                String tempgroup = Objects.requireNonNull(SheepGroupComboBox.getSelectedItem()).toString(); //will hold the temp group of the sheep
                String tempsheepID = sheepSNumberTextField.getText();
                int convertID = Integer.parseInt(tempsheepID);// <--  goes into the DB
                //checks if the system has the sheep inside
                if (DataBaseActions.InDataBase(convertID)) {
                    //bring up the window saying it exists
                    ExistsForm ef = new ExistsForm();
                } else if (!DataBaseActions.InDataBase(convertID)) {
                    //add sheep to DB
                    DataBaseActions.insertsheep(convertID, tempgroup);
                    successform sf = new successform();
                }
            }
            //if entry is not a number open a fail window
            else {
                NonNumber d = new NonNumber();
            }
        });



        //window settings
        setContentPane(panel1);
        setTitle("SheepfoldManager");
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}