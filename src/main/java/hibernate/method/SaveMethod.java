package hibernate.method;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveMethod {

    /*
     1)  hibenate save method will return serilizable objects

      thats the id parameter wich we saved

     2)  in save method we can across the triansctions

       ie. outside the transtions we can save the entity



     */
    public static void main(String[] args) {

        //1

       /* Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Empolyee empolyee = new Empolyee();

        empolyee.setName("jayavant");
        empolyee.setSurname("raut");

        // returning serilizable object
        Integer id = (Integer) session.save(empolyee);
        session.getTransaction().commit();*/



        Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tr = session.beginTransaction();
        Empolyee empolyee = new Empolyee();

        empolyee.setName("jayavant");
        empolyee.setSurname("raut");
       session.save(empolyee);
        // the empolyee objects is dettached from current session
       session.evict(empolyee);
        // on this detached object we do  we can persisit object  but new  record will be inserted wich make record duplications
       session.save(empolyee);
         session.flush();
        session.close();



    }
}
