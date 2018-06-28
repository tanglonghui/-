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
import dao.h_timeDao;
import dao.loginDao;
import view.user_m_menu.MyWindowListener;

public class deleteRole {
	private String name;
	public void deleteRole(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("ɾ��һ����ɫ");
		 	JComboBox a;
			JPanel b=new JPanel();
			a =new JComboBox();
			//��ȡ����
		    Connection conn=Connect.getConnection();
		 	String sql1="select * from role where identity is not null ";
		    PreparedStatement p=null;
		    ResultSet rs1=null;
		    p=conn.prepareStatement(sql1);
		    rs1=p.executeQuery();
		    while(rs1.next())
		    {
		    	a.addItem(""+rs1.getString("identity"));
		    }
		    
		    
			
			
			
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		//����һ���û���ɾ��һ���û����޸��û���Ϣ����ѯ�û���¼��������¸��������
			
			Label la1=new Label("��ѡ������Ҫɾ���Ľ�ɫ");
			
			Button btn6=new Button("ȷ��");
			Button btn7=new Button("����");
			
			
			
			la1.setBounds(100, 110, 200, 30);//��ʼ���꣬�Լ������
			a.setBounds(100, 150, 200, 30);
			
			
			btn6.setBounds(100, 230, 100, 30);
			btn7.setBounds(200, 230, 100, 30);
			
		
			
			f.add(btn6);
			f.add(btn7);
			f.add(la1);
			f.add(a);
			
		
			
			
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					//����������Ϊ����
					deleteRoleDao de=new deleteRoleDao();
					String it=(String) a.getSelectedItem();
					try {
						de.deleteRoleDao(it);
						JOptionPane.showMessageDialog(null,"��ѡ��Ľ�ɫ�Ѿ�ɾ��");
						f.setVisible(false);
						role_m_menu m=new role_m_menu();
						m.role_m_menu(rs);
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
					role_m_menu m=new role_m_menu();
					m.role_m_menu(rs);;
					
					
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

