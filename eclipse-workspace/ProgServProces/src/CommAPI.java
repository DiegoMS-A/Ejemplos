
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

public class CommAPI {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL_API = "https//anapioficeandfire.com/api/characters/583";

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(URL_API);

		Response response = target.request().get();

		System.out.println("Peticion devuelta con estado: " + response.getStatus());
		System.out.println("El resultado es de tipo: " + response.getMediaType());

		String respuesta = response.readEntity(String.class);

		JSONObject obj = new JSONObject();

		System.out.println(JSONObject.toString(respuesta, 2));



	}

}
