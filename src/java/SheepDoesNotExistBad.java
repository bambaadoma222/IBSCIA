import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SheepDoesNotExistBad extends JFrame{
    private JButton TryAgainButton;
    private JPanel JpanelA;

    public SheepDoesNotExistBad()
    {
        //close window operation
        TryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gets rid of the screen
                JpanelA.setVisible(false);
                dispose();
            }
        });


        //window settings
        setContentPane(JpanelA);
        setTitle("SheepfoldManager");
        setSize(480, 260);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
