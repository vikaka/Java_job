package org.myorg.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


/**
 * Created by Vishesh Kakarala on 6/14/2017.
 */
public class postgre {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        /*String url = "jdbc:postgresql://34.225.139.150:5432/testdb";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","kakarala");
        props.setProperty("ssl","false");
        props.setProperty("sslfactory","org.postgresql.ssl.NonValidatingFactory");*/
        String url = "jdbc:postgresql://34.225.139.150:5432/testdb?user=postgres&password=kakarala&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
        Connection conn = DriverManager.getConnection(url);

        conn.setAutoCommit(false);
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT count(*) as total FROM test_name");
        while(rs.next()) {
            System.out.print(rs.getInt("total"));
        }
        rs.close();

    }
}
