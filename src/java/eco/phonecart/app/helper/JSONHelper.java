package eco.phonecart.app.helper;

import org.json.simple.JSONObject;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;

public class JSONHelper extends JSONObject {

	private String MARKER_CHAR = "$";
	private String END_CHAR = "}" + MARKER_CHAR + "\"";
	private String START_CHAR = "\"" + MARKER_CHAR + "{";

	public Object putJSON(Object key, String value) {

		value = MARKER_CHAR + value + MARKER_CHAR;

		return super.put(key, value);
	}

	public Object putJSON(Object key, JSONObject value) {
		String s_value = MARKER_CHAR + value.toJSONString() + MARKER_CHAR;

		return super.put(key, s_value);
	}

	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub
		return super.toJSONString().
				replace(START_CHAR, "{").
				replace(END_CHAR, "}").
				replace("\\", "");
	}
	
	
	
	
	public static String toArray(JSONHelper...jsons) {
		
		StringBuilder sb = new  StringBuilder();
		sb.append("[");
		
		boolean first = true;
		
		for ( JSONHelper j : jsons ) {
			if (first) {
				sb.append(j);
			} else {
				sb.append(", ").append(j);
			}
		}
		return sb.append("]").toString();
	}

}
