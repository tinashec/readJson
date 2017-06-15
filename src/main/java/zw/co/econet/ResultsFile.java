package zw.co.econet;

import java.io.*;

/**
 * Created by Tinashe.Chinyanga on 14/06/2017.
 */
public class ResultsFile {

    private File resultsFile;
    private String resultsFilename;

    public File createResultsFile(String filename) {
        try{
            resultsFile = new File(filename);
            resultsFile.createNewFile();
        }catch (IOException ioe){
            System.out.println("IO Exception, unable to create file. " +  ioe.getMessage());
        }
        return resultsFile;
    }

    public String readFile(String filename) {
        String readLine = null;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            readLine = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLine;
    }

    public void writeToFile(String filename, String textToWrite) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textToWrite);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
