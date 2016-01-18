package mx.com.costoso;

import javax.ejb.EJB;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MiEJBTest {

	@EJB
	MiEJB miEJB;

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive war = ShrinkWrap.create(WebArchive.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE,
						ArchivePaths.create("beans.xml"));

		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addPackage("mx.com.costoso")
				.addAsManifestResource("beans.xml", "beans.xml");
		war.addAsLibraries(jar);
		return war;
	}

	@Test
	public void consultaFechaTest() {
		miEJB.consultarFecha();
		Assert.assertTrue(true);
	}

}
