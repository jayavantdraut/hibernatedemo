import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateVsMerge {

    public static void main(String[] args) {


        /*

          in hibernate the firest level cache wich is session cache

           in session cache if two objects wich same id  ie
            emp1  id = 1
            emp2  with id =1

            update :
            and we call update method than exception will throw than two object with same identifier

            in  merege :

            firest merge method will call the select  query  for using this id

            and than copy the content of firest object two second object

            if there is change in first and second object than update statement will exeuted



         */

       SessionFactory factory= HibernateUtil.getSessionFactory();
        User jaya =null;
        Session  session = factory.openSession();
        session.getTransaction().begin();

      jaya = session.get(User.class,5);
     session.getTransaction().commit();
     session.close();

        System.out.println("jaya is    "+ jaya);
     jaya.setName("yashw123rt");

     Session session1 = factory.openSession();

     session1.getTransaction().begin();

   //  session1.get(User.class,5);

     session1.update(jaya);

     session1.getTransaction().commit();








    }
}
