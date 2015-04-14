import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration.ClassList;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

	public static void main(final String[] args) throws Exception {
		final Server server = new Server();

		final ClassList classList = ClassList.setServerDefault(server);
		classList.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");

		final NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector(server);
		connector.setPort(8080);
		server.addConnector(connector);

		final ProtectionDomain domain = Main.class.getProtectionDomain();
		final URL location = domain.getCodeSource().getLocation();
		final WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		webapp.setWar(location.toExternalForm());
		server.setHandler(webapp);

		server.start();
		server.join();

	}
}