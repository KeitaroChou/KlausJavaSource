package Game_v1;

public class Test {

    public static void main(String[] args) {

        Player player1 = new Player(1, "Tom", 10, 100, new Weapon("短弓", 5, 5));
        player1.display();

        Player player2 = new Player(10, "Jhon", 50, 650, new Weapon("大馬士革刀", 20, 15));
        player2.display();

        Player player3 = new Player();
        player3.display();
        
        Player player4 = new Player(2,"Jack", 30, 200);
        player4.display();
        
        Monster mons1 = new Monster("金幣", "地龍", 500, 50000);
        mons1.display();

        Monster mons2 = new Monster("銀幣", "狼人", 20, 500);
        mons2.display();
        
        Character chart1 = new Character();
        chart1.display();

    }

}
