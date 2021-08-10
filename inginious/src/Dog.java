public class Dog extends Animal {

    public String race;
    public Dog(int serialNumber, String race) {
        super(serialNumber);
        this.race = race;
    }

    public void waf(){
        System.out.println("waf waf");
    }


    public static void main(String[] args){
        String a = "LEPL";
        String b = a;
        b = "UCL";
        System.out.println(a);
        System.out.println(b);
    }
}
