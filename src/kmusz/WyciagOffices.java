package kmusz;

import java.sql.*;

public class WyciagOffices {
    public void wykonajWyciag(String wyraz) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        if (wyraz != null) {
            wyraz = wyraz.trim();
        }

        String sql = "SELECT `city`,`country`,`officeCode`,`territory` FROM `offices` WHERE "
                + "city = '" + wyraz + "'"
                + "OR country = '" + wyraz + "'"
                + "OR officeCode = '" + wyraz + "'"
                + "OR territory = '" + wyraz + "'"
                ;
        System.out.println(sql);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                String city = rs.getString("city");
                String country = rs.getString("country");
                String officeCode = rs.getString("officeCode");
                String territory = rs.getString("territory");
                String wynik = city + ", " + country + ", " + officeCode + ", " + territory;
                System.out.println(wynik);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
