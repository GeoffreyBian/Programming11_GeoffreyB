import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ReadingTextTests {

    @Test

    public void testSearchWord() throws IOException{
        //Adding lines of txt file to arraylist
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null){
            lines.add(line);
        }
        br.close();

        //Searching for word "code" to deduct if the outputted numbers are correct
        ArrayList<Integer> a = Main.searchWord(lines,"code");
        ArrayList<Integer> expectedA = new ArrayList<>();
        expectedA.add(8);
        expectedA.add(12);
        assertEquals(expectedA, a);

        //Searching for word "in"
        ArrayList<Integer> b = Main.searchWord(lines,"in");
        ArrayList<Integer> expectedB = new ArrayList<>();
        expectedB.add(0);
        expectedB.add(2);
        expectedB.add(5);
        expectedB.add(6);
        expectedB.add(8);
        expectedB.add(11);
        expectedB.add(12);
        expectedB.add(14);
        assertEquals(expectedB,b);

        //Seaching for word "machine"
        ArrayList<Integer> c = Main.searchWord(lines, "machine");
        ArrayList<Integer>expectedC=new ArrayList<>();
        expectedC.add(6);
        expectedC.add(8);
        expectedC.add(12);
        assertEquals(expectedC, c);

    }
}
