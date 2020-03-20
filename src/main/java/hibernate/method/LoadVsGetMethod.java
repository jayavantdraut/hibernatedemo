package hibernate.method;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoadVsGetMethod {
    /*
     load method will return the proxy object .
     lod method will throw the exception when given id object is not found

     get  method will egerly  loaded method wich load  fecth the data and load in two entity class

     if the coresponds id record not found than it will return null value  does not throw any exceptions


     */
    public static void main(String[] args) {


        Session session = HibernateUtil.getSessionFactory().openSession();

       Empolyee empolyee=  session.load(Empolyee.class,10);

       // load method will return proxy object when we close the session and than calld sopln than exception will throw
        // lod method will improve perfomance because does not load all object it will load onely id marameter veraible
        // if we close the sesssion and then called  getid() method this will return id
        // bust except id paramete we called another method it will throw lezy initilization error
       session.close();;
        System.out.println(empolyee.getEmpid());
        //  System.out.println(empolyee.getName());  // this stament throw exceptions

//*****************************get method *********************
        Session session1 =HibernateUtil.getSessionFactory().openSession();
        Empolyee empolyee1= session1.get(Empolyee.class,10);
       session1.close();
        System.out.println(empolyee1.getEmpid());
         System.out.println(empolyee1.getName());  // this stament  does not throw any error because the object is egerly loded




    }
}
