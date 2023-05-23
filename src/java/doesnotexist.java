import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//informs user that the value he looked for does not exists
public class doesnotexist extends JFrame {
    private JButton tryAgainButton;
    private JPanel NoExists;

    public doesnotexist()
    {
        //close operation after button pressed
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoExists.setVisible(false);
                dispose();
            }
        });

        setContentPane(NoExists);
        setTitle("SheepfoldManager");
        setSize(500, 400 );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
