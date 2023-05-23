import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertStatusUI extends JFrame{
    private JButton insertUpdateButton;
    private JButton backToMainMenuButton;
    private JTextField sheepstatusfield;
    private JTextField sheepidfield;
    private JPanel updatepanel;

    public insertStatusUI()
    {
        //import database function I have created
        DataBaseFunctions DataBaseActions = new DataBaseFunctions();




        //returns to main menu when pressed
        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatepanel.setVisible(false);
                dispose();
                MainM M = new MainM();
            }
        });



        //when button is pressed preform insert
    insertUpdateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //checks if value is a number
            if (DataBaseActions.CheckIfNumber(sheepidfield.getText()));
            {
                String temp = sheepidfield.getText();
                int id = Integer.parseInt(temp);
                temp = sheepstatusfield.getText();
                //insert to DB
                if (DataBaseActions.insertStatus(id, temp))
                {
                    successform sf = new successform();
                }
                else {
                    DataBaseerror f = new DataBaseerror();
                }
            }

        }
    });



        //window settings
        setContentPane(updatepanel);
        setTitle("SheepfoldManager");
        //size
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
