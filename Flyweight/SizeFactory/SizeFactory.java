package Flyweight.SizeFactory;


import java.util.HashMap;

public class SizeFactory {
    private static SizeFactory sizeFactory;
    private HashMap<Integer, Size> sizeMap;

    private SizeFactory() {
        this.sizeMap = new HashMap<>();
    }

    public static SizeFactory getSizeFactory() {
        if (sizeFactory == null) {
            sizeFactory = new SizeFactory();
        }
        return sizeFactory;
    }

    public Size getFont(Integer size) {
        if (!this.sizeMap.containsKey(size)) {
            this.sizeMap.put(size, new Size(size));
        }
        return this.sizeMap.get(size);
    }

    public HashMap<Integer, Size> getSizeMap() {
        return sizeMap;
    }
}
