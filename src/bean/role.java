package bean;

public class role {
	private String identity; //��ɫ
	private String rolename;//��ɫ�ǳ�
	private String ms;//��ɫ����
	private String level; //Ȩ��
	

	public role(){};
	public role(String identity,String rolename,String ms,String level)
	{
		super();
		this.identity=identity;
		this.rolename=rolename;
		this.ms=ms;
		this.level=level;
		
	}
		public String getIdentity(){
			return identity;
		}
		public void setIdentity(String identity) {
			this.identity=identity;
			
		}
		    
		public String getRolename(){
			return rolename;
		}
		public void setRolename(String rolename) {
			this.rolename=rolename;
		}
		
		public String getMs(){
			return ms;
		}
		public void setMs(String ms) {
			this.ms=ms;
			
		}
		public String getLevel(){
			return level;
		}
		public void setLevel(String level) {
			this.level=level;
			
		}
		
}
