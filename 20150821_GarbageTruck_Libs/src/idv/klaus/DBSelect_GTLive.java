package idv.klaus;

import java.sql.*;
import java.util.ArrayList;

public class DBSelect_GTLive implements GarbageTruckLiveDAO{

    @Override
    public ArrayList<GTLive> regionalSearch(String field) {

        String driverName = "com.mysql.jdbc.Driver";        // 連結資料庫
        DBLinker_klaus dblinker = new DBLinker_klaus();
        String connectionString = dblinker.toString();      // 引入連接資料庫資訊

        try {
            
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM jsonIn_GarbageTruckLive WHERE location like '%" + field + "%'");
//            ps.setString(1, field);
            ResultSet resultSet = ps.executeQuery();
            
            ArrayList<GTLive> gtLiveList = new ArrayList();
            
            while (resultSet.next()) {    
                gtLiveList.add(new GTLive(resultSet.getInt(1), resultSet.getString(2), resultSet.getTime(3), resultSet.getString(4)));
            }
            
            connection.close();
            ps.close();
            resultSet.close();
            return gtLiveList;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}
