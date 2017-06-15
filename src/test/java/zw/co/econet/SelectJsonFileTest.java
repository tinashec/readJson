package zw.co.econet;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Tinashe.Chinyanga on 14/06/2017.
 */
public class SelectJsonFileTest {
    FilePicker filePicker = new FilePicker();

    @Test
    public void selectFileTest(){
       assertTrue(filePicker.selectFile().exists());
       assertEquals("C:\\Users\\Tinashe.Chinyanga\\Documents\\Kwese` Automated Test", filePicker.selectFile().getParent());
    }
}
