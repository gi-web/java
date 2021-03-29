package tib;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.parser.ParseException;

public class WeatherControl extends TimerTask {
	public void run() {
		Calendar date = Calendar.getInstance();
		String stamp = date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE) + ":"
				+ date.get(Calendar.SECOND) + ":" + date.get(Calendar.MILLISECOND);
		System.out.println(stamp + " " + "Generating report");

		// List<VillageWeather> datalist = new List<VillageWeather>;
		VillageWeatherJson vlist = new VillageWeatherJson();
		// 기상데이터를 JSON을 arrayList 형태로 받아 VillageWeather에 저장
		List<VillageWeather> vw;

		try {
			vw = vlist.getVillageWeather();
			VillageWeatherDAO vwDao = new VillageWeatherDAO();
			vwDao.insertVillageWeather(vw);

		} catch (IOException | ParseException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 데이터베이스에 접속에 관련하는객체를 만들고 데이터베이스에 입력
	}

	public static void main(String[] args) {

		Timer timer = new Timer();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY

		);

		date.set(Calendar.HOUR, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		// Schedule to run every Sunday in midnight
		timer.schedule(new WeatherControl(), date.getTime(),
				// 1000 * 5
				// 1000 * 60 * 60 * 24
				1000 * 60 * 60);
	}
}
