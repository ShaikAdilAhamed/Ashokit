package in.ashokit;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Engine {

	public Engine() {
		System.out.println("Engine:: constructor");
	}

	@PostConstruct
	public void m1() {
		System.out.println("This is init() method");
	}

	@PreDestroy
	public void m2() {
		System.out.println("this is destroy() method");
	}
}
