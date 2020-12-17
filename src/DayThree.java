import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayThree {

    public static void main(String[] args) {
        List<String> expenses = importExpenses();
        checkEntries(expenses);
    }

    public static List<String> importExpenses() {
        List<String> expenses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day3.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                expenses.add(line);
            }
        }
        catch(Exception e) {

        }
        return expenses;
    }

    public static void checkEntries(List<String> expenseList) {
        long tree_count = 0;
        long result = 1;

        int i = 0;

        ArrayList<Slope> slopes = new ArrayList<>();
        slopes.add(new Slope(1,1));
        slopes.add(new Slope(3,1));
        slopes.add(new Slope(5,1));
        slopes.add(new Slope(7,1));
        slopes.add(new Slope(1,2));

        for (Slope slope: slopes) {

            System.out.println("\n\n\n\n\nNEW SLOPE H: "+slope.getHorizontal()+" V: "+slope.getVertical()+"\n\n\n\n\n");

            for (int j = 0; j < expenseList.size(); j = j + slope.getVertical()) {
                String s = expenseList.get(j);
                if (s.charAt(i) == '#') tree_count++;

                String str = s;
                str = str.substring(0, i)
                        + '0'
                        + str.substring(i + 1);
                System.out.println(str + " I: " + i + " J: "+j);

                i = i + slope.getHorizontal();

                if (i > s.length() - 1) i = i - s.length();

            }
            System.out.println();
            result = result * tree_count;
            tree_count = 0;
            i = 0;
        }
        System.out.println("Arbres: "+result);
    }
}

class Slope{
    private int horizontal;
    private int vertical;

    public Slope(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }
}