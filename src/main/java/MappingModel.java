import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingModel {

    private String name;
    private HashMap<String, String> mapping;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(HashMap<String, String> mapping) {
        this.mapping = mapping;
        Map<String, String> mapInversed =
                mapping.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        this.mapping.putAll(mapInversed);
    }

    @Override
    public String toString() {
        return "MappingModel{" +
                "name='" + name + '\'' +
                ", mapping=" + mapping +
                '}';
    }
}
