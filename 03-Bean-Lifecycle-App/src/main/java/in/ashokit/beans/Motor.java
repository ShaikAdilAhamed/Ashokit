package in.ashokit.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Motor implements InitializingBean,DisposableBean{

	public Motor() {
	System.out.println("Motor :: constructor");
	}

//	public void start() {
//		System.out.println("Motor :: Started");
//	}
//	
	
	public void doWork() {
		System.out.println("Motor pulling water");
	}
//this will load after implement interface DisposableBean
@Override
public void destroy() throws Exception {
	System.out.println("Motor :: Stoped");
	
}

//this will load after implement interface InitializingBean
@Override
public void afterPropertiesSet() throws Exception {
	
	System.out.println("Motor :: Started");
}
	
//	public void stop() {
//		System.out.println("Motor :: Stopped");
//	}
}
