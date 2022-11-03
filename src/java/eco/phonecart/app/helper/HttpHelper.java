package eco.phonecart.app.helper;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpHelper {
	public static void setUTF8(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
	
	public static void go(HttpServletResponse response, String address) throws IOException{
		response.sendRedirect("/PhoneCartShop" + address);
	}
}
