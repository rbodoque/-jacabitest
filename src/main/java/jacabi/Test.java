package jacabi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;

public class Test {

	public static void main(String[] args) throws IOException {
		JsonObject json = readJson("./test.json");
		projection(json);
		
		

	}
	
	
	private static void projection(final JsonObject json) {
        final JsonObject projn = json.getJsonObject("Projection");
//        final Projection projection = new Projection()
//            .withProjectionType(projn.getString("ProjectionType"));
        final Collection<String> nonkeyattrs = new LinkedList<String>();
        if (projn.containsKey("NonKeyAttributes")) {
            for (final JsonValue nonkey
                : projn.getJsonArray("NonKeyAttributes")) {
                //nonkeyattrs.add(nonkey.toString());
                System.out.println(nonkey.toString());
                JsonString nonkeyStr = (JsonString)nonkey;
                //nonkeyattrs.add(nonkeyStr.getString());
                System.out.println(nonkeyStr.getString());
                
                
            }
           // projection.setNonKeyAttributes(nonkeyattrs);
        }
        //return projection;
    }

	
	private static JsonObject readJson(final String file) throws IOException {
        InputStream stream = null;
        JsonObject json = null;
        try {
        	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        	
        	
            stream = classLoader.getResourceAsStream(file);
            json = Json.createReader(stream).readObject();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (final IOException ex) {
//                    Logger.error(
//                        this,
//                        "Failed to close stream with message %s",
//                        ex.getMessage()
//                    );
                }
            }
        }
        return json;
    }
	
	
}
