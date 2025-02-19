package in.ashokit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import in.ashokit.entity.Product;
import in.ashokit.entity.Student;

import in.ashokit.repository.StudentRespository;
import in.ashokit.repository.productRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	//	StudentRespository studentRespository = context.getBean(StudentRespository.class);

		// Save Record
//		Student student = new Student();
//		student.setId(103);
//		student.setName("Ashok");
//		student.setRank(1122L);
//		student.setGender("male");
//		studentRespository.save(student);
//		System.out.println("Record inserted");

		// get Record by id

//		Optional<Student>optional= studentRespository.findById(101);
//		if(optional.isPresent())
//		{
//			System.out.println(optional.get());
//		}

		// get all
//		Iterable<Student>std= studentRespository.findAll();
//		std.forEach(s->System.out.println(s));

		// delete
//		if(studentRespository.existsById(101))
//		{
//			studentRespository.deleteById(101);
//		}
//		else {
//			System.out.println("No record Present");
//		}

		// count
//		long count=studentRespository.count();
//		System.out.println("record count :: "+count);

		// save multiple record at a time (save all)
//		Student s1= new Student(103,"Orlean",100l,"Male");
//		Student s2= new Student(104,"Cathy",101l,"FeMale");
//		Student s3= new Student(105,"Buttler",102l,"Male");
//		Student s4= new Student(106,"Smith",103l,"Male");
//		Student s5= new Student(107,"Sahil",104l,"Male");
//		//adding all objects into one list
//	    List<Student>std=Arrays.asList(s1,s2,s3,s4,s5);
//		studentRespository.saveAll(std);
//		System.out.println("Bulk data save successfully");

		// FindByGender (user define method ) (non primary key data)
//		List<Student> maleStudents= studentRespository.findByGender("male");
//		maleStudents.forEach(System.out::println);

		// findByRankGreaterThanEqual (user define method) (non primary key data)

//		List<Student> rank = studentRespository.findByRankGreaterThanEqual(103l);
//		rank.forEach(System.out::println);

		// FindByRank (user define method) (non primary key data)

//		List<Student> rank1 = studentRespository.findByRankLessThanEqual(103l);
//		rank1.forEach(System.out::println);
		
		// findByRankGreaterThanEqual (user define method) (non primary key data)
//		List<Student> rank1 = studentRespository.findByGenderAndRankGreaterThanEqual("male", 103l);
//		rank1.forEach(System.out::println);
		
		
		
		//Custom Query
//		List<Student> student = studentRespository.getAllStudents();
//		
//		student.forEach(System.out::println);
//		
		
		
		//Pagination
		
		
//		int pageSize=3;
//		System.out.println("Enter the page no");
//		Scanner sc= new Scanner(System.in);
//		int page=sc.nextInt();
//		
//		PageRequest of = PageRequest.of(page-1,pageSize);
//	    Page<Student> std= studentRespository.findAll(of);
//		List<Student>student=std.getContent();
//		student.forEach(System.out::println);
		
		
		//Sorting
//		List<Student>student= studentRespository.findAll(Sort.by("name").descending());
//	student.forEach(System.out::println);
		
		//queryByExample
//		Student s = new Student();
//		s.setGender("male");
//		s.setRank(103l);
//		Example<Student> exam=Example.of(s);
//		List<Student>student= studentRespository.findAll(exam);
//		student.forEach(System.out::println);
		
		
		//Delete (custom query)
		
//		studentRespository.deleteStudent(107);
//		System.out.println("deleted .....");
		
		//update  (custom query)
//		studentRespository.updateStudent(106,"female");
//		System.out.println("deleted .....");

		//insert  (custom query)
//		studentRespository.insertStudent(108,"male","Shaik");
		
		
		//CreatedTimestamp and Updated TimeStamp
//		Student s= new Student(1,"Raja",111l,"Male","Y");
//		studentRespository.save(s);
//		System.out.println("Record Saved....");
		
		//soft Delete update in column "active_sw"
//		Student student=studentRespository.findById(1).get();
//		student.setActive_sw("N");
//        studentRespository.save(student);	
		
		//----------------------------------------------------------------------------------------
     	//Product Class
		productRepository productRepo= context.getBean(productRepository.class);
		Product p = new Product();
	//	p.setProductId(1);
		p.setProductName("MotherBoard");
	    p.setProductPrice(200.20);
		productRepo.save(p);
		
		System.out.println("Product Inserted....");
	}
}
