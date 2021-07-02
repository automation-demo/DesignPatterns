package Selenium.DataLoads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {
public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
    //1.Convert json file content to Json String
    String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

    //2.Object Mapper class is used to map json string to hashmap
    ObjectMapper mapper = new ObjectMapper();
    List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {});
    return data;
}
}
