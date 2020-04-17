import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //Method that searches for a word and return every index position of the arraylist
    public static ArrayList<Integer> searchWord(ArrayList<String> lines, String word){
        //Scanning through "lines" arraylist to find specific word.
        //If word is in the line, add index position to the "indexPosition" arraylist
        ArrayList <Integer> indexPositions = new ArrayList<>();
        int i=0;
        for(String line : lines) {
            //Using ".toLowerCase" to make sure that even if the word has a capital, the index position is added to the list
            line.toLowerCase();
            if (line.contains(word.toLowerCase())) {
                indexPositions.add(i);
            }
            i++;
        }
        return indexPositions;
    }


    public static void main (String[] args) throws IOException{
        //Copying each line into its own element of an ArrayList
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null){
            lines.add(line);
        }
        br.close();

        //Using "searchWord" method to find word "programs"
        ArrayList<Integer> indexPositions = searchWord(lines,"programs");

        //Printing index values from returned arraylist
        for(int i = 0; i < indexPositions.size(); i++) {
            System.out.print(indexPositions.get(i)+"\n");
        }
    }
}