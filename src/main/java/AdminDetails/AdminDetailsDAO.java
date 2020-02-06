package AdminDetails;

public interface AdminDetailsDAO {
	public void addNewAdmin(AdminDetails admindetails)throws Exception;
	public void userLogin(String mailId,String password)throws Exception;

}
