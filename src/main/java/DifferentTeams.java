import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DifferentTeams {

    /*
     * Complete the function below.
     */
    static int differentTeams(String skills) {
        final String team = "pcmbz";
        final String skillsPattern = "[" + team + "]{5,500000}";

        if (skills == null || !skills.matches(skillsPattern)) {
            throw new IllegalArgumentException("Skills string is not valid!");
        }

        final Map<Character, Integer> skillToCount = new HashMap<>();

        for (char skill : skills.toCharArray()) {
            skillToCount.compute(skill, (key, value) -> value == null ? 1 : value + 1);
        }

        if (skillToCount.size() != team.length()) {
            return 0;
        }

        return Collections.min(skillToCount.values());
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        String skills;
        try {
            skills = in.nextLine();
        } catch (Exception e) {
            skills = null;
        }

        res = differentTeams(skills);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

}