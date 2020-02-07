package my.spring.springedu;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
@Controller //controller가 되려면 반드시 이렇게 해줘야 한다.
public class HelloController {	
	public HelloController() {
		System.out.println("HelloController Create object");
	}
	@RequestMapping("/hello") // hello로 끝나는 url이면 해당 메서드를 호출해줘 라는 의미
	//이렇게 맵핑명이 있는 것을 컨드롤러 메서드 또는 핸들러메서드라고 한다.
	public ModelAndView xxx(){		
		ModelAndView mav = new ModelAndView();
		//viwe객체와 model객체를 하나로 담는다 model은 vo를 의미한다.
		//jsp에는 그냥 넘기는것이 아니라 모델을 넘겨야 한다.
		mav.setViewName("helloView");
		//응답은 jsp가 한다라고 나와있지 않지만 응답할 파일만 지정해도 자동으로 helloView로 전환된다.
		mav.addObject("msg", getMessage());
		/* addObject은 setattribute와 같다. */
		return mav;
	}
	private String getMessage(){
		int hour = Calendar.getInstance()
				.get(Calendar.HOUR_OF_DAY);		
		if(hour >= 6 && hour <= 10){
			return "Good Morning!!";
		}else if(hour >= 12 && hour <= 15){
			return "Good Afternoon";
		}else if(hour >= 18 && hour <= 22){
			return "Good Evening!!";
		}else{ 
			return "Hello!!";
		}
	}
}




