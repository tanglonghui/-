package ez_view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bean.role;
import bean.user;
import dao.getInformationDao;
import dao.h_timeDao;
import view.menu;


public class ez2 {
	private String name;
	public void ez2(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("�������");
			String a=rs.getIdentity();
			 role ro=new role();
			 getInformationDao g=new getInformationDao();
			 ro=g.getInfo(a);//��ȡ��¼�Ľ�ɫ��Ϣ
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		//
			Button btn1=new Button("��ѯ�����¼");
			Button btn2=new Button("ͳ�Ʋ����¼");
			Button btn3=new Button("�޸Ĳ����¼");
			Button btn4=new Button("����");
			
			
			btn1.setBounds(150, 30, 100, 30);
			btn2.setBounds(150, 70, 100, 30);//��ʼ���꣬�Լ������
			btn3.setBounds(150, 110, 100, 30);
			btn4.setBounds(150, 150, 100, 30);
		
			f.add(btn1);//����ť���ص�������
			String lev=ro.getLevel();
			//char ��ΪStirng
			String s1=String.valueOf(lev.charAt(0));
			if(s1.equals("2")){
				f.add(btn2);
				f.add(btn3);
				
			}
			f.add(btn4);
		
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					JOptionPane.showMessageDialog(null,"��ѯ�ɹ�");
					
					
				}
			});
			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					JOptionPane.showMessageDialog(null,"ͳ�Ƴɹ�");
					
				}
			});
			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ǰ���û�����
					
					JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
					
				}
			});
			btn4.addActionListener(new ActionListener(){
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



