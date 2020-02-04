package AdminDetails;

public interface AdminDetailsDAO {
	public void addNewAdmin(AdminDetails admindetails)throws Exception;
	public void userLogin(String adminMailId,String adminPassword)throws Exception;

}
