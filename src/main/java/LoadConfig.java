import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class LoadConfig {

    private HashMap<String, HashMap<String, String>> mappingDictionary;

    public LoadConfig(HashMap<String, HashMap<String, String>> categoriesMapperForward) {
        this.mappingDictionary = categoriesMapperForward;
    }

    public boolean loadConfig(final String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        Yaml yaml = new Yaml();
        try{

            InputStream in = new FileInputStream( classLoader.getResource(fileName).getFile() );
            MappingModel mappingDataDictionary = yaml.loadAs( in, MappingModel.class);
            mappingDictionary.put(mappingDataDictionary.getName(), mappingDataDictionary.getMapping());
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
