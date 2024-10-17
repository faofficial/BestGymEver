package inlämningsuppgift2;

import java.io.IOException;
import java.util.List;

public class BestGymEver
{
    public BestGymEver(){

        ListAndInput li = new ListAndInput();
        FileHandeling f = new FileHandeling();
        Date d = new Date();

        String in = li.getInput();

        try
        {
            List<String> members = li.gymMembers(f.readFromFile(f.getDataFromFile()));
            String gymTime = d.gymTime(members,in, String.valueOf(d.getDateNow()));

            boolean member = d.checkMembership(d.getDateNow(), d.dateOfMembership(members,in));
            if (member)
            {
                f.writeToFile(gymTime,f.getDataToFile());
                System.out.println(Categorys.CUSTOMER.label);
            } else
            {
                System.out.println(Categorys.FORMER_CUSTOMER.label);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(Categorys.UNAUTHORIZED.label);
        }
    }

    public static void main(String[] args)
    {
        BestGymEver b = new BestGymEver();
    }
}