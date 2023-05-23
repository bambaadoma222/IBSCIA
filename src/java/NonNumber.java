import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NonNumber extends JFrame {
    private JButton button1;
    private JPanel panel1;

    public NonNumber()
    {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                dispose();
            }
        });

        setContentPane(panel1);
        setTitle("SheepfoldManager");
        setSize(500, 400 );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
