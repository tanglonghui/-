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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import bean.info;
import bean.user;
import dao.h_timeDao;
import dao.loginDao;
import dao.loginDataDao;



 public class login extends JFrame{
	 public void login(){
		 Frame f=new Frame("��ӭ�����û�Ȩ�޹���ϵͳ");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
			TextField tf1=new TextField();
			//TextField tf2=new TextField();
			JPasswordField tf2=new JPasswordField(); //ʹ�����Ϊ*
			Label la=new Label("���¼");
			Label la1=new Label("�˺�:");
			Label la2=new Label("����:");
			Button btn1=new Button("��¼");
			Button btn2=new Button("ע��");
			 la.setFont(new Font("",1,30));//���������С
			 la.setForeground(Color.red);//����������ɫ
			la.setBounds(150, 50, 200, 50);
			la1.setBounds(50, 100, 80, 30);
			la2.setBounds(50, 150, 80, 30);
			tf1.setBounds(100, 100, 200, 30);
			tf2.setBounds(100, 150, 200, 30);
			btn1.setBounds(100, 200, 100, 30);
			btn2.setBounds(200, 200, 100, 30);//��ʼ���꣬�Լ������
			f.add(btn1);//����ť���ص�������
			f.add(btn2);
			f.add(tf1);
			f.add(tf2);
			f.add(la);
			f.add(la1);
			f.add(la2);
			//����ı�������ı�
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String username=tf1.getText();//����ı���Ϣ
					String password=tf2.getText();
					  //��֤
					loginDao lg=new loginDao();
					try {
						user rs=lg.longin(username, password);
						if(rs!=null){
							f.setVisible(false);
							//��¼�ɹ��������¼ʱ�䣬��¼ip���޸��������
							try {
								InetAddress localAddress=InetAddress.getLocalHost();
								String ip=localAddress.getHostAddress();//���ip
								 Calendar ca = Calendar.getInstance();
									Date time=ca.getTime();//���ϵͳʱ��
								    
								    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								    String y_time = sdf.format(time);//���������
								    
								    Date today=new Date();
								    SimpleDateFormat f=new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss");
								    String l_time=f.format(today);
								    String now="����";
								    loginDataDao a=new loginDataDao();
								    a.loginDataDao(username, y_time, l_time, now, ip);
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							menu m=new menu();
							m.menu(rs);
					
						
						}else{
							JOptionPane.showMessageDialog(null,"�˺Ż�������󣡣���");
							tf1.setText(null);//����ı���
							tf2.setText(null);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ��ע��
					registered r=new registered();
					try {
						r.registered();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					f.setVisible(false);//login��������Ϊ����
					
					
				}
			});
			
				}
	 class MyWindowListener extends WindowAdapter//��д
		{
			public void windowClosing(WindowEvent e){
				
				Window window=(Window) e.getComponent();
				window.dispose();
				System.exit(0);
			}
			}
	}

	
	 

