package inlämningsuppgift2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ListAndInputTest
{
    ListAndInput li=new ListAndInput();
    FileHandeling fh=new FileHandeling();
    boolean isTest = true;
    Path p = Paths.get("src/inlämningsuppgift2/data.txt");

    @Test
    public void inputTest(){
        String optional= "Test data";
        String wrongData ="Wrong data";
        assertEquals(li.input(isTest,optional),optional);
        assertNotEquals(li.input(isTest,optional),wrongData);
    }

    @Test
    public void gymMembersTest() throws Exception
    {
        String firstPerson = "7703021234, Alhambra Aromes 2024-07-01";
        String secondPerson = "8204021234, Bear Belle 2019-12-02";
        String lastPerson = "7805211234, Nahema Ninsson 2024-08-04";

        List<String> members = li.gymMembers(fh.readFromFile(p));

        assertEquals(members.getFirst(), firstPerson);
        assertEquals(members.get(1), secondPerson);
        assertNotEquals(members.get(2),firstPerson);
        assertEquals(members.getLast(),lastPerson);
    }
}