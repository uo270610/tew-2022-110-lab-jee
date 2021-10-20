package impl.tew.business;


import com.tew.business.AlumnosService;
import com.tew.business.ServicesFactory;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public AlumnosService createAlumnosService() {
		return new SimpleAlumnosService();
	}

}
