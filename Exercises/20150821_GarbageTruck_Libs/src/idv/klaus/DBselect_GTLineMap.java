package idv.klaus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBselect_GTLineMap implements GarbageTruckLineMapDAO {

    private final String driverName = "com.mysql.jdbc.Driver";        // 連結資料庫
    private final DBLinker_klaus dblinker = new DBLinker_klaus();
    private final String connectionString = dblinker.toString();      // 引入連接資料庫資訊

    @Override
    public ArrayList<GTLineMap> regionalSearch_village(String village) {

        try {

            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM jsonIn_GarbageTruckLineMap WHERE village = ?");
            ps.setString(1, village);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<GTLineMap> gTLineMapsList = new ArrayList();

            while (resultSet.next()) {
                gTLineMapsList.add(new GTLineMap(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getTime(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17),
                        resultSet.getString(18),
                        resultSet.getString(19),
                        resultSet.getString(20),
                        resultSet.getString(21),
                        resultSet.getString(22),
                        resultSet.getString(23),
                        resultSet.getString(24),
                        resultSet.getString(25),
                        resultSet.getString(26),
                        resultSet.getString(27),
                        resultSet.getString(28),
                        resultSet.getString(29),
                        resultSet.getString(30),
                        resultSet.getString(31)));
            }

            connection.close();
            ps.close();
            resultSet.close();
            return gTLineMapsList;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    @Override
    public ArrayList<GTLineMap> regionalSearch_city(String city) {

        try {

            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM jsonIn_GarbageTruckLineMap WHERE city = ?");
            ps.setString(1, city);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<GTLineMap> gTLineMapsList = new ArrayList();

            while (resultSet.next()) {
                gTLineMapsList.add(new GTLineMap(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getTime(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17),
                        resultSet.getString(18),
                        resultSet.getString(19),
                        resultSet.getString(20),
                        resultSet.getString(21),
                        resultSet.getString(22),
                        resultSet.getString(23),
                        resultSet.getString(24),
                        resultSet.getString(25),
                        resultSet.getString(26),
                        resultSet.getString(27),
                        resultSet.getString(28),
                        resultSet.getString(29),
                        resultSet.getString(30),
                        resultSet.getString(31)));
            }

            connection.close();
            ps.close();
            resultSet.close();
            return gTLineMapsList;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;

    }

}
