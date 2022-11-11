package eco.phonecart.app.helper;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHelper {

	public static String ERROR = "errorMessage";
	public static String SUCCESS = "successMessage";
	public static String POPUP = "listPopupMessage";
	public static String USER = "userLogin";
	public static String ADMIN = "adminLogin";

	// Return value by name in session
	public static Object getValue(HttpServletRequest request, String name) {
		return request.getSession().getAttribute(name);
	}
	
	public static void removeValue(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		session.removeAttribute(name);
	
	}

	public static void setValue(HttpServletRequest request, Object value, String name) {
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

	/**
	 * POPUP MESSAGE This methods help add and get POPUP MESSAGE Message be saved in
	 * session <code>List<></code>
	 */

	/**
	 * Nếu đã có list thông báo trong session của request thì return nó ra, nếu chưa
	 * có thì tạo ra một list lưu vào session
	 * 
	 * @param request
	 * @return List PopupMessage save in session with name <code>listPopupMessage</code>
	 */
	@SuppressWarnings("unchecked")
	public static List<PopupMessage> initPopupMessage(HttpServletRequest request) {
		List<PopupMessage> list = null;
		try {
			list = (List<PopupMessage>) getValue(request, POPUP);
		} catch (Exception e) {
		}

		if (list == null) {
			list = new ArrayList<>();
		}
		
		setValue(request, list, POPUP);
		return list;
	}

	/**
	 * Trả về List PopupMessage lưu trong Session trong <code>request</code> truyền vào
	 * @param request
	 * @return List <code>PopupMessage</code>
	 */
	@SuppressWarnings("unchecked")
	public static List<PopupMessage> getPopupMessage(HttpServletRequest request) {
		return (List<PopupMessage>) getValue(request, POPUP);
	}
	
	public static void addPopup(HttpServletRequest request, PopupMessage message) {
		List<PopupMessage>  list = initPopupMessage(request);
		
		message.addList(list);
		
		setValue(request, list, POPUP);
	}
	
	public static void addPopup(HttpServletRequest request, String message, String type) {
		List<PopupMessage>  list = initPopupMessage(request);
		
		PopupMessage popupMessage = new PopupMessage(type, message);
		
		popupMessage.addList(list);
		
		setValue(request, list, POPUP);
	}
	
	
}
