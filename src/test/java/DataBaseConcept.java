
//import the file
import java.sql.*;

public class DataBaseConcept {

    public static void main(String [] args) throws ClassNotFoundException, SQLException {

       //Load and register the class

        Class.forName("com.mysql.jdbc.Driver");

        //Make a connection

        Connection connection= DriverManager.getConnection("hhttps//", "username", "password");

        //create a statement
        Statement statement= connection.createStatement();

        //get the result and execute the query
        ResultSet resultSet= statement.executeQuery("sql");


        while(resultSet.next())
        {
            resultSet.getInt(1);
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}


