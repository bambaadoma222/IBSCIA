//imports

import java.sql.*;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;



public class DataBaseFunctions {

    //saving data Base connections
        String url = "jdbc:mysql://localhost:3306/ia?useTimezone=true&serverTimezone=UTC";
        String username = "root";
        String password = "Shaked99";

    
    //insert sheep function
    public void insertsheep(int SheepID, String Value) {
        try {
            //SQL libary- connect to data base
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            //SQL command
            stmt.executeUpdate("Insert into sheep_list (sheep_id,sheep_group) values ('" + SheepID + "','" + Value + "'); ");
        } catch (Exception e) {
            e.printStackTrace();
            DataBaseerror dbe = new DataBaseerror();
        }
    }


    //check if the sheep exists in the data base and return it to the function that called it using a boolian value
    public boolean InDataBase(int SheepID) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stamt  = con.createStatement();
            String queryCheck = "SELECT * from sheep_list WHERE sheep_id = ('" + SheepID + "'); ";
            ResultSet rs = stamt.executeQuery(queryCheck);
            //checks if there is a value inside the ResultSet, if there is meaning the sheep exist
            if (rs.next()) {
                return true;
            }
            //if there is no value- return the sheep does not exist
            else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    //allows deleting values from the data base
    public boolean DeleteValue(int PrimaryKey) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stamt = con.createStatement();
            //SQL command
            String queryCheck = " delete from sheep_list WHERE sheep_id = ('" + PrimaryKey + "'); ";
            stamt.executeUpdate(queryCheck);
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }


    //checks the data base for the sheeps group and returns it to class who called it
    public String ReturnGroup(int SheepID) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stamt = con.createStatement();
            String queryCheck = "select Sheep_group from sheep_list where sheep_id = '"+SheepID+"';";
            //saves values retrived from sql in 'rs' place holder
            ResultSet rs = stamt.executeQuery(queryCheck);
            String temp = "no group";
            //checks if there is a value in rs placeholder
            while (rs.next()) {
                //saves string that will be returned
                temp = rs.getNString(1);
            }
            return temp;

        } catch (Exception e) {

            return e.getMessage();

        }
    }


    public boolean InsertEvent(int SheepID, String Eventtype, Date date, String describe) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            //sends sql command to sql server
            stmt.executeUpdate("Insert into sheep_events (sheepID,eventType,Eveentdescription,Eventdate) values ('" + SheepID + "','" + Eventtype + "','" + describe + "','" + date + "');; ");
            return true;

        }
        catch (Exception e)
        {
            //check if operation is failed
            e.getMessage();
            return false;

        }
    }

    public boolean UpdateSheep(int Sheepid, String Group) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = con.prepareStatement("update sheep_list set Sheep_group = ? where sheep_id = ?");
            stmt.setString(1, Group);
            stmt.setInt(2, Sheepid);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public String RetrieveEvent(String SheepID)
    {
        String error = "error happened,try again " +
                "Check terminal for specific error detail. ";
        //try to retrive event- check SQL query
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String queryCheck = "SELECT * FROM sheep_event WHERE sheep_id = '" + SheepID + "'";
            //save values retrived from sql in a queue and output them
            ResultSet rs = stmt.executeQuery(queryCheck);
            return rs.getNString(0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }


    //process that decideds if it should update/insert a new status by id
    public boolean status(int id, String stat)
    {

        try
        {
            //sql
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();


            if (InDataBase(id)) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM sheep_status WHERE sheep_id == '"+id+"' ; ");
                //if there is a value inside the result set update meaning there is a status, update it.
                if (rs.next()) { //check if there is a status

                    stmt.executeUpdate("update sheep_status set SStatus = '" + stat + "' where sheep_id '" + id + "'   ;  ");
                    return true;
                }
                //if there is no new status, insert new sheep SQL command
                else {
                    stmt.executeUpdate("insert into sheep_status (sheep_id, SStatus) values ('" + id + "' , '" + stat + "'); ");
                    return true;

                }

            }
            //if not in data base return false- sheep is not in data base and therefore it is impossible to insert
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }

    }

    public boolean insertStatus (int id, String description){
        //try to insert /update event- check SQL query
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String Statment = "select SStatus from sheep_status where sheep_id = '"+id+"';";
            //goes to SQL table and inserts t result set to check if there is a status to let the program know if it should update the status or should it insert new one
            ResultSet s = stmt.executeQuery(Statment);

            if (s.next()){//check if there is a status (if there is a status there will be
                String sqlUpdate = "UPDATE sheep_status SET SStatus = '"+description+"' WHERE sheep_id = "+id+" ;" ;
                System.out.println(sqlUpdate);
                stmt.executeUpdate(sqlUpdate);
            }
            else {
                stmt.executeUpdate("INSERT INTO sheep_status (sheep_id, SStatus) VALUES ("+id+" , '"+description+"')");
            }
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }




    public String getstatus(int id)
    {
        try {
            //connect to data base
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select SStatus from sheep_status where sheep_id = '"+id+"' ;");
            String tempstat = "no status, insert one";

           //checks if the sheep has a status
            if (rs.next()) {
                tempstat = rs.getNString(1);
                return tempstat;
            }

            //if there is no value come to this, say there is no status
            else
            {
                return tempstat;

            }
        }

        catch (Exception e)
        {
            return "Error, try again";
        }
    }




    public boolean CheckIfNumber(String sheepID) {

        //chack if not null, if null return false becouse it cannot convert an empty field
        if (sheepID == null) {

            return false;
        } else {
            //try to convert the String to an integer
            try {

                int i = Integer.parseInt(sheepID);
                return true;
            }
            //if conversion is failed- catch and return false
            catch (NumberFormatException nfe) {

                return false;

            }

        }
    }



    public boolean EventExists(int SheepID)
    {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stamt = con.createStatement();
            String queryCheck = "SELECT * from sheep_events WHERE sheepID = ('" + SheepID + "'); ";
            ResultSet rs = stamt.executeQuery(queryCheck);
            //checks if there is a value inside the ResultSet, if there is meaning the sheep exist
            if (rs.next()) {
                return true;
            }
            //if there is no value- return the sheep does not exist
            else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



}
