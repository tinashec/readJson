package zw.co.econet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tinashe.Chinyanga on 08/06/2017.
 */
public class ReadKweseHarTest {
    /**
     * 1. open a file
     * 2. parse the file and create a JSON object
     * 3. print a single key/value of the JSON object
     */

    private static final String fileLocation = "C:\\Users\\Tinashe.Chinyanga\\Documents\\Kwese` Automated Test\\Testfile.json";
    private static final String nonExistentFileLocation =  "C:\\Users\\Tinashe.Chinyanga\\Documents\\Kwese` Automated Test\\NoTestfile.json";
    private ReadKweseHar readKweseHar = new ReadKweseHar();
    private ReadJsonFile readJsonFile = new ReadJsonFile();
    private ResultsFile resultsFile = new ResultsFile();
    private String filename;

    @Test
    public void printJsonObjectFieldTest(){
        readJsonFile.setFileLocation(fileLocation);
        JSONArray jsonObjectsArray = readJsonFile.getJsonArrayValueFromKey(readJsonFile.getJsonObject(), "array");

        for(int ctr = 0; ctr < jsonObjectsArray.size(); ctr++) {
            if(ctr == 1)
                assertEquals("The second object contains",
                        "Description 2", ((JSONObject)(readJsonFile.getFieldValueInJsonObjectArray(jsonObjectsArray, ctr))).get("object2Field2"));
        }
    }

    @Test
    public void readFileTest(){

    }

}
