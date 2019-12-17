public class Test implements Runnable{

    private int count;

    public Test(int cnt){
        this.count = cnt;
    }

    public void run(){
        for(int i = 0; i < 100; i++){
            count += 1;
        }

        System.out.println(count);
    }

    public int getCount(){
        return count;
    }
}
