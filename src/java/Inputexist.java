import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inputexist extends JFrame{
    private JPanel panel1;
    private JButton DeleteSheep;
    private JButton okButton;
    public Inputexist()
    {
        //closes the window
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                dispose();
            }
        });

        //window settings
        setContentPane(panel1);
        setTitle("SheepfoldManager");
        setSize(480, 260);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
