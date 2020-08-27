package com.github.mathan26.hibernate;

import com.github.mathan26.hibernate.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Users.class)
                .buildSessionFactory();

        Session session= sessionFactory.getCurrentSession();
        System.out.println("CONFIG LOADED SUCCESSFULLY");
        try {
            // INSERT

            // Users user = new Users("username","password","firstname","lastname");
            // start transaction
            session.beginTransaction();
            //save
            // session.save(user);
            //commit
            // session.getTransaction().commit();
            //System.out.println("saved successfully");

            // SELECT
            /*Users user = new Users();
            user=session.get(Users.class,0);
            System.out.println(user);*/


            // UPDATE
            /*Users users=new Users();
            users=session.get(Users.class,0);
            users.setFirstName("Mathankumar");
            session.getTransaction().commit();*/

            //DELETE
            Users users = new Users();
            users=session.get(Users.class,0);
            session.delete(users);
            System.out.println("Record Deleted Successfully.");
            session.getTransaction().commit();


        }finally {
            session.close();
        }
    }
}
