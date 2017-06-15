package zw.co.econet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Tinashe.Chinyanga on 14/06/2017.
 */
public class ReadJsonFile {
    private String fileLocation;
    private JSONParser jsonParser = new JSONParser();

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public FileReader openJsonFile(String fileLocation) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileLocation);
        } catch (FileNotFoundException e) {
            System.out.println("File in " + fileLocation + " not found." + e.getMessage());
        }
        return fileReader;
    }

    public JSONObject getJsonObject() {
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(openJsonFile(fileLocation));
        }catch (ParseException pe){
            pe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(jsonObject.get("log") != null)
            return (JSONObject) jsonObject.get("log");
        return jsonObject;
    }

    public JSONArray getJsonArrayValueFromKey(JSONObject jsonObject, String key) {
        return (JSONArray) jsonObject.get(key);
    }

    public Object getFieldValueInJsonObjectArray(JSONArray jsonObjectsArray, int jsonPosition) {
        return jsonObjectsArray.get(jsonPosition);
    }
}
