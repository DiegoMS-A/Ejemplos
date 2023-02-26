import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class UrlConnection {

	public static void main(String[] args) throws IOException, MalformedURLException {
		// TODO Auto-generated method stub
		URL laURL = new URL("https://es.wikipedia.org/wiki/Alan_Turing");

		URLConnection laConexion = laURL.openConnection();
		Map<String, List<String>> cabecera = laConexion.getHeaderFields();

		for (String key : cabecera.keySet()) {
			System.out.println(key + ": " + cabecera.get(key));
		}

	}

}
