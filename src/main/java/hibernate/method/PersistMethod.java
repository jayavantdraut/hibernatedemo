package hibernate.method;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistMethod {
    /*
    persist method does not  return any value
    its return type is void


    persist metod  one object is detached from seeeions on that object we do not call persist metods
    outside of its not call

     */

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();

        Empolyee empolyee = new Empolyee();

        empolyee.setName("jayavant");
        empolyee.setSurname("raut");

        session.persist(empolyee);

        // the empolyee objects is dettached from current session
        session.evict(empolyee);

        // on this detached object we do not persist agin in same sessions
        session.persist(empolyee);

        session.flush();
        session.close();
    }
}
