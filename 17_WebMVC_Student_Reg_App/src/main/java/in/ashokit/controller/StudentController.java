package in.ashokit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.Student;
import in.ashokit.entity.StudentEntity;
import in.ashokit.repository.StudentRepository;
//import in.ashokit.entity.StudentEntity;
//import in.ashokit.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	//method to load student form
	@GetMapping("/")
	public String loadForm(Model model) {
		LoadFormData(model);
		
		return "index";
	}

	
	//method to  save student form
//	@PostMapping("/save")
//	public String handleSubmit(Student s,Model model)
//	{
//		LoadFormData(model);
//		
//		System.out.println(s);
//		model.addAttribute("msg","Student saved");
//		return "index";
//	}
	
	//method to  save student form
	@PostMapping("/save")
	public String handleSubmit(Student s,Model model)
	{
		StudentEntity entity= new StudentEntity();
		
		//copy data from binding object (student) to entity data (studentEntity)
		//varibles and data type shpuld be same then it copy 
		//primive classes and wrapper class (can copy)
		//refernce classes like arrays ,object (cannot copy)
		BeanUtils.copyProperties(s, entity);
		
		//we are doing this because in student binding it is  (array) (String[] timings)
		                         //In studentEntity it is normal string (String timings)
		            //So we are taking array and converting to string using .toString()
		entity.setTimings(Arrays.toString(s.getTimings()));
		
		studentRepository.save(entity);
		LoadFormData(model);
		
		System.out.println(s);
		model.addAttribute("msg","Student saved");
		return "index";
	}
	
	
	//method to display saved student
	@GetMapping("/viewStudents")
	public String getStudentsData(Model model) {
		List<StudentEntity>students= studentRepository.findAll();
		model.addAttribute("students",students);
		
		return "data";
	}
	
	
	
	
	//boiler plate code
		private void LoadFormData(Model model) {
			List<String>coursesList = new ArrayList<>();
			coursesList.add("java");
			coursesList.add("DevOps");
			coursesList.add("AWS");
			coursesList.add("Python");
			
			List<String> timingsList= new ArrayList<>();
			timingsList.add("Morning");
			timingsList.add("Afternoon");
			timingsList.add("Evening");
			
		
			
			Student student= new Student();
			
			model.addAttribute("courses",coursesList);
			model.addAttribute("timing",timingsList);
			model.addAttribute("student",student);
		}
}
