package com.zhouyi.hibernate.demo;

import com.zhouyi.hibernate.demo.entity.Course;
import com.zhouyi.hibernate.demo.entity.Instructor;
import com.zhouyi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/cxk","sing, dance, basketball");
            Instructor instructor = new Instructor("Xukun", "Cai", "caixukun@qq.com");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();




        }finally {
            factory.close();
        }
    }
}
