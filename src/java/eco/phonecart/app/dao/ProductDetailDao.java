package eco.phonecart.app.dao;

import eco.phonecart.app.helper.DatabaseHelper;
import eco.phonecart.app.model.Property;
import eco.phonecart.app.model.Product;
import eco.phonecart.app.model.Product_Detail;

public class ProductDetailDao {
	
	public boolean add(Product product, Property detail, String content) throws Exception{
		Product_Detail pd = new Product_Detail();
		
		pd.setProduct(product);
		pd.setDetail(detail);
		pd.setPdContent(content);
				
		return DatabaseHelper.insert(pd);
		
	}
	
	public boolean insert(Product_Detail productDetail) throws Exception{
		return DatabaseHelper.insert(productDetail);
	}
	
	
}
