public class MultiThreadingExample{
    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Runnable r2 = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread t2 = new Thread(r2);
        t2.start();

        Thread t3 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" using Lambda function");
        });
        t3.start();

    }

}