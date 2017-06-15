package zw.co.econet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tinashe.Chinyanga on 14/06/2017.
 */
public class ReadJsonFileTest {
    private ReadJsonFile readJsonFile = new ReadJsonFile();
    private static final String fileLocation = "C:\\Users\\Tinashe.Chinyanga\\Documents\\Kwese` Automated Test\\Testfile.json";
    private static final String nonExistentFileLocation =  "C:\\Users\\Tinashe.Chinyanga\\Documents\\Kwese` Automated Test\\NoTestfile.json";

    @Test
    public void readJsonFileTest(){
        readJsonFile.setFileLocation(fileLocation);
        assertEquals("Value", "1.0", readJsonFile.getJsonObject().get("version"));
    }

    @Test
    public void readNonExistentFileTest() {
        readJsonFile.setFileLocation(nonExistentFileLocation);
        readJsonFile.openJsonFile(readJsonFile.getFileLocation());
    }

    @Test
    public void getJsonObjectTest(){
        readJsonFile.setFileLocation(fileLocation);
        assertEquals("Test File", readJsonFile.getJsonObject().get("name"));
        JSONArray jsonObjectsArray = readJsonFile.getJsonArrayValueFromKey(readJsonFile.getJsonObject(), "array");
        assertEquals("Name 1", ((JSONObject)(readJsonFile.getFieldValueInJsonObjectArray(jsonObjectsArray, 0))).get("object1Field1"));
    }
}
