/**
 * @author liujiawei
 * @Package: PACKAGE_NAME
 * @ClassName: exer01
 * @Description:
 * @date 2022/11/1 16:40
 */
public class exer01 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Window1());
        for (int i = 0; i <= 10; i++) {
            System.out.println("abc" + i);
            if(i==5){
                thread.start();
                thread.join();
            }
        }
    }
}
class Window1 implements Runnable{
    private static int ticket = 0;
    @Override
    public void run() {
        while(true){
            synchronized(this){
                System.out.println("hello" + (++ticket));
            }
            if(ticket == 10){
                break;
            }
        }
    }
}
class Cat extends Thread{
    int t = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵:" + t);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t++;
            if(t == 10){
                break;
            }
        }

    }
}
