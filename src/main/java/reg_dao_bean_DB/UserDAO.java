package reg_dao_bean_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO 
{
	int k = 0;
	Connection con = null;
	
	public int insert(BeanClass eb) throws Exception //name pwd ....
	{
		con = DBConnection.getCon(); //done
		PreparedStatement ps = 
		con.prepareStatement("INSERT INTO USERREG VALUES(?,?,?,?,?,?,?)");
		ps.setString(1, eb.getUsername());
		ps.setString(2, eb.getPassword());
		ps.setString(3, eb.getAddress());
		ps.setString(4, eb.getMailId());
		ps.setString(5, eb.getPhoneNo());
		ps.setString(6, eb.getState());
		ps.setString(7, eb.getCountry());
		
		k = ps.executeUpdate();
		
		return k;
	}
	
}

