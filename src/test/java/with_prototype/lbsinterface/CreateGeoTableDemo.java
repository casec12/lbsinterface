package with_prototype.lbsinterface;

import with_prototype.lbsinterface.communicator.BaiduCommunicator;
import with_prototype.lbsinterface.core.*;
import with_prototype.lbsinterface.lbsbean.GEOTable;
import with_prototype.lbsinterface.transfer.CreateGeoTableRequestTransfer;
import with_prototype.lbsinterface.transfer.CreateGeoTableResponseTransfer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public class CreateGeoTableDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        GEOTable table = new GEOTable();
        table.setTableName("test_table6");
        table.setTableType(3);
        table.setIsPublished(1);
        table.setAk("p4rvcLNEgM4ZmlOAWYIpg9xyn3dH9yOV");

        List<Config> configList = ConfigBuilder.getConfigs();

        for(Config config : configList){
            if("BaiduCreateTable".equals(config.getInterfaceName())){
                LBSCaller lbsCaller = CallerBuilder.build(config);
                LBSBean responseBean = lbsCaller.call(table);
                System.out.println(responseBean);
            }
        }

    }

    public LBSBean createGeoTable(String url, GEOTable table) {
        RequestTransfer requestTransfer = new CreateGeoTableRequestTransfer();
        ResponseTransfer responseTransfer = new CreateGeoTableResponseTransfer();
        Communicator communicator = new BaiduCommunicator();

        Map<String, String> params = requestTransfer.transRequestParam(table);
        String responseString = (String) communicator.sendPost(url, params);
        LBSBean responseBean = responseTransfer.transResponse(responseString);

        return responseBean;
    }
}
