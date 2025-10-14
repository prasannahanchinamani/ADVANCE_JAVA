package com.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("Prasanna");
        student.setPercentage(85);
        student.setStudentId(2);
        student.setStudentName("Prajwal Hanchinamani");
        student.setPercentage(93);
        student.setStudentId(3);
        student.setStudentName("Pramodh");
        student.setPercentage(80);

//        Configuration config = new Configuration();
//        config.configure("hibernate.cfg.xml"); // load config
//        config.addAnnotatedClass(com.hibernateDemo.Student.class); // add entity

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(com.hibernateDemo.Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        session.persist(student);

        //to get from database
//        Student s = session.get(Student.class, 1); // Fetch record with ID = 1
        Student s = session.find(Student.class, 1);
//        byId(Studnet.class).getReference()
        if (s != null) {
            System.out.println("Student found:");
            System.out.println("ID: " + s.getStudentId());
            System.out.println("Name: " + s.getStudentName());
            System.out.println("Percentage: " + s.getPercentage());
        } else {
            System.out.println("No student found with that ID.");
        }
// to update
        session.merge(student);
//to remove
        Student s1=session.find(Student.class,3);
        session.remove(s1); //pbject passS
        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println("✅ Record saved successfully!");
    }
}
