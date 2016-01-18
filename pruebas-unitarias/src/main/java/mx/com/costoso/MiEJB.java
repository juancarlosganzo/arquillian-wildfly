package mx.com.costoso;

import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.Stateless;

@Stateless
public class MiEJB {

	private static final Logger log = Logger.getLogger(MiEJB.class.getName());
	
	public void consultarFecha(){
		Date fecha = new Date();
		log.info("Esta es la fecha Actual" + fecha);
	}
	
	

}
