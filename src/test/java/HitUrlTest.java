import java.io.IOException;


import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class HitUrlTest
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public final void test()
	{
		String url = "http://karthikvenkatesan-test.apigee.net/delayedstockquote-1/quickquote?StockSymbol=IBM&LicenseKey=0";
		HitUrl hitUrl = new HitUrl();
		String strJsonObj = null;
		try
		{
			strJsonObj = hitUrl.doGet(url);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(strJsonObj);
		
		String strExpected = getExpected();
		System.out.println("strExpected = "+strExpected);
		String strActual = getActual(strJsonObj);
		System.out.println("strActual = "+strActual);
		
		Assert.assertEquals(strExpected, strActual);
	}
	
	public String getExpected()
    {
		return "160";
    }
	
	public String getActual(String strJsonObj)
    {
		JSONObject jsonObject = new JSONObject(strJsonObj);
		System.out.println("jsonObject "+ jsonObject.toString());
		JSONObject getQuickQuoteResponse = jsonObject.getJSONObject("GetQuickQuoteResponse");
		System.out.println("GetQuickQuoteResponse = "+getQuickQuoteResponse.toString());
		String strQuickQuoteResult = getQuickQuoteResponse.get("GetQuickQuoteResult").toString();
		strQuickQuoteResult = strQuickQuoteResult.substring(0, strQuickQuoteResult.lastIndexOf("."));
		System.out.println("strQuickQuoteResult = "+strQuickQuoteResult);
		return strQuickQuoteResult;
    }

}
