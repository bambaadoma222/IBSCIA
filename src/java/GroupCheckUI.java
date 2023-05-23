import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupCheckUI extends JFrame {
    private JPanel CheckGPanel;
    private JButton checkButton;
    private JTextField SheepIDtextField1;
    private JButton exitToMainMenuButton;
    private JLabel SheepLabel;

    public GroupCheckUI() {
        //using the DataBaseFunctions class functions
        DataBaseFunctions DataBaseActions = new DataBaseFunctions();




        exitToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckGPanel.setVisible(false);
                dispose();
                dispose();
                MainM MM = new MainM();
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID;

                //if its displayable - it checks group
                if (SheepIDtextField1.isShowing())
                {
                    ID = SheepIDtextField1.getText();
                    if (DataBaseActions.CheckIfNumber(ID))
                    {
                        int InTID = Integer.valueOf(ID);
                        if (DataBaseActions.InDataBase(InTID))
                        {
                            DataSaver DS = new DataSaver(InTID);
                            SheepIDtextField1.setVisible(false);
                            SheepLabel.setText(DataBaseActions.ReturnGroup(InTID));
                        }
                        else if (!DataBaseActions.InDataBase(InTID))
                        {
                            doesnotexist m = new doesnotexist();
                        }
                    }
                    else if(DataBaseActions.CheckIfNumber(ID) == false)
                    {
                        DataBaseerror DBE = new DataBaseerror();
                    }
                }
                //if text field isnt chosen it means that there is a need to check another sheep therefore it will display the txtfield aagain
                else if (!SheepIDtextField1.isShowing())
                {
                    // reset the Jform
                    SheepIDtextField1.setVisible(true);
                    //reset previos shepe
                    SheepIDtextField1.setText("");
                    SheepLabel.setText("Enter Sheep's number");
                }
            }
        });

        //window settings
        setContentPane(CheckGPanel);
        setTitle("SheepfoldManager");
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
