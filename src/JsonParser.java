import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

	public void parseJson(JSONObject json) {
		thing(json, "listing");
	}

	private void thing(JSONObject json, String key) {
		JSONArray keys = json.names();

		for(int i = 0; i < keys.length(); ++i) {
			key = getKeyFromJsonKeys(i, keys);
			if(key.equals("listing")) {
				JSONObject object = json.getJSONObject(key);
				System.out.println(getJsonObjectWithKey(json, key));
				System.out.println(object.get("license_type"));
				System.out.println(object.get("city"));

				JSONObject hoursJsonObject = object.getJSONObject("todays_hours");
				System.out.println(hoursJsonObject.get("open_status"));

				JSONArray categories = json.getJSONArray("categories");
				System.out.println(categories);
			}
		}
	}
	
	private JSONObject 
	
	private JSONObject getJsonObjectWithKey(JSONObject json, String key) {
		try {
			return json.getJSONObject(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String getKeyFromJsonKeys(int index, JSONArray keys) {
		try {
			return keys.getString(index);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

