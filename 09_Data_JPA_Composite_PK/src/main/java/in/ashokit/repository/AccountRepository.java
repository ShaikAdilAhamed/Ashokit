package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Account;
import in.ashokit.entity.AccountPK;

//JpaRepository<Account, AccountPK> "Account" is class,
//"AccountPK" we define because we are using class here for CompositePK 
public interface AccountRepository extends JpaRepository<Account, AccountPK> {
	
	

}
