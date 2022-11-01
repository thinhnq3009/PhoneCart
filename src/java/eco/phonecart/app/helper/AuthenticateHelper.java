package eco.phonecart.app.helper;

import javax.servlet.http.HttpServletRequest;

import eco.phonecart.app.model.Admin;
import eco.phonecart.app.model.Users;

public class AuthenticateHelper {
	
	
	
	public static boolean validate(HttpServletRequest request, String role) {
		Object o = request.getSession().getAttribute("userLogin");
		if (o instanceof Users && role.equals("USER")) {
			return true;
		} else if (o instanceof Admin && role.equals("ADMIN")) {
			return true;
		}
		
		return false;
	}
}
