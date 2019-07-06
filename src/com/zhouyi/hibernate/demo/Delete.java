package com.zhouyi.hibernate.demo;

import com.zhouyi.hibernate.demo.entity.Instructor;
import com.zhouyi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            Instructor target = session.get(Instructor.class, 2);

            session.delete(target);

            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }
}
