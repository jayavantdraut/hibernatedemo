package hibernate.demo;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class EmbeddleObjectTest {
    public static void main(String[] args) {

        /*

        there are two type of objecct
          1 entity or model

             this  each object corresoponds to table
               thats this objects  maps with databse table  this object have indepedly mening
               ex
                 class user{
                   string name
                   string mobile
                 }

                 each fileds is corrsosponds to table colums of databse

                 ie  name  : whos name  ??? ans users name


                 2   value object

                   this objects does not have its won mening
                    this object  without live the entity  objects

                    ex . address{
                      string house;
                      string street;
                      }
                      this is value objects   it deontos have its won menning
                       ex whose address ???   ans is user adderss

                       for this objects is embedded in entity class
                        using flowwing examples


         */

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Address address= new Address();
        address.setCity("pune");
        address.setHouse("akshay complex");
        address.setStreet("zeel colleage rod");
        Address address1= new Address();
        address1.setCity("solapur");
        address1.setHouse("green complex");
        address1.setStreet(" green  colleage rod");
        EmbeddedUsers jaya = new EmbeddedUsers();
       // jaya.setOffice(address1);
        //jaya.setAddress(address);
        jaya.setEmail("jaya@gmail.com");
        jaya.setName("jayavant");
        jaya.setSurName("raut");
        session.save(jaya);
        session.close();


    }
}
