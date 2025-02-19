package in.ashokit.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class RequestLogInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle() method is called");
		Long startTime= System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		String clientId=request.getParameter("clientId");
		if("ashokIt".equals(clientId))
		{
			return true;
		}
		response.getWriter().print("Invalid Request");
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle() method is called");
		Long endTime= System.currentTimeMillis();
		request.setAttribute("endTime", endTime);
		
		long startTime=(long) request.getAttribute("startTime");
		
		long time=endTime - startTime;
		
		System.out.println("Total Time Taken (Ms) : "+time); 
		
		
		
		
		
	}

}
