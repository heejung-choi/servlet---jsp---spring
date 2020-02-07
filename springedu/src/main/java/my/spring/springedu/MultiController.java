package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MultiController {	
	@RequestMapping(value="/select")
	public String select() {
		System.out.println("select ............");
		return  "viewTest";
	}
	@RequestMapping(value="/search")
	public String search() {
		System.out.println("search ............");
		return "viewTest";
	}
	@RequestMapping(value="/insert")
	public String insert(int pageno) {
		System.out.println("insert ............"+pageno);
		return  "viewTest";
	}
}
/* select와 search는 매개변수가 없다-> 전달받아서 쓰고자 하는 것이 없다. */
/* 스프링에서 쿼리문자열 추출은 자동으로 해준다. int형으로 하면 형변환 까지해서 하기 때문에 null/int 형이 아닌 다른
 * 값은 넣어줄 수 없다.
 * select와 search는 쿼리문자열 받지 않았는데 jsp에서 직접 추출할 수 있다.
 * */

