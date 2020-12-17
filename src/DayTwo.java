import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwo {

    public static void main(String[] args) {
        List<String> expenses = importExpenses();
        checkEntries(expenses);
    }

    public static List<String> importExpenses() {
        List<String> expenses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day2.txt"))) {
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
        int total_correctes = 0;


        for (String s:expenseList) {

            boolean pos1 = false;
            boolean pos2 = false;

            String[] tokens = s.split("[\\-: ]+");
            int min = Integer.parseInt(tokens[0]);
            int max = Integer.parseInt(tokens[1]);
            char caracter = tokens[2].charAt(0);
            String password = tokens[3];

            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                if (i+1 == min && password.charAt(i) == caracter) pos1 = true;
                if (i+1 == max && password.charAt(i) == caracter) pos2 = true;
            }

            if(pos1 ^ pos2) total_correctes++;

        }

        System.out.println("Total Correctes: "+total_correctes);
    }
}