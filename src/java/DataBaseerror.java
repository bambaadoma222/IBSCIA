import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataBaseerror extends JFrame {
    private JPanel panel1;
    private JLabel label;
    private JButton okButton;


    public DataBaseerror() {

        //closes the error window
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
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
