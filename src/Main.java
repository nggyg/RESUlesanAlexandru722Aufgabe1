import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("avengers.txt");
        Scanner scan=new Scanner(file);
        List<Mission> missions=new ArrayList<Mission>();
        String dataLine;
        while(scan.hasNextLine()){
            dataLine=scan.nextLine();
            missions.add(new Mission(dataLine));
        }
        for(Mission m:missions){
            System.out.println(m);
        }
    }
}