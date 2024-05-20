package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import util.DbUtil;

public class ProductDao {
	
	private Connection connection;

	public ProductDao() {
		connection = DbUtil.getConnection();
	}
	
	
	
	public List<Product> getAllProducts() {
	
		List<Product> productList = new ArrayList<Product>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from product");
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDate(rs.getString("date"));
				
				
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

}
