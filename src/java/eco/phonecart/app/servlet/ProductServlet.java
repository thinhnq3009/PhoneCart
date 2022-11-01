package eco.phonecart.app.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import eco.phonecart.app.dao.CategoryDao;
import eco.phonecart.app.dao.CompanyDao;
import eco.phonecart.app.dao.ProductDao;
import eco.phonecart.app.helper.ToString;
import eco.phonecart.app.image.Images;
import eco.phonecart.app.model.Admin;
import eco.phonecart.app.model.Product;
import jakarta.validation.Path;

/**
 * Servlet implementation class ProductServlet
 */
@MultipartConfig
@WebServlet({ "/Product/Add", "/Product/Edit", "/Product/Delete" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		try {
			switch (request.getServletPath()) {
			case "/Product/Add": {
				addProduct(request, response);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + request.getContextPath());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) {
		Product product = new Product();

		HttpSession session = request.getSession();
		
		try {

			product.setProName(request.getParameter("proName"));
			
			Long price = Long.valueOf(request.getParameter("proPrice"));
			product.setProPrice(price);
			
			int idCategory = Integer.valueOf(request.getParameter("category"));
			product.setCategory(new CategoryDao().findByID(idCategory));
			
			int idCompany = Integer.valueOf(request.getParameter("company"));
			product.setCompany(new CompanyDao().findByID(idCompany));
			
			int proQuantity = Integer.valueOf(request.getParameter("proQuatity"));
			product.setProQuatity(proQuantity);
			
			product.setProDescrible(request.getParameter("proDescrible"));
			
			Images img = new Images(request, "proImage", "ProductImage");
			product.setProImage(img.getSrc());
			
			product.setProSold(0);
			
			product.setProTimeCreate(new Timestamp(System.currentTimeMillis()));
			
			product.setAdmin((Admin) session.getAttribute("adminLogin"));
			
			
			//Insert to Database
			try {
				ProductDao dao = new ProductDao();
				
				if (dao.insert(product)) {
					session.setAttribute("successMessage", "Created product successfully");
				} else {
					session.setAttribute("errorMessage", "Created product faild");
				}
										
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			response.getWriter().print(product);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
