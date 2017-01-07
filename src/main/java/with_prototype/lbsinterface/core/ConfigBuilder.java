package with_prototype.lbsinterface.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by chenzhaolei on 2017/1/7.
 */
public class ConfigBuilder {
    private static Properties properties;
    private static List<Config> configs;

    public static List<Config> getConfigs() throws IOException {
        if(configs != null){
            return configs;
        }
        load();
        return JSON.parseObject(getConfigJSON(), new TypeReference<List<Config>>(){});
    }

    private static void load() throws IOException {
        properties = new Properties();
        properties.load( new ConfigBuilder().getClass().getResourceAsStream("/config.properties"));
    }

    private static String getConfigJSON() throws IOException {
        String configFile = properties.getProperty("impl_config");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new ConfigBuilder().getClass().getResourceAsStream(configFile)
                ));
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while((line = bufferedReader.readLine()) !=null){
            stringBuffer.append(line);
        };
        return stringBuffer.toString();
    }
}
