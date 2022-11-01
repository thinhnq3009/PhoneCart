package eco.phonecart.app.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;

import eco.phonecart.app.dao.ForgotPasswordDao;
import eco.phonecart.app.dao.ProductDao;
import eco.phonecart.app.interfaces.CheckerInterface;
import eco.phonecart.app.model.Product;
import eco.phonecart.app.utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet help check is existence of data in the database Parameter: tab:
 * Table name in database col: Name column in this table data: Data to
 */
@WebServlet({ "/helper/checker", "/check-reset-code", "/data/product" })
public class CheckExistServletHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean isEmpty(String... str) {

		for (String item : str) {
			if (item == null || item == "")
				return true;
		}

		return false;

	}

	@SuppressWarnings("unchecked")
	private void checkData(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String table = request.getParameter("tab");
		String column = request.getParameter("col");
		String data = request.getParameter("data");

		String logMessage = "[" + request.getRemoteAddr() + "] : Send request "
				+ Arrays.toString(new String[] { table, column, data });

		System.out.println(logMessage);

		JSONObject output = new JSONObject();

		//

		if (isEmpty(table, column, data)) {
			output.put("status_code", Integer.valueOf(1004));
			output.put("status", "error");
			output.put("message", "Don't enought data to check");
			output.put("value", null);

		} else {
			try {
				// IllegalArgumentException lỗi không có Bảng
				// PersistenceException lỗi không có cột
				String sql = "SELECT u FROM " + table + " u WHERE " + column + " = :data";

				EntityManager entityManager = JpaUtils.getEntityManager();

				TypedQuery<CheckerInterface> query = entityManager.createQuery(sql, CheckerInterface.class);

				query.setParameter("data", data);

				List<CheckerInterface> list = query.getResultList();

				if (list.isEmpty()) {
					output.put("status_code", Integer.valueOf(200));
					output.put("status", "success");
					String message = "Don't exist '" + data + "\' in table [" + table + "] at column [" + column + "]";
					output.put("message", message);
					output.put("value", Boolean.valueOf(false));

				} else {
					output.put("status_code", Integer.valueOf(200));
					output.put("status", "success");
					String message = "Alread exist '" + data + "\' in [" + table + "] at column [" + column + "]";
					output.put("message", message);
					output.put("value", Boolean.valueOf(true));
				}

			} catch (IllegalArgumentException e) {

				output.put("status_code", Integer.valueOf(401));
				output.put("status", "error");
				String message = "Error table name.";
				output.put("message", message);
				output.put("value", null);
			} catch (PersistenceException e) {

				output.put("status_code", Integer.valueOf(402));
				output.put("status", "error");
				String message = "Error column name.";
				output.put("message", message);
				output.put("value", null);
			} catch (Exception e) {
				output.put("status_code", Integer.valueOf(403));
				output.put("status", "error");
				String message = "An unknown error";
				output.put("message", message);
				output.put("value", null);
			}

		}

		response.getWriter().print(output);

	}

	@SuppressWarnings("unchecked")
	private void checkResetCode(HttpServletRequest request, HttpServletResponse response) {

		try {
			JSONObject output = new JSONObject();

			String username = request.getParameter("username");
			String resetCode = request.getParameter("resetCode");

			if (isEmpty(username, resetCode)) {
				output.put("status_code", Integer.valueOf(1004));
				output.put("status", "error");
				output.put("message", "Don't enought data to check");
				output.put("value", null);

			} else {

				try {

					ForgotPasswordDao dao = new ForgotPasswordDao();
					int value = dao.verify(username, resetCode);

					String message = "Reset code is " + (value == 1 ? "conrect (" : "inconrect (") + username + ")";

					output.put("status_code", Integer.valueOf(200));
					output.put("status", "success");
					output.put("message", message);
					output.put("value", value == 1);

				} catch (NoResultException e) {
					output.put("status_code", Integer.valueOf(200));
					output.put("status", "error");
					output.put("message", "Reset code is incorect or username is incorrect");
					output.put("value", false);
				} catch (Exception e) {
					e.printStackTrace();
					output.put("status_code", Integer.valueOf(1004));
					output.put("status", "error");
					output.put("message", "Error Query Satament");
					output.put("value", null);
				}
			}
			response.getWriter().print(output);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			switch (request.getServletPath()) {
			case "/helper/checker": {

				checkData(request, response);

				break;
			}

			case "/check-reset-code": {
				checkResetCode(request, response);
				break;
			}

			case "/data/product": {
				getProduct(request, response);
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + request.getServletPath());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void getProduct(HttpServletRequest request, HttpServletResponse response) {
		int idProduct = Integer.valueOf(request.getParameter("id"));
		
		try {
			ProductDao dao = new ProductDao();
			
			Product product = dao.findById(idProduct);
			
//			System.out.println(product.toJSON());
			
			response.getWriter().print(product.toJSON());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
