/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class database {

    public static Connection GetConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring", "root", "root");

        return con;

    }

    public static void insert(person p) throws ClassNotFoundException, SQLException {
        Connection conn = GetConnection();

        PreparedStatement preparedStatement = conn.prepareStatement("insert into person values (?,?,?,?)");
        preparedStatement.setInt(1, p.getId());
        preparedStatement.setInt(2, p.getAge());
        preparedStatement.setString(3, p.getUsername());
        preparedStatement.setString(4, p.getPassword());
        preparedStatement.execute();

    }

    public static List<person> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<person> arrayList = new ArrayList<>();
        Statement stmt = GetConnection().createStatement();
        ResultSet rs = stmt.executeQuery("select * from person");

        while (rs.next()) {

            arrayList.add(new person(rs.getInt("id"), rs.getInt("age"), rs.getString("username"), rs.getString("password")));

        }

        return arrayList;
    }

}
