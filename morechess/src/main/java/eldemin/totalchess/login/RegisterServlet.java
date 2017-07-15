package eldemin.totalchess.login;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterServlet {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(method = RequestMethod.POST)
	public void printHello(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletResponse response
	) throws IOException {
		int updatedRows = jdbcTemplate.update("INSERT INTO user (username, password) VALUES (?, ?)", username,  passwordEncoder.encode(password));
		if (updatedRows == 1) {
			jdbcTemplate.update("INSERT INTO user_role (username, role) VALUES (?, ?)", username, "USER");
			response.getWriter().append("register successful");
		} else {
			response.getWriter().append("register failed");
		}
	}
	
}
