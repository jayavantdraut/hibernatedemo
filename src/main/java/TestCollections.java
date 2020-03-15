import java.util.ArrayList;
import java.util.List;

public class TestCollections {

    public static void main(String[] args) {

        List<String> test = new ArrayList();

        test.add("ja");
        test.add("jayavant");

        test.add("ja");

       // test.forEach( s-> System.out.println(s.toUpperCase()));

        for (Object  test1: test){



            if(test1 instanceof String){

                String te = (String) test1;
                 te =te.toUpperCase();
                System.out.println(te);

            }

        }



    }
}
