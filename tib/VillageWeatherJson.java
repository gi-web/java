package tib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class VillageWeatherJson {
	// List<VillageWeather> datalist = new ArrayList<VillageWeather>();
	public List<VillageWeather> getVillageWeather() throws IOException, ParseException {
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		Date nowDate = new Date();
		String tempDate = sdFormat.format(nowDate);

		// JSON�����͸� ��û�ϴ� URLstr�� ����ϴ�.
		String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst";
		// Ȩ���������� ���� Ű
		String serviceKey = "bvDBV2cHURkOCrCAyciGPtFaY9b9INf0YcRYYPvq85wXdUSGfLVDuoZCH2bPAesKsK12rqgYfMT%2FzW6YenpDHA%3D%3D";
		String pageNo = "1";
		String numOfRows = "225"; // �� ������ ��� ��
		String data_type = "JSON"; // Ÿ�� xml, json ��� ..
		String baseDate = tempDate; // "20200821"�̷������� api���� �����ϴ� ���� �״�� �����ø� �˴ϴ�.
		String baseTime = "0500"; // API ���� �ð��� �Է��ϸ� ��
		String nx = "60"; // ����
		String ny = "120"; // �浵

		// ���� 23�� ���� 153���� �����͸� ��ȸ�ϸ� ���ð� ������ ������ �� �� ����
		VillageWeather vl = new VillageWeather();
		StringBuilder urlBuilder = new StringBuilder(apiUrl);
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode(numOfRows, "UTF-8")); /* �� ������ ��� �� */
		urlBuilder.append(
				"&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode(data_type, "UTF-8")); /* Ÿ�� */
		urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "="
				+ URLEncoder.encode(baseDate, "UTF-8")); /* ��ȸ�ϰ���� ��¥ */
		urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "="
				+ URLEncoder.encode(baseTime, "UTF-8")); /* ��ȸ�ϰ���� �ð� AM 02�ú��� 3�ð� ���� */
		urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); // �浵
		urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8") + "&"); // ����

		/* GET������� �����ؼ� �Ķ���� �޾ƿ��� */
		URL url = new URL(urlBuilder.toString());
		// ��� �Ѿ���� Ȯ���ϰ� ������ �Ʒ� ��º� �ּ� ����
		System.out.println(url);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		String result = sb.toString();
		System.out.println("���: " + result);
		// ���ڿ��� JSON���� �Ľ��մϴ�. ������ �迭���·� ����� �����ͱ��� �Ľ��س��ϴ�.
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
		JSONObject parse_response = (JSONObject) jsonObj.get("response");
		JSONObject parse_body = (JSONObject) parse_response.get("body");// response �� ���� body ã�ƿ���
		JSONObject parse_items = (JSONObject) parse_body.get("items");// body �� ���� items �޾ƿ���
		// items�� ���� itemlist �� �޾ƿ��� itemlist : �ڿ� [ �� �����ϹǷ� jsonarray�̴�.
		JSONArray parse_item = (JSONArray) parse_items.get("item");

		JSONObject obj;
		String category; // ���� ��¥�� ���ؽð��� VillageWeather ��ü�� �����մϴ�.

		String day = "";
		String time = "";

		List<VillageWeather> datalist = new ArrayList<VillageWeather>();
		for (int i = 0; i < parse_item.size(); i++) {
			obj = (JSONObject) parse_item.get(i); // �ش� item�� �����ɴϴ�.

			Object fcstValue = obj.get("fcstValue");
			Object fcstDate = obj.get("fcstDate");
			Object fcstTime = obj.get("fcstTime");
			category = (String) obj.get("category"); // item���� ī�װ��� �˻��ؿɴϴ�.
			// �˻��� ī�װ��� ��ġ�ϴ� ������ ���������� �����͸� �����մϴ�.
			// �����͵��� ���°� �޶� ���ڿ��� �����ؾ� ���մϴ�. ������ ����Ҷ� �ٽú�ȯ�ϴ°� �����ϴ�.

			switch (category) {
			case "REH":
				vl.reh = (obj.get("fcstValue")).toString();
				break;
			case "T3H":
				vl.t3h = (obj.get("fcstValue")).toString();
				break;
			}
			if (!day.equals(fcstDate.toString())) {
				day = fcstDate.toString();
			}
			if (!time.equals(fcstTime.toString())) {
				time = fcstTime.toString();
				System.out.println("����: " + day + "  " + "Ÿ��: " + time);
			}

			vl.baseDate = (obj.get("fcstDate")).toString();
			vl.baseTime = (obj.get("fcstTime")).toString();

			VillageWeather test = new VillageWeather();
			test.setT3h(vl.getT3h());
			test.setReh(vl.getReh());
			test.setBaseDate(vl.getBaseDate());
			test.setBaseTime(vl.getBaseTime());

			System.out.print("\tcategory : " + category);
			System.out.print(", fcst_Value : " + fcstValue);
			System.out.print(", fcstDate : " + vl.baseDate);
			System.out.println(", fcstTime : " + vl.baseTime);
			// test = vl;
			if (category.equals("T3H")) {
				System.out.println("HAHA!");
				datalist.add(test);
			} else {
				System.out.println("�̤�");
			}
		}
		return datalist;// ��簪�� ����� VillageWeather��ü�� ��ȯ�մϴ�.
	}
}
