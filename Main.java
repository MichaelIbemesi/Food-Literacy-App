public class Main{

    public static void main(String[] args) {
        Thread test1 = new Thread(new Test(0));
        Thread test2 = new Thread(new Test(100));

        test1.start();
        test2.start();
    }
}