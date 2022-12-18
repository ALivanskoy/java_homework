import java.util.LinkedHashMap;
import java.util.Map;

public class Laptop {

    private String manufacturer, os, collor, ram, memory;
    private int id;
    private static int counter = 1;

    public Laptop(String manufacturer, String os, String collor, String ram, String memory) {

        this.manufacturer = manufacturer;
        this.os = os;
        this.collor = collor;
        this.ram = ram;
        this.memory = memory;
        this.id = counter;
        counter += 1;

    }

    public Map toMap() {

        Map<String, Object> laptopMap = new LinkedHashMap<>();

        laptopMap.put("id", this.id);
        laptopMap.put("manufacturer", this.manufacturer);
        laptopMap.put("os", this.os);
        laptopMap.put("collor", this.collor);
        laptopMap.put("ram", this.ram);
        laptopMap.put("memory", this.memory);

        return laptopMap;
    }

    @Override
    public String toString() {
        return this.toMap().toString();

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    
}
