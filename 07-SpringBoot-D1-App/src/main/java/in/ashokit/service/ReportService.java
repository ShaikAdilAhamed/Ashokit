package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.ashokit.dao.ReportDao;

@Service
public class ReportService {
	
	@Value("${custom.value}")
	private String value;
	
	
	//@Autowired  //(field injection) (Not recommended because it use Reflection Api) (Internally violating OOPS principles)
	              //Not recommended because Will get "Null Pointer Exception" if we don't use @Autowired  Exception) 
	private ReportDao reportDao;


	@Autowired //(Constructor injection) ****(Recommended way)****
	           //(Recommended because there is a NO chance of getting "Null Pointer Exception"
                //if we dont use @Autowired  Exception) 
	public ReportService(ReportDao reportDao) {
		System.out.println("ReportService parametirize  :: Constructor called");
		this.reportDao = reportDao;
	}
	
//this will work like this	 (setter Injection)  (Not recommended because there is a chance of getting null pointer exception
	                            //if we dont use @Autowired  Exception)                         
//	@Autowired
//	public void setReport(ReportDao reportDao) {
//		System.out.println("setReportDao() Method called... ");
//		this.reportDao = reportDao;
//	}

	
	
	
	public void printName(Integer userId) {
		String nameById = reportDao.getNameById(userId);
		System.out.println(nameById);
		System.out.println("custom value data :: "+value);
	}
}
