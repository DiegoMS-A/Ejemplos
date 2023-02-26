package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class LecturaJsonExt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlString = "https://randomuser.me/api/?results=50";
		try {
			URL url = new URL(urlString);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lectura = bufferedReader.readLine();
			System.out.println(lectura);
			JSONObject object = new JSONObject(lectura);
			JSONArray resultados = object.getJSONArray("results");
			for (int i = 0; i < resultados.length(); i++) {
				JSONObject temporal = resultados.getJSONObject(i);
				JSONObject objectName = temporal.getJSONObject("name");
				System.out.println(objectName.getString("title"));
				System.out.println(objectName.getString("first"));
				System.out.println(objectName.getString("last"));
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
