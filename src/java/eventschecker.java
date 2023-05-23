import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Stack;
public class eventschecker extends JFrame{
    private JButton backToMainMenuButton;
    private JButton button2;
    private JTable tblData;
    private JPanel Panel1;
    private JTextField textField1;
    private JLabel idlabel;
    private JScrollPane scroll;

    public eventschecker ()
    {
        scroll.setVisible(false);

        //import DB functions
        DataBaseFunctions dataBaseFunctions = new DataBaseFunctions();
        //when check button is pressed preform action
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show table with updated contents
                if (!scroll.isShowing())
                {
                    textField1.setVisible(false);
                    idlabel.setVisible(false);


                    //check if number
                    if (dataBaseFunctions.CheckIfNumber(textField1.getText()))
                    {
                        int tempid = Integer.valueOf(textField1.getText());
                        try {
                            // get sql connection
                            Class.forName("com.mysql.cj.jdbc.Driver" );
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ia?useTimezone=true&serverTimezone=UTC", "root", "Shaked99" );
                            Statement st =con.createStatement();
                            String query = "SELECT * FROM sheep_events WHERE sheepID = "+tempid+"; ";
                            //initializing a result set with the values
                            ResultSet rs = st.executeQuery(query);
                            //get deta in the result set using meta deta
                            ResultSetMetaData rsmd = rs.getMetaData();
                            DefaultTableModel model = (DefaultTableModel) tblData.getModel();
                            //find the amount of columns, allows to modify the table from sql to create more complex events
                            int cols = rsmd.getColumnCount();
                            //array to save the columns names
                            String [] colName = new String[cols];
                            //insert the columns names into the array
                            for (int i = 0; i<cols; i++)
                            {
                                colName[i]= rsmd.getColumnName(i+1);//+1 beocuse the MetaDeta starts from 1.d
                            }
                            model.setColumnIdentifiers(colName);

                            //reading data from sql table and inserting to Jtable

                            //saves data
                            int ID;
                            String type,desc;
                            Date date;
                            //will take all of the data form the RS
                            while (rs.next())
                            {
                                //retrive data for the array
                                ID = rs.getInt(1);
                                type = rs.getString(2);
                                desc = rs.getString(3);
                                date = rs.getDate(4);
                                //create row
                                Object[] row = {ID,type,desc,date};
                                model.addRow(row);
                            }
                            //closes connection when finished fetching
                            st.close();
                            con.close();
                            scroll.setVisible(true);


                        } catch (ClassNotFoundException | SQLException f) {
                            throw new RuntimeException(f);
                        }

                    }
                    //checks if there was a check before
                } else if (tblData.isShowing()) {
                    scroll.setVisible(false);
                    //clearing text field
                    textField1.setText("");
                    textField1.setVisible(true);
                    idlabel.setVisible(true);
                }

            }
        });




        //return back to main menu button
        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.setVisible(false);
                dispose();
                MainM  m = new MainM();
            }
        });




        // window settings
        setContentPane(Panel1);
        setTitle("SheepfoldManager");
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
