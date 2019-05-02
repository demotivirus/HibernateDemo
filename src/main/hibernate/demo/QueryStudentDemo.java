package main.hibernate.demo;

import main.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        //Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = sessionFactory.getCurrentSession();

        try{

            //Start transaction
            session.beginTransaction();

            //Query students
            List<Student> students = session.createQuery("from Student").getResultList();

            //Display the students
            displayTheStudents(students);

            //Query students last name: "Walker"
            students = session.createQuery("from Student s where s.lastName='Walker'").getResultList();

            System.out.println("\n\nStudents who last name of Walker:\n");
            displayTheStudents(students);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }

    public static void displayTheStudents(List<Student> students){
        for(Student foreach : students)
            System.out.println(foreach);
    }
}