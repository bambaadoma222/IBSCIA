import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExistsForm extends JFrame {
    private JPanel panel1;
    private JButton TryAgain;

    public ExistsForm() {
        setContentPane(panel1);
        setTitle("SheepfoldManager");
        setSize(480, 260);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //closse the window
        TryAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                dispose();
            }
        });
    }
}
