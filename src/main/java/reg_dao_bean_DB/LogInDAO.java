package reg_dao_bean_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LogInDAO {

	public static ArrayList<BeanClass> al = new ArrayList<BeanClass>();
	public BeanClass login(String name , String password) {
		BeanClass eb = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERREG WHERE NAME = ? AND PASSWORD = ?");
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				eb = new BeanClass();
				eb.setUsername(rs.getString(1));
				eb.setPassword(rs.getString(2));
				eb.setAddress(rs.getString(3));
				eb.setMailId(rs.getString(4));
				eb.setPhoneNo(rs.getString(5));
				eb.setState(rs.getString(6));
				eb.setCountry(rs.getString(7));
				
				al.add(eb);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return eb;
	}
	
}

