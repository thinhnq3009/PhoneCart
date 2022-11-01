package eco.phonecart.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eco.phonecart.app.dao.CategoryDao;
import eco.phonecart.app.dao.CompanyDao;
import eco.phonecart.app.dao.ProductDao;
import eco.phonecart.app.model.Category;
import eco.phonecart.app.model.Company;
import eco.phonecart.app.model.Product;

/**
 * Servlet implementation class Dasboard
 */
@WebServlet("/Admin/Home")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method 

		try {

			CompanyDao dao = new CompanyDao();
			List<Company> list = dao.getAll();
			request.setAttribute("listCompany", list);

			CategoryDao categoryDao =  new CategoryDao();
			List<Category> categories = categoryDao.getAll();
			request.setAttribute("listCategory", categories);
			
			ProductDao productDao = new ProductDao();
			List<Product> products = productDao.getAll();
			System.out.println(products.size());
			request.setAttribute("listProduct", products);
 			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// linkContent là biến chứa đường dẫn JPS phần content của trang admin
		request.setAttribute("linkContent", "/views/admin/pages/product-management.jsp");
		request.getRequestDispatcher("/views/admin/pages/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
