import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Mission {
    private int id;
    private String Avenger_name;
    private Stone group;
    private String Aufgabe;
    private Schwierigkeit difficulty;
    private int Punkte;
    private boolean Erfolg;

    public Mission(String dataString) {
        String[] data=dataString.split("#",7);
        List<String> lines= Arrays.asList(data);
        this.id=Integer.parseInt(lines.get(0));
        this.Avenger_name=lines.get(1);
        this.group = Stone.valueOf(lines.get(2));
        this.Aufgabe=lines.get(3);
        this.difficulty=Schwierigkeit.valueOf(lines.get(4));
        this.Punkte=Integer.parseInt(lines.get(5));
        this.Erfolg= Objects.equals(lines.get(6),"win");
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", Avenger_name='" + Avenger_name + '\'' +
                ", group=" + group +
                ", Aufgabe='" + Aufgabe + '\'' +
                ", difficulty=" + difficulty +
                ", Punkte=" + Punkte +
                ", Erfolg=" + Erfolg +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvenger_name() {
        return Avenger_name;
    }

    public void setAvenger_name(String avenger_name) {
        Avenger_name = avenger_name;
    }

    public Stone getGroup() {
        return group;
    }

    public void setGroup(Stone Stone) {
        this.group = Stone;
    }

    public String getAufgabe() {
        return Aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        Aufgabe = aufgabe;
    }

    public Schwierigkeit getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Schwierigkeit difficulty) {
        this.difficulty = difficulty;
    }

    public int getPunkte() {
        return Punkte;
    }

    public void setPunkte(int punkte) {
        Punkte = punkte;
    }

    public boolean isErfolg() {
        return Erfolg;
    }

    public void setErfolg(boolean erfolg) {
        Erfolg = erfolg;
    }

    public Mission(int id, String avenger_name, Stone group, String aufgabe, Schwierigkeit difficulty, int punkte, boolean erfolg) {
        this.id = id;
        Avenger_name = avenger_name;
        this.group = group;
        Aufgabe = aufgabe;
        this.difficulty = difficulty;
        Punkte = punkte;
        Erfolg = erfolg;
    }
}
