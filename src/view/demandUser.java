package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import bean.user;
import connect.Connect;
import dao.addUserDao;
import dao.deleteRoleDao;
import dao.deleteUserDao;
import dao.getUserDao;
import dao.h_timeDao;
import dao.loginDao;
import view.user_m_menu.MyWindowListener;

public class demandUser {
	private String name;
	private String username;
	private String l_time;
	public void demandUser(user rs) throws SQLException{
		username=null;
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("ѡ���ѯ���û�");
		 	JComboBox a;
			JPanel b=new JPanel();
			a =new JComboBox();
			//��ȡ����
		    Connection conn=Connect.getConnection();
		 	String sql1="select * from user where username is not null ";
		    PreparedStatement p=null;
		    ResultSet rs1=null;
		    p=conn.prepareStatement(sql1);
		    rs1=p.executeQuery();
		    while(rs1.next())
		    {
		    	a.addItem(""+rs1.getString("username"));
		    }
		   
			
			
			
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		//����һ���û���ɾ��һ���û����޸��û���Ϣ����ѯ�û���¼��������¸��������
			
			Label la1=new Label("��ѡ������Ҫ��ѯ���û�");

			Label la2=new Label("��ѡ��һ����¼");
			Button btn1=new Button("ѡ��");
			Button btn6=new Button("ȷ��");
			Button btn7=new Button("����");
			
			
			
			la1.setBounds(10, 50, 150, 30);//��ʼ���꣬�Լ������
			la2.setBounds(10, 150, 150, 30);
			a.setBounds(200, 50, 100, 30);
			
			btn1.setBounds(300, 50, 50, 30);
			
			btn6.setBounds(100, 230, 100, 30);
			btn7.setBounds(200, 230, 100, 30);
			f.add(btn7);
		
			f.add(btn1);
			
			
			f.add(la1);
			f.add(a);
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					 demandUser.this.username=(String) a.getSelectedItem();
					 JComboBox a2;
						JPanel b2=new JPanel();
						a2 =new JComboBox();
						//��ȡ����
						ResultSet rs1=null;
						 PreparedStatement p=null;
					 	String sql2="select * from info where username=?  ";
					   
					    try {
							p=conn.prepareStatement(sql2);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					   
					    
					    try {
							p.setString(1, username);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    try {
							rs1=p.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    try {
							while(rs1.next())
							{
								a2.addItem(""+rs1.getString("l_time"));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    
					//ǰ���û�����
					    a2.setBounds(200, 150, 180, 30);
					 l_time=(String) a2.getSelectedItem();
					f.add(la2);
					f.add(a2);
					f.add(btn6);
					
					
				}
			});
			
			
		
			
			
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					//����������Ϊ����
					
					String name=rs.getUsername();
					getUserDao s=new getUserDao();
					try {
						user gg=s.getuser(username);
						String c_time=gg.getC_time();
						showDemand sh=new showDemand();
						f.setVisible(false);
						sh.showDemand(username, name, c_time,l_time);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
					
				}
			});
			btn7.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//����������Ϊ����
					user_m_menu m=new user_m_menu();
					try {
						m.user_m_menu(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					};
					
					
				}
			});
			

}
	 class MyWindowListener extends WindowAdapter//��д
		{
			public void windowClosing(WindowEvent e){
				h_timeDao a=new h_timeDao();
			    try {
					a.h_time(name);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Window window=(Window) e.getComponent();
				window.dispose();
				System.exit(0);
			}
			}
	
	 }

