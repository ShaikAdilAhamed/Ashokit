package in.ashokit.reports;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("pdf")
//@Primary
public class PdfReport implements IReport{

	public void generateReport() {
		System.out.println("PDF report generate");
	}

}
