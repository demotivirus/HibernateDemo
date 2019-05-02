package main.hibernate.demo;

import main.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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

            Student student1 = new Student("Andrew", "Norton", "andrewNorton@gmail.com");

            //Start transaction
            session.beginTransaction();

            //Save the object
            session.save(student1);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Saving student by id: " + student1.getId());
            System.out.println("Done!");

            //New transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + student1.getId());
            Student myStudent = session.get(Student.class, student1.getId());
            System.out.println("Get complete: " + myStudent);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}