package Test_20150716_PolymorphismDemo;

class PolymorphismDemo {
    public static void main(String[] args) {
        Animal puppy1, puppy2, puppy3; 
        puppy1 = new Elephant("大象", 6, 70);
        puppy2 = new Elephant();
        puppy3 = new Elephant("林旺", 88, 5000);
         
        puppy1.speak();
        puppy2.speak();
        puppy3.speak();
    }
}