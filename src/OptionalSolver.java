import java.util.HashMap;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class OptionalSolver {
    private HashMap<Character, Integer> countMap;

    OptionalSolver(String str) {
        countMap = new HashMap<>();
        String mostCommon = buildMap(str).toString();
        Logger lggr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        lggr.log(Level.INFO, mostCommon);
        lggr.log(Level.INFO, "{0}", !countMap.isEmpty() ? countMap.toString() : "No data");
    }

    private Optional<Character> buildMap(String s) {
        Optional<Integer> charCount;
        int maxCount = 0;
        Optional<Character> mostOftenChar = Optional.empty();
        for (Character c : s.toCharArray()) {
            charCount = Optional.ofNullable(countMap.get(c));
            if (charCount.isPresent()) {
                Integer updatedValue = charCount.get() + 1;
                countMap.put(c, updatedValue);
                if (updatedValue > maxCount) {
                    mostOftenChar = Optional.of(c);
                    maxCount = updatedValue;
                }
            } else {
                countMap.put(c, 1);
            }
        }

        return mostOftenChar;
    }
}
