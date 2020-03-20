package hibernate.object_lifecycle;

import hibernate.method.Empolyee;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class TestLifeCycle {

    /*

       in java object have two state

       1 ) new  object is created and stored in heap area

       2 ) object is deleted  that is destoyed by garbage collector

       Hibernate  state

       1)Transient state  : when we create a java object using new keyword  its on tra state. this state is not
                            associated with any database. ie. change  in java object is not affect on any database
                             operations.

       2) Persistent state : to convert  any Transient object to persistant object state we  can call
                             follwing method on session object

                             1) session.save(Transient object);
                             2) session.persist(Transient object);
                             3) session.saveOrUpdate(Transient object);
                            4)  session.update(Transient object);

                            this will convert tansient object to persistant object this object is track or managed by hibernate
                             this single  object is corresponds to single row of table
                             than any change is happen on persisant objects is syc with corrosponds table row.
                             that is we chage name of emolyee  this will also update in table

                            *** we can also get transient object directly by calling

                            session.get(),session.load() methods;



       3) Detached state :   when the object is detached state its not associated with session . ie. not syc with
                              databse  that is any changes happen with detached objects is not affected on databse.

                              we can convert transient object to detached by following method
                              session.close();
                              session.clear();
                              session.evict(persistant object)
                              session.detach(persistant object)


          is it possible to converting detached object to transient object ??

             >>>>>  yes

             by calling following method we can convert detached object to transizent

                             1) session.save();
                             3) session.saveOrUpdate();
                            4)  session.merge();


     */


    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

 // this is transizent state of object
       /* Empolyee empolyee = new Empolyee();

        empolyee.setName("sumit");
        empolyee.setEmpid(19);
        empolyee.setSurname("bandal2");
*/

        //******** tranzient to persistant ********* state
        // afer the session.save this is persist stae object hiernate will track it
      //  session.save(empolyee);

        // save or update method firest fires the select query and fetch the object.
        //  if there is diff between database objecvt and tranzient object than onely update query will fires
        // this mehod does not throw duplicae id exceptions if objects presnts it update else save
      //        session.saveOrUpdate(empolyee);

            // update query every time fire update query it does not check is is current object is change or not
      //   session.update(empolyee);

        //this is save as save method  its return type is void
        //session.persist(empolyee);


        //********  persistant to dettatched state ***********



      Empolyee test=  session.get(Empolyee.class,19); // tranzient state

        //  using below 4 method the persistant object will be go in dettatched state  employee object in dettached state
      //  session.clear()
       // session.close();
        //session.evict(test);
        // session.detach(test);



        //*********** detatched state to persistant state *************

        Session  newSession = HibernateUtil.getSessionFactory().openSession();
        newSession.beginTransaction();


        //newSession.persist(test);  detached object is not possible to re attach using persist methos
//        newSession.save(test);  // the new entry will be inserted in databse wich duplicate record

        //newSession.saveOrUpdate(test);  // hibernate will fire  update query because does not what will be changes in dettached state

       // newSession.update(test);
        newSession.flush();;
        newSession.close();;


    }



}
