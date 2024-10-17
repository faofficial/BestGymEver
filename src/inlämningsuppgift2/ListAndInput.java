package inlämningsuppgift2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListAndInput
{
    private Scanner sc = new Scanner(System.in);
    private String optional = "Ange namn eller personnummer: ";
    private boolean isTest = false;

    public String getInput(){
        return input(isTest,optional);
    }

    public String input(boolean isTest, String optional)
    {
        if (isTest)
        {
            return optional;
        } else
        {
            System.out.println(this.optional);
            return sc.nextLine().trim();
        }
    }

    public List<String> gymMembers (List<String> readFromFile)
    {
        List<String> members = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < readFromFile.size(); i++)
        {
            while (i < readFromFile.size() - 1)
            {
                sb.append(readFromFile.get(i)).append(" ").append(readFromFile.get(i+1));
                i++;
                break;
            }
            members.add(sb.toString().trim());
            sb.delete(0, sb.length());
        }
        return members;
    }
}