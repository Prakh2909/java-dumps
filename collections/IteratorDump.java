import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IteratorDump {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        Collections.sort(null, null);
        System.out.println("Using iterator");
        Iterator<Integer> iterator = values.iterator();
        
        while(iterator.hasNext()){
            int value = iterator.next();
            System.out.println(value);
            if(value==3){
                iterator.remove();
            }
        }

        System.out.println("Using for loop");
        for (Integer integer : values) {
            System.out.println(integer);
        }

        System.out.println("Using forEach");
        values.forEach((Integer val)->{  // available in 1.8
            System.out.println(val);
        });
    }
}
