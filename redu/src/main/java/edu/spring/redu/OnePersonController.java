package edu.spring.redu;

import java.io.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import rtest.*;

@Controller
public class OnePersonController {
	@Autowired
	OnePersonService service;
	
	@RequestMapping("/map7")
	public ModelAndView map7(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String real_path = req.getSession().getServletContext().getRealPath("/");
	    real_path = real_path.replace("\\", "/");
	    System.out.println(real_path);		
		File f = new File(real_path+"/resources/map7");
		if(!f.exists()) f.mkdir();
		String name=req.getParameter("name");
		String result = service.returnmap7(real_path+"/resources/map7", name);
		mav.addObject("leafletChartName", "http://localhost:8000/redu/resources/map7/"+result);
		mav.setViewName("oneView");
		return mav;
	}	
	
}






