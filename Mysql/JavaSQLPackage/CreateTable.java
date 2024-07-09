package JavaSQLPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTable {
        public static void main(String[] args) {
            //creating table into database.
            String CreateTable="Create Table emp(" + "id Int," + "Name varchar(20)," + "Age int," + "Salary Bigint)";

            //intserting data into table emp.
            String insertSQL = "INSERT INTO emp (id,Name,Age,Salary) VALUES " +
                    "(1,'BhanuReddy', 23, 70000.00), " +
                    "(2,'AvinashReddy',22 , 85000.00), " +
                    "(3,'Purvesh',23, 65000.00),"+
                    "(4,'john',30,45000)";
            String deletesql="delete from emp where name='john';";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection bhanu = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhanureddy", "root", "Reddy@868");
                Statement stmt = bhanu.createStatement();
//               stmt.executeUpdate(CreateTable);
//               System.out.println("Table Created Sussessfully");
//               int rowinserted=stmt.executeUpdate(insertSQL);
//               System.out.println("Rows inserted successfully");
//                int rowdelete=stmt.executeUpdate(deletesql);
//                System.out.println("row deleted successfully");

                ResultSet resultSet = stmt.executeQuery("select *from emp");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)+" "+resultSet.getInt(3)+ " "+resultSet.getInt(4));
                }
                bhanu.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
