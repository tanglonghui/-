package bean;

public class info {
	/*
	����ѯ�û���¼������ɲ�ѯĳ�û������е�¼�����
	�û������û�����ʱ�䡢��¼ʱ�䡢��¼ʱ������ǰ״̬�����ߡ����ߣ����ɣе�ַ��*/
	private String username;//�û������˺�
	private String y_time;//����������
	
	private String l_time;//��¼ʱ��ʱ����
	private String h_time; //��¼ʱ��
	private String now;//��ǰ״̬
	private String ip;//ip
	
		public info(){};
		public info(String username,String y_time,String l_time,String h_time,String now,String ip)
		{
			super();
			this.username=username;
			this.y_time=y_time;
			
			this.l_time=l_time;
			this.h_time=h_time;
			this.now=now;
			this.ip=ip;
		}
		    
			public String getUsername(){
				return username;
			}
			public void setUsername(String username) {
				this.username=username;
			}
			public String getY_time(){
				return y_time;
			}
			public void setY_time(String y_time){
				this.y_time=y_time;
				
			}
			
			
			public String getL_time(){
				return l_time;
			}
			public void setL_time(String l_time) {
				this.l_time=l_time;
				
			}
			public String getH_time(){
				return h_time;
			}
			public void setH_time(String h_time) {
				this.h_time=h_time;
				
			}
			public String getNow(){
				return now;
			}
			public void setNow(String now) {
				this.now=now;
				
			}
			public String getIp(){
				return ip;
			}
			public void setIp(String ip) {
				this.ip=ip;
				
			}

	

}
