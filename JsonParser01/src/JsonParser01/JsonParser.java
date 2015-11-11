package JsonParser01;

import org.json.JSONObject;

import com.example.rss01.Weather;
import com.example.rss01.WeatherDetails;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

public class JsonParser {
	String JsonString = "{\"city\":{\"id\":112931,\"name\":\"Tehran\",\"coord\":{\"lon\":51.421509,\"lat\":35.694389},\"country\":\"IR\",\"population\":0},\"cod\":\"200\",\"message\":0.0079,\"cnt\":7,\"list\":[{\"dt\":1446796800,\"temp\":{\"day\":7.57,\"min\":3.29,\"max\":7.57,\"night\":3.29,\"eve\":4.14,\"morn\":6.1},\"pressure\":798.38,\"humidity\":86,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":0.2,\"deg\":255,\"clouds\":88,\"rain\":6.18,\"snow\":0.09},{\"dt\":1446883200,\"temp\":{\"day\":4.27,\"min\":2.83,\"max\":4.27,\"night\":3.07,\"eve\":3.41,\"morn\":2.83},\"pressure\":801.09,\"humidity\":100,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":0.47,\"deg\":307,\"clouds\":92,\"rain\":7.56,\"snow\":0.18},{\"dt\":1446969600,\"temp\":{\"day\":3.34,\"min\":1.76,\"max\":3.4,\"night\":1.76,\"eve\":2.68,\"morn\":2.75},\"pressure\":801.86,\"humidity\":100,\"weather\":[{\"id\":601,\"main\":\"Snow\",\"description\":\"snow\",\"icon\":\"13d\"}],\"speed\":0.21,\"deg\":111,\"clouds\":92,\"rain\":2.41,\"snow\":2.57},{\"dt\":1447056000,\"temp\":{\"day\":2.93,\"min\":0.35,\"max\":3.2,\"night\":2.16,\"eve\":2.43,\"morn\":0.35},\"pressure\":798.59,\"humidity\":100,\"weather\":[{\"id\":601,\"main\":\"Snow\",\"description\":\"snow\",\"icon\":\"13d\"}],\"speed\":0.16,\"deg\":104,\"clouds\":92,\"rain\":0.47,\"snow\":1.6},{\"dt\":1447142400,\"temp\":{\"day\":7.51,\"min\":4.84,\"max\":9.08,\"night\":5.46,\"eve\":9.08,\"morn\":4.84},\"pressure\":846.94,\"humidity\":0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":0.6,\"deg\":245,\"clouds\":76,\"rain\":9.6},{\"dt\":1447228800,\"temp\":{\"day\":8,\"min\":4.46,\"max\":8.54,\"night\":4.46,\"eve\":8.54,\"morn\":4.6},\"pressure\":843.25,\"humidity\":0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":0.74,\"deg\":274,\"clouds\":19,\"rain\":4.52},{\"dt\":1447315200,\"temp\":{\"day\":5.33,\"min\":2.49,\"max\":9.52,\"night\":3.49,\"eve\":9.52,\"morn\":2.49},\"pressure\":848.11,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":0.71,\"deg\":320,\"clouds\":0,\"rain\":0.29}]}";

	public static void main(String[] args) {
		Weather w = new Weather();
		WeatherDetails wd = new WeatherDetails();
		try {
			String responseString = new OkHttpClient().newCall(new Request.Builder().url(String.format(
					"http://api.openweathermap.org/data/2.5/forecast/daily?q= %s &mode=json&units=metric&cnt= %d &appid=448ba0f36b0f893a347572821031ef8a",
					w.CityName, w.cnt))
					.build()).execute().body().string();
			JSONObject jsonResult = new JSONObject(responseString);
			for (int i = 0; i < w.cnt; i++) {
				w.country = jsonResult.getString("country");
				wd.DescriptionWeather = jsonResult.getJSONArray("weather").getJSONObject(i).getString("description");
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
