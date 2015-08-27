
package idv.klaus;

import java.sql.Time;

public class GTLive {
    
    public int lineid;
    public String car;
    public Time time;
    public String location;
    
    public GTLive(int lineid, String car, Time time, String location) {
        
        this.lineid = lineid;
        this.car = car;
        this.time = time;
        this.location = location;
        
    }
    
}