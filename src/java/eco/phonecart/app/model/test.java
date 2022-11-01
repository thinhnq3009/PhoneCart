package eco.phonecart.app.model;

import eco.phonecart.app.dao.ProductDao;

public class test {
	public static void main(String[] args) {
		try {
			for (Product p : new ProductDao().getAll()) {
				System.out.println(p.toJSON());
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
