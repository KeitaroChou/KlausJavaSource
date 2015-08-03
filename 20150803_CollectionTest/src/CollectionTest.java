
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;


public class CollectionTest {

    public static void main(String[] args) {

        ArrayList alist = new ArrayList();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        
        HashSet hs = new HashSet();
        hs.add(30);
        hs.add(10);
        hs.add(20);
        
        LinkedList llist = new LinkedList();
        llist.addAll(alist);            // addAll 把同是使用 Collection 的物件(alist)內容加到 llist
        llist.addAll(hs);
        
        System.out.println(llist);
        
        TreeSet tset = new TreeSet(llist);      // 將 llist 排序後，指定給 tset
        System.out.println(tset);
        
    }
    
}
