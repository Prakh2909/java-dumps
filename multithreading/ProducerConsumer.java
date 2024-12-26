public class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource(5);

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 6; i++) {
                try {
                    sr.produce(i);
                } catch (Exception e) {
                    // handle exception
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 6; i++) {
                try {
                    sr.consume();
                } catch (Exception e) {
                    // handle exception
                }      
            }
        });
        t2.start();
        t1.start();
        
        
    }
}
