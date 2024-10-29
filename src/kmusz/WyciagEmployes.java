package kmusz;

import java.sql.*;

public class WyciagEmployes {
    public void wykonajWyciag(String wyraz) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        if(wyraz != null){
            wyraz.trim();
        }

        String sql = "SELECT `firstName`,`lastName`,`email`,`employeeNumber` FROM `employees` WHERE "
                + "firstName = '" + wyraz + "'"
                + "OR lastName = '" + wyraz + "'"
                + "OR email = '" + wyraz + "'"
                + "OR employeeNumber = '" + wyraz + "'";
        System.out.println(sql);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String employeeNumber = rs.getString("employeeNumber");
                String wynik = firstName + ", " + lastName + ", " + email + ", " + employeeNumber;
                System.out.println(wynik);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
