import org.hibernate.Session;

public class MainApp {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

       /* // Check database version
        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);*/
       User user = new User();
       user.setName("jayavant");
       Demo demo = new Demo();
       demo.setName("jaya");
       demo.setSurname("raut");

       session.save(demo);


        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }
}
