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
import dao.deleteUserDao;
import dao.h_timeDao;
import dao.loginDao;
import view.user_m_menu.MyWindowListener;

public class changeMyUser {
	private String name;
	public void changeMyUser(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("�����Լ����");
		 	f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		//����һ���û���ɾ��һ���û����޸��û���Ϣ����ѯ�û���¼��������¸��������
			
			TextField tf4=new TextField();
			TextField tf5=new TextField();
			Label la1=new Label();
			la1.setText("�����˺�:"+rs.getUsername());
			Label la2=new Label();
			la2.setText("��������:"+rs.getPassword());
			Label la3=new Label();
			la3.setText("�������:"+rs.getIdentity());
			Label la4=new Label("���ǳ�:");
			Label la5=new Label("�¼��:");
			Button btn6=new Button("ȷ��");
			Button btn7=new Button("����");
			
			la1.setBounds(100, 30, 100, 30);
			la2.setBounds(100, 70, 100, 30);//��ʼ���꣬�Լ������
			la3.setBounds(100, 110, 100, 30);
			la4.setBounds(100, 150, 100, 30);
			la5.setBounds(100, 190, 100, 30);
			
			tf4.setBounds(150, 150, 100, 30);
			tf5.setBounds(150, 190, 100, 30);
			btn6.setBounds(100, 230, 100, 30);
			btn7.setBounds(200, 230, 100, 30);
			
			
			f.add(tf4);
			f.add(tf5);
			f.add(btn6);
			f.add(btn7);
			f.add(la1);
			f.add(la2);
			f.add(la3);
			f.add(la4);
			f.add(la5);
			
			
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					//����������Ϊ����
					String username=rs.getUsername();
					String password=rs.getPassword();
					String identity=rs.getIdentity();
					String nickname=tf4.getText();
					String description=tf5.getText();
					String c_time=rs.getC_time();
					user a=new user(username,password,nickname,identity,description,c_time);
					deleteUserDao delete=new deleteUserDao();
					try {
						delete.deleteUserDao(username);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					addUserDao b=new addUserDao();
					
					try {
						
						user s=b.addUserDao(a);
						if(s!=null){
						JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
						user_m_menu m=new user_m_menu();
						m.user_m_menu(rs);
						f.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�");
							//����ı���
						
							tf4.setText(null);
							tf5.setText(null);
							
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
					user_m_menu m=new user_m_menu();
					try {
						m.user_m_menu(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
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

