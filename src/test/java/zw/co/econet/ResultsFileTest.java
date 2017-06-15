package zw.co.econet;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tinashe.Chinyanga on 14/06/2017.
 */
public class ResultsFileTest {

    private String filename;
    private static final String newFilePath = "C:\\Users\\Tinashe.Chinyanga\\Documents\\Kwese` Automated Test\\";
    private ResultsFile resultsFile = new ResultsFile();

    @Test
    public void createFileTest(){
        filename = newFilePath + "TestResults.txt";
        resultsFile.createResultsFile(filename);
        assertTrue("File not created", resultsFile.createResultsFile(filename).exists() );
    }

    @Test
    public void writeToFileTest(){
        File file = new File(newFilePath + "TestResults.json".replace(".json", ".txt"));
        resultsFile.writeToFile(file.getParent() + "\\" + "Results" + file.getName(), "First line reads: Line 1. \n");
        assertEquals("First line reads: Line 1. ", resultsFile.readFile(newFilePath + "TestResults.txt"));
    }
}
