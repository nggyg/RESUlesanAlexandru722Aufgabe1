import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //a
        File file = new File("avengers.txt");
        Scanner scan = new Scanner(file);
        List<Mission> missions = new ArrayList<Mission>();
        String dataLine;
        while (scan.hasNextLine()) {
            dataLine = scan.nextLine();
            missions.add(new Mission(dataLine));
        }
        scan.close();
        /*for(Mission m:missions){
            System.out.println(m);
        }*/
        //b
        missions.stream().filter(mission -> mission.getGroup() == Stone.Space).sorted(Comparator.comparing(Mission::getDifficulty)).forEach(mission -> System.out.println(mission.getAufgabe()/* + " "+ t.getDifficulty()*/));
        System.out.println();
        //c
        List<String> AvengersNames = new ArrayList<String>();
        missions.stream().filter(Mission::isErfolg).forEach(mission -> AvengersNames.add(mission.getAvenger_name()));
        AvengersNames.stream().distinct().sorted().forEach(mission -> System.out.println(mission));
        //d

        List<String> AvengerNames2 = new ArrayList<String>();
        missions.forEach(mission -> AvengerNames2.add(mission.getAvenger_name()));
        List<result> results = new ArrayList<result>();
        int score;
        for (String Av : AvengerNames2.stream().distinct().toList()) {
            score = 0;
            for (Mission m : missions) {
                if (Objects.equals(m.getAvenger_name(), Av)) {
                    if (m.isErfolg())
                        score += m.getPunkte();
                    else
                        score -= m.getPunkte();
                }
            }
            results.add(new result(Av, score));
        }
        FileWriter resultfile = new FileWriter("result.txt");
        //resultfile.write("test");
        results.stream().sorted().forEach(mission -> {
            try {
                resultfile.write(mission.toString() + '\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        resultfile.close();
    }
}