package with_prototype.lbsinterface.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzhaolei on 2016/12/25.
 */
public class ConfigXmlBean {
    List<Config> configs = new ArrayList<Config>();

    public List<Config> getConfigs() {
        return configs;
    }

    public void setConfigs(List<Config> configs) {
        this.configs = configs;
    }
}
