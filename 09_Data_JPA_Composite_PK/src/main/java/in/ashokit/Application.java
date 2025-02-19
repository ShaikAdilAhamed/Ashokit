package in.ashokit;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Account;
import in.ashokit.entity.AccountPK;
import in.ashokit.repository.AccountRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
		
		AccountRepository accountRepo= context.getBean(AccountRepository.class);
		
		//Composite priamry key
//		AccountPK pk= new AccountPK();
//		pk.setAccId(2);
//		pk.setAccType("Current");
//		pk.setAccNum(321456789l);
//		
//		
//		Account account= new Account();
//		account.setHolderName("Adil");
//		account.setBranch("Madiwala");
//		account.setAccountPK(pk);
//		
//		accountRepo.save(account);
//		System.out.println("Save successfully");
		
		//getById   get data
		
		AccountPK pk= new AccountPK();
		pk.setAccId(1);
		pk.setAccNum(123456789l);
		pk.setAccType("Saving");
		
		
		Optional<Account> findbyId=accountRepo.findById(pk);
		System.out.println(findbyId);
		
		
		
	}

}
