import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class MainApp {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


  //  what is difference between loda  and get method in hibernate

        /*  load and get method are used smae purpose for retreviwenig the object

            bute when the object is not present in data base than loda method will throw the exceptions

            ObjectNotFoundException: No row with the given identifier exists

            where the get method will return   null

          Demo d1 =(Demo)  session.get(Demo.class,"jay");
         System.out.println(d1);


         Demo d =(Demo)  session.load(Demo.class,"jay");
         System.out.println(d);

         */

        HibernateUtil.shutdown();
    }
}
