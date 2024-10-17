package inlämningsuppgift2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandeling
{
    private Path dataFromFile = Paths.get("src/inlämningsuppgift2/data.txt");
    private Path dataToFile = Paths.get("src/inlämningsuppgift2/PT.txt");

    public Path getDataFromFile()
    {
        return dataFromFile;
    }

    public Path getDataToFile()
    {
        return dataToFile;
    }

    public List<String> readFromFile(Path p) throws Exception
    {
        List<String> list = new ArrayList<>();
        String temp;
        try (BufferedReader br = new BufferedReader(new FileReader(p.toString())))
        {
            while ((temp = br.readLine()) != null)
            {
                list.add(temp);
            }
        }
        return list;
    }

    public boolean writeToFile (String date, Path p)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(p),true)))
        {
            bw.write(date);
            bw.newLine();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}