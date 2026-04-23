package org.example;


import Entity.Address;
import Entity.Student;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.rmi.StubNotFoundException;

public class Main {
    public static void main(String[] args) {
        Address address=new Address("A-42","Master Colony Hrabansh Nagar","Ghaziabad");
        Student student = new Student(1,21,"Nishkarsh Tyagi",address);

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClasses(Entity.Student.class);
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //save the data
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();


        //To get the data

        Student s1=new Student();
        session.load(s1,1);
        System.out.println(s1.getName());

//        to Update the data
//        Transaction transaction = session.beginTransaction();
        Address address2=new Address("A-42","Master Colony","Ghaziabad");
        Student s2=new Student(1,21,"Sparsh Tyagi",address2);
        session.merge(s2);
//        transaction.commit();
//        session.close();

        //to delete the data

//        Transaction transaction = session.beginTransaction();
//        Student s2=new Student();
        session.load(s2,1);

        session.remove(s2);
        transaction.commit();

    }
}