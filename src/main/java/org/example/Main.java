package org.example;


import Entity.Address;
import Entity.Laptop;
import Entity.Student;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.rmi.StubNotFoundException;

public class Main {
    public static void main(String[] args) {
        Laptop laptop1=new Laptop(1,"Hp",256);
        Student student1=new Student(1,"Nishkarsh Tyagi",21,laptop1);

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClasses(Student.class);
        configuration.addAnnotatedClasses(Laptop.class);
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(laptop1);
        session.persist(student1);

        Student student2=new Student();
        session.load(student2,1);
        System.out.println(student2.toString());
        transaction.commit();
        session.close();
    }
}