import java.util.*;

public class Doughnut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hight = sc.nextInt();
        int width = sc.nextInt();
        sc.nextLine();
        String[] map = new String[hight];

        Scanning_line Scan = new Scanning_line(hight, width);
        for (int i = 0; i < hight; i++) {
            Scan.Mapping(sc.nextLine(), i);
        }

        int total = Scan.Counter();

        System.out.println(total);
    }
}

class Scanning_line {

    private int data_hight;
    private int data_width;
    private String[][] data;

    public Scanning_line(int hight, int width) {
        this.data_hight = hight;
        this.data_width = width;
        this.data = new String[data_hight][data_width];
    }

    public void Mapping(String input, int high) {
        String[] line = input.split("");
        for (int j = 0; j < data_width; j++) {
            data[high][j] = line[j];
        }
    }

    public int Counter() {
        int counter = 0;
        for (int i = 0; i < data_hight - 2; i++) {
            for (int j = 0; j < data_width - 2; j++) {
                if (data[i][j].equals("#") && data[i][j + 1].equals("#") && data[i][j + 2].equals("#")
                        && data[i + 1][j].equals("#") && data[i + 1][j + 1].equals(".")
                        && data[i + 1][j + 2].equals("#") && data[i + 2][j].equals("#")
                        && data[i + 2][j + 1].equals("#") && data[i + 2][j + 2].equals("#")) {
                    counter++;
                }
            }
        }
        return counter;
    }

}