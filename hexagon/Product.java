
public class Product {
String pro_name;
int pro_price;
int pro_count;
/**
 * 
 */
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @param pro_name
 * @param pro_price
 * @param pro_count
 */
public Product(String pro_name, int pro_price, int pro_count) {
	super();
	this.pro_name = pro_name;
	this.pro_price = pro_price;
	this.pro_count = pro_count;
}
public String getPro_name() {
	return pro_name;
}
public void setPro_name(String pro_name) {
	this.pro_name = pro_name;
}
public int getPro_price() {
	return pro_price;
}
public void setPro_price(int pro_price) {
	this.pro_price = pro_price;
}
public int getPro_count() {
	return pro_count;
}
public void setPro_count(int pro_count) {
	this.pro_count = pro_count;
}


}
