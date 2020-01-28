import java.util.HashMap;
import java.util.Optional;

class OptionalMap extends HashMap {
    OptionalMap(Character c, Integer i) {
        super(c, i);
    }

    Optional getOptional(Character k) {
        return Optional.ofNullable(k);
    }
}
