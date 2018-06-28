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

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import bean.info;
import bean.role;
import bean.user;
import connect.Connect;
import dao.getInformationDao;
import dao.getUserDao;
import dao.h_timeDao;
import ez_view.ez1;
import ez_view.ez2;
import ez_view.ez3;
import ez_view.ez4;

public class showDemand {
	private String name;
	
	 public void showDemand(String username ,String name,String c_time,String l_time) throws SQLException{
		
		 Frame f=new Frame("��ѯ���");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		//�û�������ɫ�������¹�������������۹�����������
		 this.name=name;
		 Connection conn=Connect.getConnection();
			
		    PreparedStatement p=null;
		    ResultSet rs=null;
		    info gg = null;
			String sql="select * from info where username=? and l_time=?";
			p=conn.prepareStatement(sql);
			p.setString(1,username);
			p.setString(2,l_time);
			rs=p.executeQuery();
			String[] L=new String[100];
			String[] H=new String[100];
			String[] I=new String[100];
			
			while(rs.next()){
				gg=new info();
				//gg.setUsername(rs.getString("username"));
				//gg.setY_time(rs.getString("y_time"));
				gg.setL_time(rs.getString("l_time"));
				gg.setH_time(rs.getString("h_time"));
				gg.setIp(rs.getString("ip"));
				int i1=0;
				L[i1]=gg.getL_time();
				H[i1]=gg.getH_time();
				I[i1]=gg.getIp();
				i1++;
			
			}
			String sql1="select * from info where username=? and now=?";
			p=conn.prepareStatement(sql1);
			p.setString(1,username);
			p.setString(2,"����");
			rs=p.executeQuery();
			String now;
			if(rs.next()){
				now="����";
			}else{
				now="����";
			}
		    
		    Label la3=new Label();
			Label la4=new Label();
			Label la5=new Label();
		    la3.setText("��¼ʱ��:"+L[0]);
			la4.setText("ע��ʱ��:"+H[0]);
			la5.setText("��¼ip :  "+I[0]);
			la3.setBounds(20, 130, 200, 30);
			la4.setBounds(20, 160, 200, 30);
			la5.setBounds(20, 190, 200, 30);
			f.add(la3);
			f.add(la4);
			f.add(la5);
			Label la=new Label();
			Label la1=new Label();
			Label la2=new Label();
			la.setText("�˺�:  "+username);
			la1.setText("��ǰ״̬:  "+now);
			la2.setText("����ʱ��:  "+c_time);
			Button btn7=new Button("����");
			
			
			la.setBounds(20, 30, 100, 30);
			la1.setBounds(20, 60, 200, 30);
			la2.setBounds(20, 90, 200, 30);
			btn7.setBounds(250, 30, 100, 30);
			
		
			f.add(la);
			f.add(la1);
			f.add(la2);
			f.add(btn7);
			
			//����İ�ť����Ȩ�޿���
		
			btn7.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//����������Ϊ����
					demandUser aa=new demandUser();
					getUserDao aaa=new getUserDao();
					user rs;
					try {
						rs = aaa.getuser(name);
						aa.demandUser(rs);
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
