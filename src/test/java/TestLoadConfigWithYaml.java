import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TestLoadConfigWithYaml {

    @Test
    public void testLoadConfigFromYaml(){
        LoadConfig yamlTesting = new LoadConfig(new HashMap());
        Assert.assertTrue(yamlTesting.loadConfig("mapping.yaml"));
    }
}
