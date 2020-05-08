package sample.Database;

import sample.model.Task;
import sample.model.User;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    private DatabaseHandler databaseHandler;

    private Connection connection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://"+ dbHost + ":"
                +dbPort + "/"
                +dbName + "?serverTimezone=UTC"
                ;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser, dbPass);




        return dbConnection;
    }

    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + ","
                + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + "," +
                Const.USERS_GENDER + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getUserName());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getLocation());
            preparedStatement.setString(6,user.getGender());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resultSet =null;


        if (!user.getUserName().equals("") || !user.getPassword().equals("")) {
            String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE "
                    + Const.USERS_USERNAME + " =? " + " AND " + Const.USERS_PASSWORD
                    + " =? ";

            // select all from users where username="user" and password="password"

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1,user.getUserName());
                preparedStatement.setString(2,user.getPassword());

                resultSet = preparedStatement.executeQuery();

            }catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("Please enter your credentials");

        }

        return resultSet;
    }


    public void insertTask(Task task){
        String insert = "INSERT INTO " + Const.TASKS_TABLE + "(" + Const.USERS_ID + "," + Const.TASKS_DATE + ","
                + Const.TASKS_DESCRIPTION + "," + Const.TASKS_TASK + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setInt(1,12);
            preparedStatement.setTimestamp(2,task.getDatecreated());
            preparedStatement.setString(3,task.getDescription());
            preparedStatement.setString(4,task.getTask());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }






}
