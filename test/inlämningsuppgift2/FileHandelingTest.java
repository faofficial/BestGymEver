package inlämningsuppgift2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandelingTest
{
    FileHandeling f = new FileHandeling();
    Path p = Paths.get("src/inlämningsuppgift2/data.txt");
    Path testPath = Paths.get("test/inlämningsuppgift2/testData.txt");
    Path wrongPath = Paths.get("fel/felPath/Paths");

    @Test
    public void exceptionReadFromFileTest()
    {
        assertThrows(FileNotFoundException.class, () -> {f.readFromFile(wrongPath);});
        assertThrows(IOException.class, () -> {f.readFromFile(wrongPath);});
    }

    @Test
    public void readFromFileTest() throws Exception
    {
        String member1 = "7703021234, Alhambra Aromes";
        String member2 = "8204021234, Bear Belle";

        assertEquals(f.readFromFile(p).get(0), member1);
        assertNotEquals(f.readFromFile(p).get(1), member2);
        assertEquals(f.readFromFile(p).get(2), member2);
    }

    @Test
    public void writeToFileTest() throws Exception
    {
        String temp;
        String data = "test data";

        assertTrue(f.writeToFile(data,testPath));

        try( BufferedReader br = new BufferedReader(new FileReader(String.valueOf(testPath)));)
        {
            while ((temp = br.readLine()) != null){
                assertEquals(data,temp);
            }
        }
    }
}