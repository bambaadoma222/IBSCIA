//imports
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainM extends JFrame {
    //menu buttons
    private JPanel MainMenu1;
    private JButton CheckGroupButton;
    private JButton inserOrUpdatetSheepButton;
    private JButton displayImportantEventsButton;
    private JButton insertImportantEventButton;
    private JButton insertStatusButton;
    private JButton checkStatusButton;


    public MainM() {



        //pulls up the menu that check for the sheep's group
        CheckGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gets rid of the main menu screen
                MainMenu1.setVisible(false);
                dispose();
                //pulls up
                GroupCheckUI gc = new GroupCheckUI();
            }
        });

        displayImportantEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu1.setVisible(false);
                dispose();
                eventschecker CE = new eventschecker();
            }
        });
        




        //pull up the menu that asks the user if he wants to update or crate or delete an existing sheep
        inserOrUpdatetSheepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    //gets rid of the main menu screen
                    MainMenu1.setVisible(false);
                    dispose();
                    //pulls yp the window
                    ASKUI n = new ASKUI();
                }
            }
        });

        // pull up the insert important event menu
        insertImportantEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gets rid of the main menu screen
                MainMenu1.setVisible(false);
                dispose();
                //pulls up menu
                InsertImportantEventGUI n = new InsertImportantEventGUI();
            }
        });


        insertStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu1.setVisible(false);
                dispose();
                insertStatusUI isg = new insertStatusUI();
            }
        });

        //pull up the check status menu
        checkStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get rid of main menu
                MainMenu1.setVisible(false);
                dispose();
                //pull up new menu
                CheckStatusGUI CSG = new CheckStatusGUI();
            }
        });


        //window settings
        setContentPane(MainMenu1);
        setTitle("SheepfoldManager");
        //size
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }
}
