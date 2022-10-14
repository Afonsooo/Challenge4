package br.com.fiap.StarIntersection.HttpHandler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class HttpHandler {

	private static final String USER_AGENT = "Mozilla/5.0";

	public  String executePost(String targetURL, String urlParameters) {
		  HttpURLConnection connection = null;

		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("POST");
		    connection.setRequestProperty("Content-Type", "application/json");
		    connection.setRequestProperty("Accept", "application/json");
		    connection.setRequestProperty("Content-Length", 
		        Integer.toString(urlParameters.getBytes().length));
		    connection.setRequestProperty("Content-Language", "en-US");  

		    connection.setUseCaches(false);
		    connection.setDoOutput(true);
		   
		    //Send request
		    DataOutputStream wr = new DataOutputStream (
		        connection.getOutputStream());
		    wr.writeBytes(urlParameters);
		    wr.close();

		    //Get Response  
		    InputStream is = connection.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
		    String line;
		    while ((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    
		    System.out.println(response.toString());
		    return response.toString();
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if (connection != null) {
		      connection.disconnect();
		    }
		  }
		}
	
	public  String sendHttpGETRequest(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = httpURLConnection.getResponseCode();
//		      System.out.println("GET Response Code: " + responseCode);
		StringBuffer response = new StringBuffer();

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
		} else {
			System.out.println("GET request not worked");
		}

		System.out.println(response.toString());
		JSONArray json = new JSONArray(response.toString());		
		
		for (int i = 0; i < json.length(); i++) {
			System.out.println(json.getJSONObject(i).toString());
		}

		return response.toString();
	}
	
	public  String sendHttpGETRequestEmail(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = httpURLConnection.getResponseCode();
//		      System.out.println("GET Response Code: " + responseCode);
		StringBuffer response = new StringBuffer();

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
		} else {
			System.out.println("GET request not worked");
		}

		System.out.println(response.toString());
		JSONObject jObj = new JSONObject(response.toString());
		
		JSONArray json = jObj.getJSONArray("content");
		
		for (int i = 0; i < json.length(); i++) {
			System.out.println(json.getJSONObject(i).toString());
		}

		return jObj.getJSONArray("content").toString();
	}

}
