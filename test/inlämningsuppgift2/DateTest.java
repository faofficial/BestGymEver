package inlämningsuppgift2;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest
{
    Date date = new Date();
    ListAndInput li = new ListAndInput();
    FileHandeling f = new FileHandeling();
    boolean isTest = true;
    String testDate = "2024-04-30";
    Path p = Paths.get("src/inlämningsuppgift2/data.txt");
    LocalDate dateNow = LocalDate.now();
    List<String> members;

    @Test
    public void dateNowTest(){
        assertEquals(date.dateNow(testDate,isTest).toString(),testDate);
        assertEquals(date.dateNow(dateNow.toString(),isTest).toString(), dateNow.toString());
    }

    @Test
    public void checkMembershipTest(){
        assertTrue(date.checkMembership(date.dateNow(testDate,isTest), "2024-08-15"));
        assertTrue(date.checkMembership(date.dateNow(testDate,isTest), "2023-05-01"));
        assertFalse(date.checkMembership(date.dateNow(testDate,isTest), "2023-04-30"));
        assertFalse(date.checkMembership(date.dateNow(testDate,isTest), "2023-02-10"));
    }

    @Test
    public void gymTimeTest() throws Exception
    {
        String testString = "7703021234, Alhambra Aromes 2024-07-01";
        String wrongString = "8204021234, Bear Belle 2019-12-02";
        String ssn = "7703021234";
        String name= "Alhambra Aromes";
        String name2="Bear Belle";
        String dateOfMembership1="2024-07-01";
        String dateOfMembership2="2019-12-02";
        members = li.gymMembers(f.readFromFile(p));

        assertEquals(date.gymTime(members,ssn, dateOfMembership1),testString);
        assertEquals(date.gymTime(members,name, dateOfMembership1),testString);
        assertNotEquals(date.gymTime(members,name2, dateOfMembership2),wrongString);
    }

    @Test
    public void dateOfMembershipTest() throws Exception
    {
        String input1="Alhambra Aromes";
        String input2="Bear Belle";
        members = li.gymMembers(f.readFromFile(p));

        assertEquals(date.dateOfMembership(members, input1),"2024-07-01");
        assertEquals(date.dateOfMembership(members, input2),"2019-12-02");
        assertNotEquals(date.dateOfMembership(members, input2),"2024-07-01");
    }
}