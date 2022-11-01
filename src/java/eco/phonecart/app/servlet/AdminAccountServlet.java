package eco.phonecart.app.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eco.phonecart.app.dao.AdminDao;

import eco.phonecart.app.helper.PasswordHelper;
import eco.phonecart.app.model.Admin;

/**
 * Servlet implementation class AdminAccount
 */
@WebServlet({ "/Admin/SignIn", "/Admin/Logout" })
public class AdminAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String FORGOT = "XXXXXXXXXXXXXXXXXXXXXXXXXX";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponseeqweqeqe response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String servletPart = request.getServletPath();

		switch (servletPart) {
		case "/Admin/SignIn": {

			if (autoSignIn(request, response))
				return;

			request.getRequestDispatcher("/views/admin/pages/signin.jsp").forward(request, response);

			break;
		}
		case "/Admin/Logout": {

			doLogout(request, response);

			break;
		}

		default:
			return;
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("remember_admin")) {

				Cookie oldCookie = new Cookie(cookie.getName(), FORGOT);

//				System.out.println("12121");
				oldCookie.setMaxAge(0);
				oldCookie.setValue(FORGOT);
				response.addCookie(oldCookie);
			}
		}

		request.getSession().removeAttribute("adminLogin");

		try {
			response.sendRedirect(request.getContextPath() + "/Admin/SignIn");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(Http response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String servletPart = request.getServletPath();

		switch (servletPart) {
		case "/Admin/SignIn": {

			doSignIn(request, response);
			break;

		}
		default:
			return;
		}

	}

	private void doSignIn(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {

			AdminDao dao = new AdminDao();

			Admin admin = dao.get(username);

			if (admin != null) {

				if (PasswordHelper.verifyPassword(password, admin.getPassword())) {
					session.setAttribute("adminLogin", admin);

					doRemember(request, response, admin);

					response.sendRedirect(request.getContextPath() + "/Admin/Home");

				} else {
					session.setAttribute("errorMessage", "Password is incorect");
					request.getRequestDispatcher("/views/admin/pages/signin.jsp").forward(request, response);
				}

			} else {
				session.setAttribute("errorMessage", "Can't find account with this username");
				request.getRequestDispatcher("/views/admin/pages/signin.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void doRemember(HttpServletRequest request, HttpServletResponse response, Admin admin) {

		String remember = request.getParameter("remember");

		if (remember == null)
			return;

		if (!remember.equals("remember"))
			return;

		String hashString = PasswordHelper.hash(admin.getUsername() + LocalDateTime.now().toString());

		Cookie cookie = new Cookie("remember_admin", hashString);

		cookie.setMaxAge(2 * 60);
		cookie.setPath("/");

		response.addCookie(cookie);

		// Update remember code in DB
		try {

			AdminDao dao = new AdminDao();

			admin.setRemember(hashString);

			if (dao.update(admin)) {
				System.out.println("Update thanh coong");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean autoSignIn(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Cookie[] list = request.getCookies();

		if (list == null)
			return false;

		for (Cookie cookie : list) {

			if (cookie.getName().equals("remember_admin")) {

				System.out.println(cookie.getValue());

				String rememberCode = cookie.getValue();

				if (rememberCode.equals(FORGOT))
					return false;

				AdminDao dao = new AdminDao();

				try {

					Admin admin = dao.getByRememberCode(rememberCode);

					session.setAttribute("adminLogin", admin);

					response.sendRedirect(request.getContextPath() + "/Admin/Home");

					return true;

				} catch (Exception e) {

					break;
				}
			}
		}

		return false;

	}

}
