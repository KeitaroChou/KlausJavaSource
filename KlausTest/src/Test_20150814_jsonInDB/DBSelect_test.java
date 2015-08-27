package Test_20150814_jsonInDB;

import idv.klaus.*;
import java.util.ArrayList;

public class DBSelect_test {

    public static void main(String[] args) {

//        GarbageTruckLiveDAO dao = new DBSelect_GTLive();
//        ArrayList<GTLive> list = dao.regionalSearch("板橋區");
//
//        for (GTLive gtl : list) {
//
//            System.out.println(gtl.lineid + "\t" + gtl.car + "\t" + gtl.time + "\t" + gtl.location);
//
//        }
        
        GarbageTruckLineMapDAO dao = new DBselect_GTLineMap();
        ArrayList<GTLineMap> list = dao.regionalSearch_village("雙坑里");

        for (GTLineMap gtl : list) {

            System.out.println(gtl.city + "\t" + gtl.lineid + "\t" + gtl.linename + "\t" + gtl.rank + "\t" + gtl.name + "\t" + 
                gtl.village + "\t" + gtl.longitude + "\t" + gtl.latitude + "\t" + gtl.time + "\t" + gtl.memo + "\t" + 
                gtl.garbage_sun + "\t" + gtl.garbage_mon + "\t" + gtl.garbage_tue + "\t" + gtl.garbage_wed + "\t" + 
                gtl.garbage_thu + "\t" + gtl.garbage_fri + "\t" + gtl.garbage_sat + "\t" + gtl.recycling_sun + "\t" + 
                gtl.recycling_mon + "\t" + gtl.recycling_tue + "\t" + gtl.recycling_wed + "\t" + gtl.recycling_thu + "\t" + 
                gtl.recycling_fri + "\t" + gtl.recycling_sat + "\t" + gtl.foodscraps_sun + "\t" + gtl.foodscraps_mon + "\t" + 
                gtl.foodscraps_tue + "\t" + gtl.foodscraps_wed + "\t" + gtl.foodscraps_thu + "\t" + gtl.foodscraps_fri + "\t" + 
                gtl.foodscraps_sat);

        }
        
        ArrayList<GTLineMap> list2 = dao.regionalSearch_city("板橋區");
        
        for (GTLineMap gtl : list2) {

            System.out.println(gtl.city + "\t" + gtl.lineid + "\t" + gtl.linename + "\t" + gtl.rank + "\t" + gtl.name + "\t" + 
                gtl.village + "\t" + gtl.longitude + "\t" + gtl.latitude + "\t" + gtl.time + "\t" + gtl.memo + "\t" + 
                gtl.garbage_sun + "\t" + gtl.garbage_mon + "\t" + gtl.garbage_tue + "\t" + gtl.garbage_wed + "\t" + 
                gtl.garbage_thu + "\t" + gtl.garbage_fri + "\t" + gtl.garbage_sat + "\t" + gtl.recycling_sun + "\t" + 
                gtl.recycling_mon + "\t" + gtl.recycling_tue + "\t" + gtl.recycling_wed + "\t" + gtl.recycling_thu + "\t" + 
                gtl.recycling_fri + "\t" + gtl.recycling_sat + "\t" + gtl.foodscraps_sun + "\t" + gtl.foodscraps_mon + "\t" + 
                gtl.foodscraps_tue + "\t" + gtl.foodscraps_wed + "\t" + gtl.foodscraps_thu + "\t" + gtl.foodscraps_fri + "\t" + 
                gtl.foodscraps_sat);

        }

    }
}
