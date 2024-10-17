package inlämningsuppgift2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Date
{
    private final boolean isTest = false;
    private final String dateFormat = "yyyy-MM-dd";

    public LocalDate getDateNow(){
        return dateNow("",isTest);
    }

    public LocalDate dateNow(String date, boolean isTest)
    {
        if(isTest){
            return LocalDate.parse(date);
        }
        LocalDate ld = LocalDate.now();
        ld.format(DateTimeFormatter.ofPattern(dateFormat));
        return ld;
    }

    public boolean checkMembership(LocalDate dateNow, String dateOfMembership)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dn = LocalDate.parse(dateNow.toString(), formatter);
        LocalDate dom = LocalDate.parse(dateOfMembership, formatter);
        Period period = Period.between(dom, dn);
        if (period.getYears() < 1)
        {
            return true;
        }
        return false;
    }

    public String dateOfMembership(List<String> gymMembers, String input){
        String temp;
        for (int i = 0; i < gymMembers.size(); i++)
        {
            temp = gymMembers.get(i);
            if (temp.substring(0, temp.indexOf(",")).equalsIgnoreCase(input) || temp.substring(temp.indexOf(" ")+1,
                    temp.lastIndexOf(" ")).equalsIgnoreCase(input))
            {
                return temp.substring(temp.lastIndexOf((" "))).trim();
            }
        }
        return null;
    }

    public String gymTime(List<String> gymMembers, String input, String dateNow)
    {
        String temp;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < gymMembers.size(); i++)
        {
            temp = gymMembers.get(i);

            if (temp.substring(0, temp.indexOf(",")).equalsIgnoreCase(input) || temp.substring(temp.indexOf(" ")+1,
                    temp.lastIndexOf(" ")).equalsIgnoreCase(input) && checkMembership(dateNow(dateFormat,isTest),
                    temp.substring(temp.lastIndexOf(" ")+1)))
            {
                    return sb.append(temp.substring(0,temp.lastIndexOf(" ")))+" " + dateNow;
            }
        }
        return null;
    }
}
