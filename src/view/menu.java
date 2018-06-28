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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import bean.role;
import bean.user;
import dao.getInformationDao;
import dao.h_timeDao;
import ez_view.ez1;
import ez_view.ez2;
import ez_view.ez3;
import ez_view.ez4;

public class menu {
	private String name;
	 public void menu(user rs) throws SQLException{
		 String a=rs.getIdentity();
		 this.name=rs.getUsername();
		 role ro=new role();
		 getInformationDao g=new getInformationDao();
		 ro=g.getInfo(a);//��ȡ��¼�Ľ�ɫ��Ϣ
		 
		 Frame f=new Frame("�˵�");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		//�û�������ɫ�������¹�������������۹�����������
			Button btn1=new Button("�û�����");
			Button btn2=new Button("��ɫ����");
			Button btn3=new Button("���¹���");
			Button btn4=new Button("�������");
			Button btn5=new Button("���۹���");
			Button btn6=new Button("��������");
			Button btn7=new Button("�л��û�");
			Label la=new Label();
			Label la1=new Label();
			Label la2=new Label();
			la.setText("���:  "+ro.getIdentity());
			la1.setText("�ǳ�:  "+rs.getNickname());
			la2.setText("���:  "+rs.getDescription());
			la.setBounds(20, 30, 180, 30);
			la1.setBounds(20, 70, 100, 30);
			la2.setBounds(20, 110, 180, 30);
			btn1.setBounds(200, 30, 100, 30);
			btn2.setBounds(200, 70, 100, 30);//��ʼ���꣬�Լ������
			btn3.setBounds(200, 110, 100, 30);
			btn4.setBounds(200, 150, 100, 30);
			btn5.setBounds(200, 190, 100, 30);
			btn6.setBounds(200, 230, 100, 30);
			btn7.setBounds(20, 230, 100, 30);
			
			f.add(btn7);
			f.add(la);
			f.add(la1);
			f.add(la2);
			//����İ�ť����Ȩ�޿���
			String lev=ro.getLevel();
			//char ��ΪStirng
			String s1=String.valueOf(lev.charAt(1));
			String s2=String.valueOf(lev.charAt(2));
			String s3=String.valueOf(lev.charAt(3));
			String s4=String.valueOf(lev.charAt(4));
			String s5=String.valueOf(lev.charAt(5));
			String s6=String.valueOf(lev.charAt(6));
			if(lev.length()==7)
			{
				if(s1.equals("1")){
					f.add(btn1);
				}

				if(s2.equals("1")){
					f.add(btn2);
				}

				if(s3.equals("1")){
					f.add(btn3);
				}

				 if(s4.equals("1")){
					f.add(btn4);
				}

				if(s5.equals("1")){
					f.add(btn5);
				}

				 if(s6.equals("1")){
					f.add(btn6);
				}
				
				
				
			}else{
				JOptionPane.showMessageDialog(null,"Ȩ�޿��������");
				if(ro.getIdentity().equals("����Ա")){
					JOptionPane.showMessageDialog(null,"���ǹ���Ա����������Ȩ����");
				}
			}
			
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//menu��������Ϊ����
					user_m_menu m=new user_m_menu();
					try {
						m.user_m_menu(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//menu��������Ϊ����
					role_m_menu m=new role_m_menu();
					m.role_m_menu(rs);
					
					
				}
			});
			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//menu��������Ϊ����
					ez1 m=new ez1();
					try {
						m.ez1(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//menu��������Ϊ����
					ez2 m=new ez2();
					try {
						m.ez2(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//menu��������Ϊ����
					ez3 m=new ez3();
					try {
						m.ez3(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//menu��������Ϊ����
					ez4 m=new ez4();
					try {
						m.ez4(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn7.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					  h_timeDao aa=new h_timeDao();
					    try {
							aa.h_time(name);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					f.setVisible(false);//menu��������Ϊ����
					login a=new login();
					a.login();
					
					
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
