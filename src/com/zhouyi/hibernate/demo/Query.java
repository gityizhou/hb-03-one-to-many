package com.zhouyi.hibernate.demo;

import com.zhouyi.hibernate.demo.entity.Course;
import com.zhouyi.hibernate.demo.entity.Instructor;
import com.zhouyi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Query {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            int id = 1;
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println(instructor);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
