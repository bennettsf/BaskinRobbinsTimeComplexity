import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaskinRobbinsMemoization {
    private static final Map<Integer,Integer> map = new HashMap<>();

    static int findCombinations(int num){

        //base-case
        if (num == 0 || num == 1){
            return 1;
        }
        // if there's no key for the current num, place one in the map containing the current recursive call
        if (!map.containsKey(num)) {
            map.put(num, findCombinations(num - 1) + findCombinations(num - 2));
        }
        // return the current recursive call from the map
        return map.get(num);

    }

    public static void main(String[] args) {
        String filePath = "data_yes_memoization.csv";

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



