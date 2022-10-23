package org.example;
import software_eng_3_a1_v1.*;
import software_eng_3_a1_v1.Module;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Create 6 new students
        Student student1 = new Student("Alex", 20, "01/01/2002");
        Student student2 = new Student("Brian", 24, "09/08/1998");
        Student student3 = new Student("Mary", 18, "17/04/2004");
        Student student4 = new Student("Dylan", 21, "01/03/2001");

        //Create 2 new courses
        Course_Programme compsci = new Course_Programme("BCT", "2022-09-01 09:00:00", "2023-07-01 09:00:00");
        Course_Programme engineering = new Course_Programme("BE", "2022-10-02 09:00:00", "2023-08-03 09:00:00");
        ArrayList<Course_Programme> courses = new ArrayList<Course_Programme>(Arrays.asList(compsci, engineering));

        //Create 2 new Lecturers
        Lecturer lecturerSteve = new Lecturer("Steve Mac", 45, "09/04/1977");
        Lecturer lecturerBill = new Lecturer("Bill O'Dea", 60, "09/04/1962");

        //Create 3 new modules
        Module programming = new Module("Programming", "CT123", "lecturerSteve");
        Module electronics = new Module("Electronics", "EE123", "lecturerBill");
        Module webdev = new Module("WebDev", "CS123", "lecturerSteve");

        student1.setModules(new ArrayList<Module>(Arrays.asList(programming, electronics)));
        student2.setModules(new ArrayList<Module>(Arrays.asList(programming, electronics, webdev)));
        student3.setModules(new ArrayList<Module>(Arrays.asList(programming, electronics, webdev)));
        student4.setModules(new ArrayList<Module>(Arrays.asList(programming, webdev)));

        student1.addCourse(engineering);
        student2.addCourse(compsci);
        student2.addCourse(engineering);
        student3.addCourse(compsci);
        student3.addCourse(engineering);
        student4.addCourse(compsci);

        compsci.setStudents(new ArrayList<Student>(Arrays.asList(student2, student3, student4)));
        engineering.setStudents(new ArrayList<Student>(Arrays.asList(student1, student2, student3)));

        //Add students to modules
        programming.addStudent(student1);
        programming.addStudent(student2);
        programming.addStudent(student3);
        electronics.addStudent(student2);
        electronics.addStudent(student3);
        electronics.addStudent(student4);
        electronics.addStudent(student1);
        webdev.addStudent(student3);
        webdev.addStudent(student2);
        webdev.addStudent(student4);

        compsci.addModule(programming);
        compsci.addModule(webdev);
        engineering.addModule(programming);
        engineering.addModule(electronics);

        for (Course_Programme course : courses)
        {
            System.out.println("Course Code:\t" + course.getCourseName());
            ArrayList<Module> courseModules = course.getModules();
            System.out.print("Course Modules:\t");
            for (Module mod : courseModules)
            {
                System.out.print(mod.getName() + "\t\t");
            }
            System.out.println("");
            ArrayList<Student> courseStudents = course.getStudents();
            System.out.println("Students on this course:");
            for (Student s : courseStudents)
            {
                System.out.print("Username: " + s.getUsername() + "\t");
                System.out.print("Assigned Modules: ");
                ArrayList<Module> modules = s.getModules();
                for (Module m : modules)
                {
                    System.out.print(m.getName() + " ");
                }
                ArrayList<Course_Programme> s_courses = s.getCourses();
                System.out.print("\t\tCourses Registered for: ");
                for (Course_Programme c : s_courses)
                {
                    System.out.print(c.getCourseName() + "\t");
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
        }

    }
}