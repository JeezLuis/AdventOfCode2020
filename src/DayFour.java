import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayFour {

    public static void main(String[] args) {
        List<String> expenses = importExpenses();
        checkEntries(expenses);
    }

    public static List<String> importExpenses() {
        List<String> expenses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day4.txt"))) {
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

        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};
        String[] colors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

        int total_correct = 0;
        int correct_fields = 0;

        expenseList.add("");

        for (String s:expenseList) {
            if(s.isEmpty()){
                if (correct_fields >= 7){
                    total_correct++;
                }
                correct_fields = 0;
            }
            else{
                String[] tokens;
                tokens = s.split("[: ]+");
                for (int i = 0; i < tokens.length; i++) {
                    String token = tokens[i];



                    for (String field: fields) {

                        if(token.equals(field) && !token.equals("cid")){

                            switch (token){
                                case "byr":
                                    int byr = Integer.parseInt(tokens[i+1]);
                                    if (byr <= 2002 && byr >= 1920 && tokens[i+1].matches("^[0-9]*$")) correct_fields++;
                                    break;

                                case "iyr":
                                    int iyr = Integer.parseInt(tokens[i+1]);
                                    if (iyr <= 2020 && iyr >= 2010 && tokens[i+1].matches("^[0-9]*$")) correct_fields++;
                                    break;

                                case "eyr":
                                    int eyr = Integer.parseInt(tokens[i+1]);
                                    if (eyr <= 2030 && eyr >= 2020 && tokens[i+1].matches("^[0-9]*$")) correct_fields++;
                                    break;

                                case "hgt":

                                    int number;
                                    if(tokens[i+1].toLowerCase().indexOf("cm") != -1){
                                        tokens[i+1] = tokens[i+1].replaceAll("cm","");
                                        number = Integer.parseInt(tokens[i+1]);
                                        if (tokens[i+1].matches("^[0-9#]*$") &&  number >= 150 && number <= 193) correct_fields++;
                                    }
                                    else if(tokens[i+1].toLowerCase().indexOf("in") != -1){
                                        tokens[i+1] = tokens[i+1].replaceAll("in","");
                                        number = Integer.parseInt(tokens[i+1]);
                                        if (tokens[i+1].matches("^[0-9#]*$") &&  number >= 59 && number <= 76) correct_fields++;

                                    }
                                    break;

                                case "hcl":
                                    if (tokens[i+1].matches("^[a-zA-Z0-9#]*$") && tokens[i+1].charAt(0) == '#' && tokens[i+1].length() == 7) correct_fields++;
                                    break;

                                case "ecl":
                                    boolean existe= false;

                                    for (String color: colors) {
                                        if(tokens[i+1].equals(color)) existe = true;
                                    }

                                    if(existe) correct_fields++;
                                    break;

                                case "pid":
                                    if (tokens[i+1].matches("^[0-9#]*$") && tokens[i+1].length() == 9) correct_fields++;
                                    break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Correctes: "+ total_correct);
    }
}
