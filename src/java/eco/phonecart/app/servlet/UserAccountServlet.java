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

import org.apache.commons.beanutils.BeanUtils;

import eco.phonecart.app.dao.ForgotPasswordDao;
import eco.phonecart.app.dao.UsersDao;
import eco.phonecart.app.email.Email;
import eco.phonecart.app.email.MailSender;
import eco.phonecart.app.helper.HttpHelper;
import eco.phonecart.app.helper.PasswordHelper;
import eco.phonecart.app.helper.SessionHelper;
import eco.phonecart.app.model.Users;

/**
 * Servlet implementation class SigninServlet 
 */
@WebServlet({ "/Account/SignIn", "/Account/SignUp", "/Account/reset-password", "/Account/change", "/Account/Logout"})
public class UserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getServletPath()) {
		case "/Account/SignIn":
			if (autoSignIn(request, response))
				return;

			request.getRequestDispatcher("/views/user/pages/signin.jsp").forward(request, response);
			break;

		case "/Account/SignUp":
			request.getRequestDispatcher("/views/user/pages/signup.jsp").forward(request, response);
			break;

		case "/Account/reset-password":
			request.getRequestDispatcher("/views/user/pages/reset-password.jsp").forward(request, response);
			break;
		case "/Account/change":
			response.sendRedirect(request.getContextPath() + "/Account/SignIn");
			break;
		case "/Account/Logout":
			doPost(request, response);
			break;
		default:
			request.getRequestDispatcher("/views/user/pages/404error.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		switch (request.getServletPath()) {
		case "/Account/SignIn":
			doSignIn(request, response);
			break;

		case "/Account/SignUp":
			doSignUp(request, response);
			break;
		case "/Account/reset-password":
			doResetPassword(request, response);
			break;
		case "/Account/change":
			changePass(request, response);
			break;
		case "/Account/Logout": 
			doLogout(request, response);
			break;
		default:
			request.getRequestDispatcher("/views/user/pages/404error.jsp").forward(request, response);
		}

	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) {
		SessionHelper.removeValue(request, SessionHelper.USER);
		try {
			HttpHelper.go(response, "/Account/SignIn");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void changePass(HttpServletRequest request, HttpServletResponse response) {
		String resetCode = request.getParameter("code");
		String newPass = request.getParameter("new-pass");
		String confirmPass = request.getParameter("confirm-pass");
		String username = request.getParameter("username");
		
		try {
			ForgotPasswordDao dao = new ForgotPasswordDao();
			
			HttpSession session = request.getSession();
			
			int isActive = dao.verify(username, resetCode);
			
			if (isActive == 1) {
				if (newPass.equals(confirmPass)) {
					
					try {
						UsersDao usersDao = new UsersDao();
						
						Users user = usersDao.get(username);
						
						user.setPassword(PasswordHelper.hash(newPass));
						
						usersDao.update(user);
						
						session.setAttribute(SessionHelper.SUCCESS, "Change password successfully");
						
						response.sendRedirect(request.getContextPath() + "/Account/SignIn");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
				} else {
					session.setAttribute(SessionHelper.ERROR, "New password and confirm password is not equals");
				}
				
				
			} else if (isActive == 0) {
				session.setAttribute(SessionHelper.ERROR, "Code has expired");
			} else {
				session.setAttribute(SessionHelper.ERROR, "Code is incorrect");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void doResetPassword(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		
		try {
			UsersDao dao = new UsersDao();
			
			Users user = dao.get(username);
			
			if (user == null) {
				request.getSession().setAttribute("errorMessage", "We couldn't find account with this username.");
				response.sendRedirect(request.getContextPath() + "/Account/reset-password");
			} else {
				
				Email.sendResetCode(user);
				
				request.setAttribute("email", user.getHideEmail());
				request.setAttribute("username", username);
				request.getRequestDispatcher("/views/user/pages/new-password.jsp").forward(request, response);
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}



	private void doSignIn(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			UsersDao dao = new UsersDao();

			Users user = dao.get(username);

			if (user == null) {

				session.setAttribute("errorMessage", "Don't find account with this username.");

				response.sendRedirect(request.getContextPath() + "/Account/SignIn");

				System.out.println("Don't find account with this username.");

				return;

			} else {

				// Login success
				if (PasswordHelper.verifyPassword(password, user.getPassword())) {

					session.setAttribute("userLogin", user);

					// Do remember me
					doRemember(request, response, user);

					response.sendRedirect(request.getContextPath() + "/Home");

				} else {
					session.setAttribute("errorMessage", "Password is incorect");

					response.sendRedirect(request.getContextPath() + "/Account/SignIn");

					System.out.println("Password is incorect");

					return;
				}
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

			if (cookie.getName().equals("remember")) {

				System.out.println(cookie.getValue());

				String rememberCode = cookie.getValue();

				UsersDao dao = new UsersDao();
				try {

					Users user = dao.getByRememberCode(rememberCode);

					session.setAttribute("userLogin", user);

					response.sendRedirect(request.getContextPath() + "/Home");

					return true;

				} catch (Exception e) {

					e.printStackTrace();

					break;
				}
			}
		}

		return false;
	}

	private void doRemember(HttpServletRequest request, HttpServletResponse response, Users user) {
		String remember = request.getParameter("remember");

		if (remember == null)
			return;

		if (!remember.equals("remember"))
			return;

		String hashString = PasswordHelper.hash(user.getUsername() + LocalDateTime.now().toString());

		user.setRemember(hashString);

		Cookie cookie = new Cookie("remember", hashString);

		cookie.setMaxAge(24 * 60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);

		try {
			UsersDao dao = new UsersDao();

			dao.update(user);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void doSignUp(HttpServletRequest request, HttpServletResponse response) {
		try {
			Users user = new Users();

			BeanUtils.populate(user, request.getParameterMap());

			String hashString = PasswordHelper.hash(user.getPassword());
			user.setPassword(hashString);

			UsersDao dao = new UsersDao();

			user.setAddress(null);

			if (dao.insert(user)) {
				
				request.getSession().setAttribute("successMessage", "Sign Up Success");

				response.sendRedirect(request.getContextPath() + "/Account/SignIn");
			} else {
				request.getRequestDispatcher("/views/user/pages/signup.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
