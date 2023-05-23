import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class successform extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel opp;
    private JLabel operation;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public successform(){
        //close window by button press operation
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gets rid of the screen
                opp.setVisible(false);
                dispose();
            }
        });




        //window settings
        setContentPane(opp);
        setSize(480, 260);
        setTitle("SheepfoldManager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
