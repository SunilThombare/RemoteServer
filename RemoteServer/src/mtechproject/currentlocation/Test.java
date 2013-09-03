package mtechproject.currentlocation;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.smartechz.tools.mygeoloc.GeoPlanetExplorer;
import com.smartechz.tools.mygeoloc.Geobytes;
import com.smartechz.tools.mygeoloc.YahooWeather;

public class Test {

	public static void main(String[] args) throws IOException,
			IllegalArgumentException, IllegalAccessException,
			ParserConfigurationException, SAXException {
		// Geobytes
		System.out.println("Continent : " + Geobytes.get(Geobytes.MapReference));
		System.out.println("Country   : " + Geobytes.get(Geobytes.Country));
		System.out.println("State     : " + Geobytes.get(Geobytes.Region));
		System.out.println("City      : " + Geobytes.get(Geobytes.City));

		System.out.println("\nMyLocation = " + Geobytes.getMyLocation());

		// GeoPlanetExplorer
		String MyWOEID = GeoPlanetExplorer.getWOEID(Geobytes.getMyLocation());
		System.out.println("\nMyLocation's WOEID = " + MyWOEID);
		String otherLoc = "Brasilia,  brazil , south america";
		System.out.println("Other city's WOEID (" + otherLoc + ")  = "
				+ GeoPlanetExplorer.getWOEID(otherLoc));

		// Yahoo Weather

		//System.out.println("\nYahoo weather for WOEID = " + MyWOEID);

		//YahooWeather yw = new YahooWeather(MyWOEID);

		/*System.out.println("City=" + yw.getCity());
		System.out.println("region=" + yw.getRegion());
		System.out.println("country=" + yw.getCountry());

		System.out.println("temperature=" + yw.getTemperatureUnit());
		System.out.println("distance=" + yw.getDistanceUnit());
		System.out.println("pressure=" + yw.getPressureUnit());
		System.out.println("speed=" + yw.getSpeedUnit());

		System.out.println("chill=" + yw.getChill());
		System.out.println("direction=" + yw.getDirection());
		System.out.println("speed=" + yw.getSpeed());

		System.out.println("humidity=" + yw.getHumidity());
		System.out.println("visibility=" + yw.getVisibility());
		System.out.println("pressure=" + yw.getPressure());
		System.out.println("rising=" + yw.getRising());

		System.out.println("sunrise=" + yw.getSunrise());
		System.out.println("sunset=" + yw.getSunset());

		System.out.println("text=" + yw.getText());
		System.out.println("code=" + yw.getCode());
		System.out.println("temp=" + yw.getTemprature());

		System.out.println("getTodaysHigh=" + yw.getTodaysHigh());
		System.out.println("getTodaysLow=" + yw.getTodaysLow());
		System.out.println("getTodaysText=" + yw.getTodaysText());
		System.out.println("getTodayCode=" + yw.getTodaysCode());

		System.out.println("getTomorrowsHigh=" + yw.getTomorrowsHigh());
		System.out.println("getTomorrowsLow=" + yw.getTomorrowsLow());
		System.out.println("getTomorrowsText=" + yw.getTomorrowsText());
		System.out.println("getTomorrowsCode=" + yw.getTomorrowsCode());*/
	}
}
