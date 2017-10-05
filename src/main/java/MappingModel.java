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
        this.mapping.putAll(generateBackward(mapping));
    }

    private Map<String, String> generateBackward(HashMap<String, String> mapping) {
        return mapping.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    }

    @Override
    public String toString() {
        return "MappingModel{" +
                "name='" + name + '\'' +
                ", mapping=" + mapping +
                '}';
    }
}
