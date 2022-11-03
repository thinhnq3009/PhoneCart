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
import eco.phonecart.app.helper.HttpHelper;
import eco.phonecart.app.helper.SessionHelper;
import eco.phonecart.app.image.Images;
import eco.phonecart.app.model.Admin;
import eco.phonecart.app.model.Product;
import jakarta.validation.Path;

/**
 * Servlet implementation class ProductServlet
 */
@MultipartConfig
@WebServlet({ "/Product/Add", "/Product/Update", "/Product/Delete" })
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
		response.sendRedirect(request.getContextPath() + "/Admin/Home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpHelper.setUTF8(request, response);

		try {
			switch (request.getServletPath()) {
			case "/Product/Add": {
				addProduct(request, response);
				break;
			}
			case "/Product/Update": {
				updateProduct(request, response);
				break;
			}
			case "/Product/Delete": {
				deleteProduct(request, response);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + request.getContextPath());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHelper.go(response, "/Admin/Home");

	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idPro = Integer.valueOf(request.getParameter("id"));
			
			ProductDao dao = new ProductDao();
			
			Product product = dao.findById(idPro);
			
			dao.delete(product);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void readRequest(Product product, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		product.setProName(request.getParameter("proName"));
		
		Long price = Long.valueOf(request.getParameter("proPrice"));
		product.setProPrice(price);
		
		int idCategory = Integer.valueOf(request.getParameter("category"));
		product.setCategory(new CategoryDao().findByID(idCategory));
		
		int idCompany = Integer.valueOf(request.getParameter("company"));
		product.setCompany(new CompanyDao().findByID(idCompany));
		
		int proQuantity = Integer.valueOf(request.getParameter("proQuantity"));
		product.setProQuantity(proQuantity);
		
		product.setProDescrible(request.getParameter("proDescrible"));
		
		Images img = new Images(request, "proImage", "ProductImage");
		product.setProImage(img.getSrc());
			
		product.setProTimeCreate(new Timestamp(System.currentTimeMillis()));
		
		product.setAdmin((Admin) session.getAttribute("adminLogin"));
	}
	
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProductDao dao = new ProductDao();
			
			Product product = dao.findById(Integer.valueOf(request.getParameter("idProduct")));
			
			readRequest(product, request);
			
//			response.getWriter().print(product.toJSON());
			
			if (dao.update(product)) {
				SessionHelper.setSuccess(request, "Update successully");
			} else {
				SessionHelper.setError(request, "Update faild");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) {
		Product product = new Product();

		HttpSession session = request.getSession();
		
		try {

			readRequest(product, request);
			
			product.setProSold(0);
			
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
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
