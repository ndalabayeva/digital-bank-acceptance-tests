package co.wedevx.digitalbank.automation.ui.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utils.ConfigReader.getPropertiesValues;

public class DBUtils {

    private static Connection connection = null; // Class-level static variable
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    //method to establish connection with db
    public static void establishConnection() {


        //in the real world we take these data below from property
        //and below data is already is properties
//        String url = "jdbc:mysql://3.254.77.52:3306/nazerked862";
//        String username = "nazerked862";
//        String password = "U>0A52fJYHMM";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //establish connection
            connection = DriverManager.getConnection(
                    getPropertiesValues("digitalbank.db.url"),
                    getPropertiesValues("digitalbank.db.username"),
                    getPropertiesValues("digitalbank.db.password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //method that can dynamically send select statements
    //and returns a list of map of all columns
    //list gonna be rows, map is gonna be columns and values
    public static List<Map<String, Object>> runSQLSelectQuery(String sqlQuery)
    //Object can be integer, wrapper class Integer/Double or anything
    {
        List<Map<String, Object>> dbResultList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            //if we just return resultSet, whenever we start using resultSet
            //it's gonna come that we need try-catch again, we need to close
            //we wanna bring all the exception handling and then closing all that staff

            //getMetaData() method returns info about info (data about inside envelope in mailbox)
            //who it came from, who is the sender - metadata about our data
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                //every row we are creating a Map
                Map<String, Object> rowMap = new HashMap<>();

                for (int col = 1; col <= columnCount; col++) {
                    rowMap.put(resultSetMetaData.getColumnName(col), resultSet.getObject(col));
                }

                dbResultList.add(rowMap);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return dbResultList;
    }

    //create a method that inserts and updates into db
    //returns the num of rows updated or 0 when action is not taken

    //update/insert query
    public static int runSQLUpdateQuery(String sqlQuery) {
        int rowsAffected = 0;
        try {
            statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowsAffected;
    }

    //close connection
    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            //if resultSet is null it throws NullPointerException
            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


