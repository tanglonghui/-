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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import bean.user;
import connect.Connect;
import dao.addUserDao;
import dao.h_timeDao;
import dao.loginDao;
import view.user_m_menu.MyWindowListener;

public class addUser {
	private String name;
	public void addUser(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("����һ���û�");
		 //���������ݿ���ȡ�������б��
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
			TextField tf1=new TextField();
			TextField tf2=new TextField();
			TextField tf3=new TextField();
			TextField tf4=new TextField();
			TextField tf5=new TextField();
			Label la1=new Label("�˺�:");
			Label la2=new Label("����:");
			Label la3=new Label("���:");
			Label la4=new Label("�ǳ�:");
			Label la5=new Label("���:");
			Button btn6=new Button("ȷ��");
			Button btn7=new Button("����");
			
			la1.setBounds(110, 30, 100, 30);
			la2.setBounds(110, 70, 100, 30);//��ʼ���꣬�Լ������
			la3.setBounds(110, 110, 100, 30);
			la4.setBounds(110, 150, 100, 30);
			la5.setBounds(110, 190, 100, 30);
			tf1.setBounds(150, 30, 100, 30);
			tf2.setBounds(150, 70, 100, 30);//��ʼ���꣬�Լ������
			a.setBounds(150, 110, 100, 30);
			tf4.setBounds(150, 150, 100, 30);
			tf5.setBounds(150, 190, 100, 30);
			btn6.setBounds(100, 230, 100, 30);
			btn7.setBounds(200, 230, 100, 30);
			
			f.add(tf1);//����ť���ص�������
			f.add(tf2);
			f.add(a);
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
					String username=tf1.getText();
					String password=tf2.getText();
					String identity=(String) a.getSelectedItem();
					String nickname=tf4.getText();
					String description=tf5.getText();
					 Calendar ca = Calendar.getInstance();
						Date time=ca.getTime();//���ϵͳʱ��
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					    String c_time = sdf.format(time);//���������
					user a=new user(username,password,nickname,identity,description,c_time);
					addUserDao b=new addUserDao();
					try {
						//b.addUserDao(a);
						user s=b.addUserDao(a);
						if(s!=null){
							JOptionPane.showMessageDialog(null,"���ӳɹ�");
							
						user_m_menu m=new user_m_menu();
						m.user_m_menu(rs);
						f.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null,"�˺��Ѿ����ڣ�");
							tf1.setText(null);//����ı���
							tf2.setText(null);
							tf3.setText(null);
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

