import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonBuilder {

	public JSONObject getJsonFromUrl(String url) {
		InputStream inputStream = getInputStreamFromUrl(url);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		String jsonString = readAllTextFromResponse(bufferedReader);
		JSONObject json = createNewJsonObjectFromString(jsonString);
		
		this.closeBufferedReader(bufferedReader);
		this.closeInputStream(inputStream);
		
		return json;
	}

	private static String readAllTextFromResponse(Reader reader) {
		StringBuilder jsonResult = new StringBuilder();
		
		/* Letter is an int because BufferedReader reads in ascii. */
		int letter;
		while ((letter = getNextLetter(reader)) != -1) {
			jsonResult.append((char) letter);
		}
		return jsonResult.toString();

	}

	private void closeBufferedReader(BufferedReader reader) {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeInputStream(InputStream inputStream) {
		try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int getNextLetter(Reader reader) {
		try {
			return reader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private static InputStream getInputStreamFromUrl(String url) {
		try {
			return new URL(url).openStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static JSONObject createNewJsonObjectFromString(String jsonString) {
		try {
			return new JSONObject(jsonString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

}
