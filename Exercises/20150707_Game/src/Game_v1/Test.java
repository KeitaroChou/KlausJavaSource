package Game_v1;

public class Test {

    public static void main(String[] args) {
        
        Weapon weap001 = new Weapon("複合弓", 10, 15);
        Weapon weap002 = new Weapon("小刀", 3, 5);

        Player player1 = new Player(1, "Tom", 10, 100, new Weapon("短弓", 5, 5));
        player1.display();

        Player player2 = new Player(10, "Jhon", 50, 650, new Weapon("大馬士革刀", 20, 15));
        player2.display();
        
        // 新創角色、引用 player1 的武器
        System.out.println("\n=== 新創角色、引用 player1 的武器 ===");
        Player player3 = new Player(2, "Mark", 20, 360);
        Weapon weap1 = player1.getWeap();
        player3.setWeap(weap1);
        player3.display();
        
        // 經過 static 的方式，直接使用類別 Factory 的方法，新增預設角色
        System.out.println("\n=== 經過 static 的方式，直接使用類別 Factory 的方法，新增預設角色 ===");
        Player player4 = Factory.playerDefault();
        player4.display();
        System.out.println("總數 = " + Factory.getTotal());
        Monster monster1 = Factory.monsterDefault();
        monster1.display();
        System.out.println("總數 = " + Factory.getTotal());

//        Player player3 = new Player();
//        player3.display();
//        
//        Player player4 = new Player(2,"Jack", 30, 200);
//        player4.display();
//        
//        Monster mons1 = new Monster("金幣", "地龍", 500, 50000);
//        mons1.display();
//
//        Monster mons2 = new Monster("銀幣", "狼人", 20, 500);
//        mons2.display();
//        
//        Character chart1 = new Character();
//        chart1.display();
//        
//         // 單獨新增與傳回
//        Character chart2 = new Character();
//        chart2.setName("Fuck");
//        chart2.setName("Marry");
//        chart2.getName();
//        chart2.getHp();

    }

}
