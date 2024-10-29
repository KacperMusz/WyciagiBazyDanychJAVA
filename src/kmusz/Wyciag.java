package kmusz;

import java.sql.*;

public class Wyciag {

    public void wykonajWyciag(String numer, String zawod) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT employeeNumber, firstName, lastName, email, officeCode, jobTitle " +
                "FROM employees WHERE officeCode = " + numer + " AND jobTitle = '" + zawod + "';";
        System.out.println(sql);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                String employeeNumber = rs.getString("employeeNumber");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String officeCode = rs.getString("officeCode");
                String jobTitle = rs.getString("jobTitle");
                System.out.println(employeeNumber + ", " + firstName + ", " + lastName + ", " + email + ", " + officeCode + jobTitle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
