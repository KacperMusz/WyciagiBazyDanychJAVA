package kmusz;

import java.sql.*;

public class WyciagCustomers {
    public void wykonajWyciag(String wyraz) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        if (wyraz != null) {
            wyraz = wyraz.trim();
        }

        String sql = "SELECT customerName, customerNumber, contactLastName, contactFirstName FROM customers WHERE "
                + "customerName = '" + wyraz + "' "
                + "OR customerNumber = '" + wyraz + "' "
                + "OR contactLastName = '" + wyraz + "' "
                + "OR contactFirstName = '" + wyraz + "'";

        System.out.println(sql);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                String customerName = rs.getString("customerName");
                String customerNumber = rs.getString("customerNumber");
                String contactLastName = rs.getString("contactLastName");
                String contactFirstName = rs.getString("contactFirstName");

                String wynik = customerName + ", " + customerNumber + ", " + contactLastName + ", " + contactFirstName;
                System.out.println(wynik);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
