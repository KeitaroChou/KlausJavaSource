
package idv.klaus;

import java.util.ArrayList;

public interface GarbageTruckLineMapDAO {
    public ArrayList<GTLineMap> regionalSearch_village(String village);
    public ArrayList<GTLineMap> regionalSearch_city(String city);
}
