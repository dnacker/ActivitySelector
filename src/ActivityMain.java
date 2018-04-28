import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivityMain {
    public static void main(String[] args) {
        List<ActivitySelector> problems = readFile("act.txt");
        int probNumber = 1;
        for (ActivitySelector s: problems) {
            System.out.println("Set " + probNumber);
            s.printResults();
            probNumber++;
            System.out.println();
        }
    }

    public static List<ActivitySelector> readFile(String fileName) {
        List<ActivitySelector> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String l = br.readLine();
            while (l != null) {
                int numAct = Integer.parseInt(l);
                List<Activity> aList = new ArrayList<>();
                for (int i = 0; i < numAct; i++) {
                    String[] line = br.readLine().split(" ");
                    int[] nums = new int[line.length];
                    for (int j = 0; j < line.length; j++) {
                        nums[j] = Integer.parseInt(line[j]);
                    }
                    aList.add(new Activity(nums[0], nums[1], nums[2]));
                }
                list.add(new ActivitySelector(aList));
                l = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        return list;
    }
}
