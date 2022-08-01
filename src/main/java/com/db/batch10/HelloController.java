package com.db.batch10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private StudentRepository repo;

	
	
	@Value("${myMessage}") String msg;
	
	@GetMapping("/hello")
	public String sayHello() {
		return this.msg;
	}
	
	@GetMapping("/student/hi")
	public Student sayHi(@RequestParam("name") String name, @RequestParam("rollno")int rollno) {
		
		Student s = new Student(name,rollno);
		return s;
	}
	@PostMapping("/students/add")
	public Student createStudent(Student s) {
		repo.save(s);//This will fire insert SQL and save data to table in MSQL DB Server
		return s;
	}
	@GetMapping("/student/{rollno}")
	public Student findStudent(@PathVariable("rollno") int rollno) {
		
		Student s = repo.findById(rollno).get();
		return s;
	}
	@GetMapping("/student/all")
	public List<Student> findStudent() {
		
		List<Student> sudents = (List<Student>) repo.findAll();
		return sudents;
	}

}
