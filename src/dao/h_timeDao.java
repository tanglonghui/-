package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import connect.Connect;

public class h_timeDao {
	public String h_time(String username) throws SQLException{
		Connection conn=Connect.getConnection();
		//String sql="insert into info(username,y_time,l_time,now,ip)values(?,?,?,?,?)";
			String sql="UPDATE info SET h_time =? , now=? WHERE username =? and y_time=? and now=?";
			Calendar ca = Calendar.getInstance();
			Date time=ca.getTime();//���ϵͳʱ��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    String y_time = sdf.format(time);//���������
		    Date today=new Date();
		    SimpleDateFormat f=new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss");
		    String h_time=f.format(today);
	    PreparedStatement p=null;
	    ResultSet rs=null;
	    p=conn.prepareStatement(sql);
	    
	    String now="����";
	    String now1="����";
	    
	    p.setString(1,h_time);
	    p.setString(2,now);
	    p.setString(3,username);
	    p.setString(4,y_time);
	    p.setString(5,now1);
	    p.executeUpdate();
	    
		return null;
    	
}
}
