package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/sjdbc.xml");
		JdbcTemplate temp = context.getBean("jdbcTemplate", JdbcTemplate.class);

		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";

		// fire query
		int result = temp.update(query, 456, "Yunus", "Tumkur");
		System.out.println("Number of record inserted...." + result);

		ApplicationContext context1 = new ClassPathXmlApplicationContext("com/spring/jdbc/sjdbc.xml");
		StudentDao studentDao = context1.getBean("studentDao", StudentDao.class);

		Student student = new Student();

		student.setId(202);
		student.setName("Sim");
		student.setCity("Gvt");

		int result1 = studentDao.insert(student);
		System.out.println("Number of record inserted...." + result1);

		Student student1 = new Student();
		student1.setId(201);
		student1.setName("Sameer");
		student1.setCity("cta");
		int res = studentDao.update(student1);

		System.out.println("Number of data Changed " + res);

//Delete

		int res1 = studentDao.delete(201);
		System.out.println("Deleted... " + res1);

		Student student11 = studentDao.getStudent(456);
		System.out.println(student11);

		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}

	}
}
