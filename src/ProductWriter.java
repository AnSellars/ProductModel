import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
/**
 * @author sellaraj
 * practicum 1
 */
public class ProductWriter
{


    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        ArrayList <String>recs = new ArrayList<>();
        do {
            recs.add((SafeInput.getNonZeroLenString(in, "Enter ID")) + ", " +
                    (SafeInput.getNonZeroLenString(in, "Enter Name")) + ", " +
                    (SafeInput.getNonZeroLenString(in, "Enter Description")) + ", " +
                    (SafeInput.getDouble(in, "Enter Cost")));
        }
        while (SafeInput.getYNConfirm(in,"Do you want to enter another value?"));

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\"+SafeInput.getNonZeroLenString(in,"Enter File Name")+".txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for(String rec : recs)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}