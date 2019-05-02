package main.hibernate.demo;

import main.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            //Delete the student
            //System.out.println("Deleting student: " + student);
            //Delete student id=2
            //session.delete(student);

            System.out.println("Deleting student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}