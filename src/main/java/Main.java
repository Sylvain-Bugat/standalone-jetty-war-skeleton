import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main
{
	public static void main(String[] args) throws Exception {
		Server server = new Server();

		NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector( server );
		connector.setPort(8080);
		server.addConnector(connector);

		ProtectionDomain domain = Main.class.getProtectionDomain();
		URL location = domain.getCodeSource().getLocation();
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		webapp.setWar(location.toExternalForm());
		server.setHandler(webapp);

		server.start();
		server.join();

	}
}