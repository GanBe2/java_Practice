import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDAO {
	public void insertProduct(Product p) throws Exception{
		Connection conn=null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		String query="insert into product_tb values(seq_product_tb.nextval,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setString(1, p.getPro_name());
		pstmt.setInt(2, p.getPro_price());
		pstmt.setInt(3, p.getPro_count());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	
}
}
