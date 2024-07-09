package JavaSQLPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mysqlconnection {
    public static void main(String[] args) {
        String CreateTable="Create Table emp(" + "id Int," + "Name varchar(20)," + "Age int," + "Salary Bigint)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection bhanu = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhanureddy", "root", "Reddy@868");
            Statement stmt = bhanu.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from Employee");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)+" "+resultSet.getInt(3)+ " "+resultSet.getInt(4));
            }

            bhanu.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
