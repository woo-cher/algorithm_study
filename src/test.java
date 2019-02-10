import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("a", 2);
        map.put("a", 4);
        map.put("a", 3);

        System.out.println(map.get("a"));
    }
}
