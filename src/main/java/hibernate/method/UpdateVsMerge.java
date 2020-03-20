package hibernate.method;

import hibernate.demo.User;
import hibernate.util.HibernateUtil;
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

       Session session =factory.openSession();
       session.beginTransaction();

       Empolyee empolyee = new Empolyee();

        empolyee = session.get(Empolyee.class,10);

        Empolyee em = new Empolyee();
        em.setEmpid(10);
        em.setName(" ravi");
// this method throw an exceptions   A different object with the same identifier value was already associated with the session
        //becaus for new empolyee object id is also 10 . in single session  two object with same identifier not allowed

    //  session.update(em);

      // for merge method its copy the one object data to another object and merge the changes and update the object
       session.merge(em);

       session.getTransaction().commit();















    }
}
