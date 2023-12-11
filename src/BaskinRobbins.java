import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaskinRobbins {
    private static final Map<Integer,Integer> map = new HashMap<>();

    static int findCombinations(int num){

        //base-case
        if (num == 0 || num == 1){
            return 1;
        }

        return findCombinations(num - 1) + findCombinations(num - 2);

    }

    public static void main(String[] args) {
        String filePath = "data_no_memoization.csv";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));


            for (int i = 1; i < 50; i++) {
                long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                long startTime = System.currentTimeMillis();

                System.out.println("Possible Combinations: " + findCombinations(i));

                long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                long memoryUsed = memoryAfter - memoryBefore;
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                writer.write(i + "," + elapsedTime + "," + memoryUsed);
                writer.newLine();
            }

            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }}


