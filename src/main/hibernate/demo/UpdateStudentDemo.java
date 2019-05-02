package main.hibernate.demo;

import main.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        //Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        // create session
        Session session = sessionFactory.getCurrentSession();

        try{

            int studentId = 1;

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Updating the student...");
            student.setFirstName("Nana");

            //Commit transaction
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            //New update
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='student@lib.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}