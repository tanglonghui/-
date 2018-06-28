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

import bean.role;
import bean.user;
import connect.Connect;
import dao.addRoleDao;
import dao.addUserDao;
import dao.h_timeDao;
import dao.loginDao;
import view.user_m_menu.MyWindowListener;

public class addRole {
	private String name;
	public void addRole(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("����һ����ɫ");
		 
		    
		    
			
			
			
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		//����һ���û���ɾ��һ���û����޸��û���Ϣ����ѯ�û���¼��������¸��������
			TextField tf1=new TextField();
			TextField tf2=new TextField();
			TextField tf3=new TextField();
			TextField tf4=new TextField();
			
			Label la1=new Label("���:");
			Label la2=new Label("�ǳ�:");
			Label la3=new Label("���:");
			Label la4=new Label("Ȩ��:");
			
			Button btn6=new Button("ȷ��");
			Button btn7=new Button("����");
			
			la1.setBounds(110, 30, 100, 30);
			la2.setBounds(110, 70, 100, 30);//��ʼ���꣬�Լ������
			la3.setBounds(110, 110, 100, 30);
			la4.setBounds(110, 150, 100, 30);
			
			tf1.setBounds(150, 30, 100, 30);
			tf2.setBounds(150, 70, 100, 30);//��ʼ���꣬�Լ������
			tf3.setBounds(150, 110, 100, 30);
			tf4.setBounds(150, 150, 100, 30);
			
			btn6.setBounds(100, 230, 100, 30);
			btn7.setBounds(200, 230, 100, 30);
			
			f.add(tf1);//����ť���ص�������
			f.add(tf2);
			f.add(tf3);
			f.add(tf4);
			
			f.add(btn6);
			f.add(btn7);
			f.add(la1);
			f.add(la2);
			f.add(la3);
			f.add(la4);
			
			
			
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					//����������Ϊ����
					String identity=tf1.getText();
					String rolename=tf2.getText();
					String dec=tf3.getText();
					String level=tf4.getText();
					role a=new role(identity,rolename,dec,level);
					System.out.println("ok"+a.getIdentity());
					addRoleDao ad=new addRoleDao();
					try {
						//b.addUserDao(a);
						role s=ad.addRoleDao(a);
						if(s!=null){
							JOptionPane.showMessageDialog(null,"���ӳɹ�");
						role_m_menu m=new role_m_menu();
						m.role_m_menu(rs);
						f.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null,"��ɫ�Ѿ����ڣ�");
							tf1.setText(null);//����ı���
							tf2.setText(null);
							tf3.setText(null);
							tf4.setText(null);
							
							
						}
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
					m.role_m_menu(rs);
					
					
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

