import org.json.JSONObject;

public class Driver {

	public static void main(String[] args) {
		JsonBuilder jsonBuilder = new JsonBuilder();
		JsonParser jsonParser = new JsonParser();
		
		JSONObject json = jsonBuilder.getJsonFromUrl("https://api-g.weedmaps.com/wm/web/v1/listings/purple-star-md/menu?type=dispensary");
		jsonParser.parseJson(json);
	}

}
