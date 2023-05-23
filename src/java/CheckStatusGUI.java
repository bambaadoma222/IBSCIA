import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckStatusGUI extends JFrame{
    private JButton backToMainMenuButton;
    private JButton checkButton;
    private JTextField sheepIDtextField1;
    private JLabel EnterIdLabal;
    private JPanel panel1;

    public  CheckStatusGUI()
    {
        //import function
        DataBaseFunctions dataBaseFunctions = new DataBaseFunctions();

        //back to main menu function
        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainM m = new MainM();
                panel1.setVisible(false);
                dispose();
                //trying something new... can change to defult if not working
            }
        });



        //check menu
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //check if user can check by entering ID to the textfield
                if (sheepIDtextField1.isShowing())
                {
                    //checks if number
                    if (dataBaseFunctions.CheckIfNumber(sheepIDtextField1.getText()))
                    {
                            sheepIDtextField1.setVisible(false);
                            EnterIdLabal.setText(dataBaseFunctions.getstatus(Integer.parseInt(sheepIDtextField1.getText())));
                    }

                    else
                    {
                        NonNumber form = new NonNumber();
                    }
                }

                //checks if text field showint = there was a check preformed
                else if (!sheepIDtextField1.isShowing())
                {
                    EnterIdLabal.setText("Sheep ID");
                    //set text field to nothing
                    sheepIDtextField1.setText("");
                    sheepIDtextField1.setVisible(true);
                }
            }
        });

        setContentPane(panel1);
        setTitle("SheepfoldManager");
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
