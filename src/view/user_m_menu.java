package view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import bean.role;
import bean.user;
import dao.getInformationDao;
import dao.h_timeDao;


public class user_m_menu {
	private String name;
	public void user_m_menu(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
			String a=rs.getIdentity();
		 role ro=new role();
		 getInformationDao g=new getInformationDao();
		 ro=g.getInfo(a);//��ȡ��¼�Ľ�ɫ��Ϣ
		 Frame f=new Frame("�û�����");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		//����һ���û���ɾ��һ���û����޸��û���Ϣ����ѯ�û���¼��������¸��������
			Button btn1=new Button("����һ���û�");
			Button btn2=new Button("ɾ��һ���û�");
			Button btn3=new Button("�޸��û���Ϣ");
			Button btn4=new Button("��ѯ�û���¼���");
			Button btn5=new Button("���¸������");
			Button btn6=new Button("����");
			
			
			btn1.setBounds(150, 30, 100, 30);
			btn2.setBounds(150, 70, 100, 30);//��ʼ���꣬�Լ������
			btn3.setBounds(150, 110, 100, 30);
			btn4.setBounds(150, 150, 100, 30);
			btn5.setBounds(150, 190, 100, 30);
			btn6.setBounds(150, 230, 100, 30);
			String lev=ro.getLevel();
			//char ��ΪStirng
			String s1=String.valueOf(lev.charAt(0));
			if(s1.equals("3"))
			{
			f.add(btn1);//����ť���ص�������
			f.add(btn2);
			f.add(btn3);
			f.add(btn4);
			f.add(btn5);
			
			}
			if(s1.equals("2")){
				f.add(btn5);
			}
			if(s1.equals("1")){
				f.add(btn5);
			}
			f.add(btn6);
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//����������Ϊ����
					addUser m=new addUser();
					try {
						m.addUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//����������Ϊ����
					deleteUser m=new deleteUser();
					try {
						m.deleteUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//����������Ϊ����
					changeUser m=new changeUser();
					try {
						m.changeUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//����������Ϊ����
					demandUser m=new demandUser();
					try {
						m.demandUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//����������Ϊ����
					changeMyUser m=new changeMyUser();
					try {
						m.changeMyUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					f.setVisible(false);//����������Ϊ����
					menu m=new menu();
					try {
						m.menu(rs);
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


