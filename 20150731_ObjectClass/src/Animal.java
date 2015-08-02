
import java.util.*;

interface CanAttack {
    void attack(); // 自動補上 public abstract
}

// ======================================

interface CanFly {
    void fly();  // 自動補上 public abstract
}

// ======================================

abstract public class Animal implements CanAttack, Comparable<Animal> { // 抽象類別，為了 TreeSet 需要實作介面 Comparable
    
    String name;

    @Override
    abstract public void attack(); // 抽象方法
    
    public String getAnimalName() {
        return this.name;
    }
    // ----------------------------------------------------
    public void setAnimalName(String name) {
        this.name = name;
    }
    // ----------------------------------------------------
    public void print() {
        System.out.println("我的類別是：" + this.getClass().getName() + "，名字叫：" + this.name);
    }
    // ----------------------------------------------------
    @Override   // for Object
    public String toString() {
        return "class：" + this.getClass().getName() + " name：" + this.name;
    }
    // ----------------------------------------------------
    @Override   // for Animal
    public int hashCode() {     // 雜湊碼
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }
    // ----------------------------------------------------
    @Override   // for Animal
    public boolean equals(Object obj) {     // 需搭配方法 hashCode()
        if (obj == null) {      // 判斷是否空值
            return false;
        }
        if (Animal.this.getClass() != obj.getClass()) {     // 判斷類別名稱是否相同
            return false;
        }
        final Animal other = (Animal) obj;      // 類別轉換
        if (!Objects.equals(this.name, other.name)) {       // 判斷本類別的 name 與傳來的 name 是否相同
            return false;
        }
        return true;
    }
    // ----------------------------------------------------
    @Override   // for 介面 Comparable (TreeSet 只接受具有 Comparable 特性的物件(這裡把特性綁給 Animal))
    public int compareTo(Animal other) {        // 傳回正整數
        
        // 以下判斷用字串字元長度分大小
        if(this.name.length() > other.name.length()) {
            return 1;               // 傳回正整數，表示大於指定物件
        } else if(this.name.length() < other.name.length()) {
            return -1;              // 傳回負整數，表示小於指定物件
        } else {
            return  0;              // 傳回零，表示等於指定物件
        }
        
//        return this.name.length() - other.name.length();        // 簡單寫法
//        return -(this.name.length() - other.name.length());        // 順序顛倒寫法
        
    }
}

// ======================================

// 狗
class Dog extends Animal {
    @Override
    public void attack() { // 實作
        System.out.println("用牙齒咬");
    }
}

// ======================================

// 貓
class Cat extends Animal {
    @Override
    public void attack() { // 實作
        System.out.println("用貓爪");
    }
}

// ======================================

// 鳥
// Bird 繼承 Animal 實作 會飛的 介面
class Bird extends Animal implements CanFly {
    // ----------------------------------------------------
    @Override
    public void attack() { // 實作
        System.out.println("用頭撞");
    }
    // ----------------------------------------------------
    @Override
    public void fly() {
        System.out.println("飛起來");
    }
}

// ======================================

// 飛機
// Airplane 自動繼承 Object 實作 會飛的 介面
class Airplane implements CanFly {
    @Override
    public void fly() {
        System.out.println("飛機起飛");
    }
}

// ======================================

// 超人
class Superman implements CanAttack, CanFly {
    // ----------------------------------------------------
    @Override
    public void attack() {
        System.out.println("超人 雷射攻擊");
    }
    // ----------------------------------------------------
    @Override 
    public void fly() {
        System.out.println("超人 超音速飛行");
    }
}