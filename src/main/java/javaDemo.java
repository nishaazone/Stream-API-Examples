import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class javaDemo {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

//        for(int i = 0; i < list.size(); i ++)
//        {
//            System.out.println(list.get(i));
//        }

//        for(Integer i : list){
//            System.out.println(i);
//        }

//        Iterator<Integer> i = list.iterator();
//        while(i.hasNext()){
//            System.out.println(i.next());
//        }

        // External for loops above
        // Internal iterations can be achieved through stream API
        list.forEach(i -> System.out.println(i));
    }
}


