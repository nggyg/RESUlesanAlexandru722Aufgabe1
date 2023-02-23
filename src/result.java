import java.util.Objects;

public class result implements Comparable<result>{
    private String Avenger;
    private int Punkte;

    public result(String avenger, int punkte) {
        Avenger = avenger;
        Punkte = punkte;
    }

    @Override
    public String toString() {
        return Avenger +"&" + Punkte;
    }

    @Override
    public int compareTo(result o) {
        return Integer.compare(o.Punkte, this.Punkte);
    }
}
