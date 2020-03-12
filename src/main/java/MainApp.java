import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class MainApp {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

       /* // Check database version
        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);*/
      /* User user = new User();
       user.setName("yashwant");*/
       Demo demo = new Demo();
     //  query using place holder  // session.createQuery("from Demo where name = ?",Demo.class).setParameter(0,"jaya") .stream()
       session.createQuery("from Demo where name =:name",Demo.class).setParameter("name","jaya").stream() // named  parameter query
               .forEach(de-> System.out.println(de.getName()));

       session.close();


        HibernateUtil.shutdown();
    }
}
