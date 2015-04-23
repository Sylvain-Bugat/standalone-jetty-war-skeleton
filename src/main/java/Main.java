import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration.ClassList;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Jetty main launcher class.
 * 
 * @author Sylvain Bugat
 */
public class Main {

	/**
	 * Launcher and program main method.
	 * 
	 * @param args program arguments
	 * @throws Exception thrown by Jetty
	 */
	public static void main(final String[] args) throws Exception {

		// Jetty server
		final Server server = new Server();

		// Add Jetty Web XML and annotation configuration
		final ClassList classList = ClassList.setServerDefault(server);
		classList.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration"); //$NON-NLS-1$ //$NON-NLS-2$

		// Add a connector to open a port
		try (final NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector(server)) {

			connector.setPort(8080);
			server.addConnector(connector);

			// Get the current class URL to add the current packaged war
			final ProtectionDomain mainDomain = Main.class.getProtectionDomain();
			final URL location = mainDomain.getCodeSource().getLocation();

			// Add the war location to the context, the default context path is /
			final WebAppContext webAppContext = new WebAppContext();
			webAppContext.setWar(location.toExternalForm());
			server.setHandler(webAppContext);

			// Start the Jetty server
			server.start();
			server.join();
		}
	}
}