package in.ashokit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Address;
import in.ashokit.entity.Employee;
import in.ashokit.repository.AddressRepository;
import in.ashokit.repository.EmpRepository;
import jakarta.persistence.FetchType;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmpRepository Emprepo = context.getBean(EmpRepository.class);

		AddressRepository addRepo= context.getBean(AddressRepository.class);
		
		//Save employee with multiple address
		Employee employee = new Employee();
		employee.setEmpName("Raja");
		employee.setEmpSalary(4000.00);

		Address a1 = new Address();
		a1.setCity("Hyd");
		a1.setState("TG");
		a1.setCountry("India");
		a1.setEmp(employee);

		Address a2 = new Address();
		a2.setCity("GNT");
		a2.setState("AP");
		a2.setCountry("India");
		a2.setEmp(employee);

		//setting address to employee
		List<Address> addrList = Arrays.asList(a1, a2);

		employee.setAddr(addrList);
		Emprepo.save(employee);
		System.out.println("save successfully");
		
		
		//Delete a record with all related address
		//Emprepo.deleteById(2);
		//System.out.println("Employee deleted successfull with related address");
		
       
		
		//get Employee data
		//get Employee data with related address then we add fetch = FetchType.EAGER in employee table
		Emprepo.findById(2);
		
		
		
		//------------------------------------------------------------------
	     //	getting data from "address" class
		
		//if iam getting data from address then 
		//it will retrieve all data including employee data as emplyee id is there in address table
		//addRepo.findById(3);
		
		
	}

}
