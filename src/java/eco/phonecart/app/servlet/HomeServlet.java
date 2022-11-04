package eco.phonecart.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eco.phonecart.app.dao.CategoryDao;
import eco.phonecart.app.dao.ProductDao;
import eco.phonecart.app.model.Category;
import eco.phonecart.app.model.Product;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			CategoryDao dao = new CategoryDao();
			
			List<Category> listCategories = dao.getAll();
			
			request.setAttribute("listCategories", listCategories);
			
			ProductDao productDao = new ProductDao();
			List<Product> listProducts = productDao.getAll();
			request.setAttribute("listProducts", listProducts);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		request.getRequestDispatcher("/views/user/pages/index.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
