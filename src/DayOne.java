import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayOne {

    public static void main(String[] args) {
        List<List<String>> expenses = importExpenses();
        checkEntries(expenses);
    }

    public static List<List<String>> importExpenses() {
        List<List<String>> expenses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day1.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\n");
                expenses.add(Arrays.asList(values));
            }
        }
        catch(Exception e) {

        }


        return expenses;
    }

    public static void checkEntries(List<List<String>> expenseList) {
        List<List<String>> expenses = expenseList;
        for (int i = 0; i < expenses.size(); i++) {
            int x = Integer.parseInt(expenses.get(i).get(0));
            for (int k = 0; k < expenses.size(); k++) {
                int z = Integer.parseInt(expenses.get(k).get(0));
                for (int j = 0; j < expenses.size(); j++) {
                    if (i != j && i != k) {
                        int y = Integer.parseInt(expenses.get(j).get(0));
                        int sum = x + y + z;
                        if (sum == 2020) {
                                System.out.println("Entry " + (i + 1) + ", " + x + " and entry " + (j + 1) + " equal 2020 and multiply to equal: " + (x * y * z));
                        }
                    }
                }
            }
        }
    }
}