package eco.phonecart.app.helper;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHelper {

	public static String ERROR = "errorMessage";
	public static String SUCCESS = "successMessage";

	public static Object getValue(HttpServletRequest request, String name) {
		return request.getSession().getAttribute(name);
	}

	public static void setMessage(HttpServletRequest request, Object value, String name) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}

	public static void setError(HttpServletRequest request, Object value) {
		String errorMessage = String.valueOf(getValue(request, ERROR));

		if (errorMessage.isBlank() || errorMessage == null) {
			request.getSession().setAttribute(ERROR, errorMessage);
		}
	}
	
	public static void setSuccess(HttpServletRequest request, Object value) {
		String errorMessage = String.valueOf(getValue(request, ERROR));

		if (errorMessage.isBlank() || errorMessage == null) {
			request.getSession().setAttribute(SUCCESS, errorMessage);
		}
	}
	
	public static void deleteError(HttpServletRequest request) {
		request.getSession().removeAttribute(ERROR);
	}
	
	public static void deleteSuccess(HttpServletRequest request) {
		request.getSession().removeAttribute(SUCCESS);
	}
}
