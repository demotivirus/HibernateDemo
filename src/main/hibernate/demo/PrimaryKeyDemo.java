package main.hibernate.demo;

import main.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        //Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = sessionFactory.getCurrentSession();

        try{

            //Creating 3 object
            System.out.println("Creating new object...");

            Student student1 = new Student("Peter", "Walker", "peterWalker@gmail.com");
            Student student2 = new Student("Lana", "Walker", "lanaWalker@gmail.com");
            Student student3 = new Student("Mark", "Walker", "markWalker@gmail.com");

            //Start transaction
            session.beginTransaction();

            //Save  the object
            session.save(student1);
            session.save(student2);
            session.save(student3);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}