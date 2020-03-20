package hibernate.demo;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class TestCollections {


    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
       /* session.beginTransaction();
        Address address= new Address();
        address.setCity("pune");
        address.setHouse("akshay complex");
        address.setStreet("zeel colleage rod");
        Address address1= new Address();
        address1.setCity("solapur");
        address1.setHouse("green complex");
        address1.setStreet(" green  colleage rod");
        EmbeddedUsers jaya = new EmbeddedUsers();
        Set<Address>  add =jaya.getAddresses();
       add.add(address);
       add.add(address1);
       jaya.setAddresses(add);
        jaya.setEmail("jaya@gmail.com");
        jaya.setName("jayavant");
        jaya.setSurName("raut");
        session.save(jaya);
        session.getTransaction().commit();
        session.close();*/


       /*
          lezy and egar loading

          default the fetch type of hibernate is lezy
          ie. the value objects  list of any join objects will lod onely when on that object
           the action will be taken

           ex . we  get the EmbeddedUsers class with list of address

           the hibernate create the proxy  object of EmbeddedUsers and  fill the user name
            and surname data .but it does not contains the address list
            the address list will be get whe we call getAddesslist method that time
        */


       EmbeddedUsers user= session.get(EmbeddedUsers.class,4);
        System.out.println(user.getName());

        session.close();
        System.out.println(user.getAddresses().size());

    }
}
