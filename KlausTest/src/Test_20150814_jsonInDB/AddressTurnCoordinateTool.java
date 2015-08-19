// ==========================================
// ＤＢ讀取地址、丟出處理、座標寫入ＤＢ
// ==========================================

package Test_20150814_jsonInDB;

public class AddressTurnCoordinateTool {

    public static void main(String[] args) {

      String a = "新北市三芝區埔坪里埔頭坑41號";
      
      AddressTurnCoordinate atc = new AddressTurnCoordinate(a);
        System.out.println(atc);
        
    }
    
}
