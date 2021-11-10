package impl.tew.business;


import com.tew.business.AlumnosService;
import com.tew.business.LoginService;
import com.tew.business.ServicesFactory;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public AlumnosService createAlumnosService() {
		return new SimpleAlumnosService();
	}

	@Override
	public LoginService createLoginService() {
		// TODO Auto-generated method stub
		
		return new SimpleLoginService();	
	}

}
