package in.ashokit;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Passport;
import in.ashokit.entity.Person;
import in.ashokit.repository.PassportRepository;

import in.ashokit.repository.PersonRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		PersonRepository personRepo = context.getBean(PersonRepository.class);

		PassportRepository passportRepo = context.getBean(PassportRepository.class);
		
		//save Person with Passport
//		Passport passport= new Passport();
//		passport.setPassportNum("asdfgh");
//		passport.setIssueDate(LocalDate.now());
//		passport.setExpiryDate(LocalDate.now().plusYears(10));
//		
//		
//		Person per= new Person();
//		per.setPersonName("Adil");
//		per.setPersonGender("Male");
//		per.setPassport(passport);
//		
//		passport.setPerson(per);
//		
//		personRepo.save(per);
//		
//		
//		System.out.println("save successfull");
		
		//get data
		
		//personRepo.findById(1);
		
		//delete data
		//personRepo.deleteById(1);
		

	}

}
