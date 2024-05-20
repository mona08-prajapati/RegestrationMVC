package bean;

public class Product {
	
	private int id;
	private String name;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	
	
	

}
