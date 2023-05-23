import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ASKUI extends JFrame{
    private JButton insertNewSheepButton;
    private JButton updateExistingSheepButton;
    private JButton goBackToMainButton;
    private JPanel ASk;

    public ASKUI()
    {
        //back to main menu button prosidure
        goBackToMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ASk.setVisible(false);
                dispose();
                MainM MM = new MainM();
            }
        });


        //sends to the update existing sheep menu
        updateExistingSheepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ASk.setVisible(false);
                dispose();
                UpdateSheepUI USU = new UpdateSheepUI();
            }
        });


        //sends into the insert new sheep menu
        insertNewSheepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ASk.setVisible(false);
                dispose();
                AddSheepUI ASU = new AddSheepUI();
            }
        });




        //window settings
        setContentPane(ASk);
        setTitle("SheepfoldManager");
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
