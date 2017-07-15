package eldemin.stub;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class SimpleServlet {

	@RequestMapping(method = RequestMethod.GET)
	public void printHello(HttpSession session, HttpServletResponse response) throws IOException {
		response.getWriter().write("Hello " + session.getId());
	}
	
	/*public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}*/
}
