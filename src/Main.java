import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File file=new File("avengers.txt");
        Scanner scan=new Scanner(file);
        List<Mission> missions=new ArrayList<Mission>();
        String dataLine;
        while(scan.hasNextLine()){
            dataLine=scan.nextLine();
            missions.add(new Mission(dataLine));
        }
        scan.close();
        //a
        /*for(Mission m:missions){
            System.out.println(m);
        }*/
        //b
        missions.stream().filter(t-> t.getGroup()==Stone.Space).sorted(Comparator.comparing(Mission::getDifficulty)).forEach(t -> System.out.println(t.getAufgabe()/* + " "+ t.getDifficulty()*/));
        //c
        List<String> AvengersNames= new ArrayList<String>();
        missions.stream().filter(Mission::isErfolg).forEach(t-> AvengersNames.add(t.getAvenger_name()));
        AvengersNames.stream().distinct().sorted().forEach(t-> System.out.println(t));
        //d

        List<String > AvengerNames2 = new ArrayList<String>();
        missions.forEach(t->AvengerNames2.add(t.getAvenger_name()));
        List<result> results=new ArrayList<result>();
        int score;
        for(String Av: AvengerNames2.stream().distinct().toList()){
            score=0;
            for(Mission m:missions){
                if(Objects.equals(m.getAvenger_name(), Av)){
                    if(m.isErfolg())
                        score+=m.getPunkte();
                    else
                        score-=m.getPunkte();
                }
            }
            results.add(new result(Av,score));
        }
        FileWriter resultfile=new FileWriter("result.txt");
        //resultfile.write("test");
        results.stream().sorted().forEach(t-> {
            try {
                resultfile.write(t.toString()+'\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        resultfile.close();
    }
}