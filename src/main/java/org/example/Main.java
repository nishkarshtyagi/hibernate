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
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setAge(21);
        student1.setName("Nishkarsh Tyagi");
        student1.setRoll(1);

        Student student2 = new Student();

        student2.setName("Sparsh Tyagi");
        student2.setRoll(2);
        student2.setAge(23);

        Laptop laptop1 = new Laptop();
        Laptop laptop2=new Laptop();
        Laptop laptop3=new Laptop();

        laptop1.setId(1);
        laptop1.setModel("Hp");
        laptop1.setRam(256);

        laptop2.setId(2);
        laptop2.setRam(512);
        laptop2.setModel("Dell");

        laptop3.setModel("Lenovo");
        laptop3.setId(3);
        laptop3.setRam(800);

        student1.setLaptop(List.of(laptop1,laptop3));

        student2.setLaptop(List.of(laptop1,laptop2,laptop3));

        laptop1.setStudent(List.of(student1,student2));
        laptop2.setStudent(List.of(student2));
        laptop3.setStudent(List.of(student1,student2));

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClasses(Student.class);
        configuration.addAnnotatedClasses(Laptop.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(student1);
        session.persist(student2);
        session.persist(laptop1);
        session.persist(laptop2);
        session.persist(laptop3);

        transaction.commit();
        session.close();



    }
}