package Test_20150716_PolymorphismDemo;

class Elephant extends Animal {
    private String name;
     
    public Elephant(String n, int a, int w) {
        super(a, w);
        setName(n);
    }
     
    public Elephant(int a, int w) {
        this("小象", a, w);
    }
     
    public Elephant() {
        this("小象", 3, 150);
    }
     
    public String getName() {
        return name;
    }
     
    public void setName(String n) {
        if (n == null || n.equals("")) {
            name = "無名氏";
        }
        else {
            name = n;
        }
    }
     
    public void speak() {
        System.out.println("哈囉，我的名字是" + getName());
        System.out.println("我已經" + getAge() + "歲，有" + getWeight() + "公斤重");
    }
}