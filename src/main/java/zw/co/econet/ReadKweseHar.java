package zw.co.econet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

/**
 * Read HAR file and print the URL's accessed, mime type and referring address
 *
 */
public class ReadKweseHar{
    private static FilePicker filePicker = new FilePicker();
    private static String filepath;
    private static final String path = "C:\\Users\\Tinashe.Chinyanga\\Documents\\Kwese` Automated Test\\Results\\";

    public ReadKweseHar(){}

    public ReadKweseHar(String fileLocation){
        if(fileLocation == null){
            throw new IllegalArgumentException();
        }
    }

    public static void main( String[] args ) {
        ReadJsonFile readJsonFile = new ReadJsonFile();

        filepath = filePicker.selectFile().getAbsolutePath();
        readJsonFile.setFileLocation(filepath);

        JSONArray jsonArray = readJsonFile.getJsonArrayValueFromKey(readJsonFile.getJsonObject(), "entries");
        int arraySize = readJsonFile.getJsonArrayValueFromKey(readJsonFile.getJsonObject(), "entries").size();

        ReadKweseHar readKweseHar = new ReadKweseHar();
        readKweseHar.saveJsonObjectFields(jsonArray, arraySize);
    }

    public void saveJsonObjectFields(JSONArray jsonArray, int arraySize){
        ResultsFile resultsFile = new ResultsFile();
        File file = new File(filepath);
        String filename = path + "Results" + file.getName().replace(".json", ".txt");

        resultsFile.writeToFile(filename, "Type" + "\t\t" + "URL");
        for(int ctr = 0; ctr < arraySize; ctr++){
            JSONObject embededObject = retrieveEmbededObject((JSONObject) jsonArray.get(ctr), "request");
            JSONObject embededObject2 = retrieveEmbededObject((JSONObject) jsonArray.get(ctr), "response");
            resultsFile.writeToFile(filename,((JSONObject)embededObject2.get("content")).get("mimeType") + " " + embededObject.get("url"));
        }
    }

    public JSONObject retrieveEmbededObject(JSONObject jsonObject, String fieldName){
        return (JSONObject) jsonObject.get(fieldName);
    }
}
