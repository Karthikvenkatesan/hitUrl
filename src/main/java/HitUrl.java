import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.events.Event;

public class HitUrl
{
	public static void main(String[] args)
	{
		// do something here
		// String url = constructURL (event); //construct the website url
		String url = "http://karthikvenkatesan-test.apigee.net/delayedstockquote-1/quickquote?StockSymbol=IBM&LicenseKey=0";
		HitUrl hitUrl = new HitUrl();
		// String response = hitUrl.callWebsite (url);
		String response = null;
		try
		{
			response = hitUrl.doGet(url);
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(response);
	}

	public String doGet(String strUrl) throws IOException
	{
		// connect();

		// URL url = new URL(protocol, hostname, port, reference);
		URL url = new URL(strUrl);
		InputStream content = (InputStream) url.getContent();

		BufferedReader xml = new BufferedReader(new InputStreamReader(content));
		return xml.readLine();
	}

	private String callWebsite(String url)
	{
		try
		{
			BufferedReader rd = null;
			DataOutputStream wr = null;
			InputStream is = null;
			String line = null;
			StringBuffer response = null;
			String data = null;

			URL requestURL = new URL(url);
			HttpURLConnection connection = null;
			connection = (HttpURLConnection) requestURL.openConnection();
			connection.setRequestMethod("GET");

			// Send response
			wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(data);
			wr.flush();
			wr.close();

			// Get response
			is = connection.getInputStream();
			rd = new BufferedReader(new InputStreamReader(is));
			response = new StringBuffer();
			while ((line = rd.readLine()) != null)
			{
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
