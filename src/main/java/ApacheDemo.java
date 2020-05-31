import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.map.LinkedMap;

public class ApacheDemo {
    public static void main(String[] args) {

        System.out.println("BidiMap");
        BidiMap<String, Integer> map = new DualHashBidiMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map.get("one"));
        BidiMap<Integer, String> map2 = map.inverseBidiMap();
        System.out.println(map2.get(2));

        System.out.println("Bag");
        Bag <String>bag = new HashBag();
        bag.add("Hello", 6);
        bag.add("Hi", 2);
        bag.remove("Hello", 2);
        System.out.println(bag.getCount("Hello"));
        System.out.println(bag.uniqueSet());

        System.out.println("Ordered Map");
        OrderedMap<String, String> map1 = new LinkedMap();
        map1.put("one", "1");
        map1.put("two", "2");
        map1.put("three", "3");
        System.out.println(map1.firstKey());
        System.out.println(map1.nextKey("one"));
        System.out.println(map1.lastKey());
    }
}
