package with_prototype.lbsinterface.transfer;

import com.alibaba.fastjson.JSON;
import with_prototype.lbsinterface.core.LBSBean;
import with_prototype.lbsinterface.core.ResponseTransfer;
import with_prototype.lbsinterface.lbsbean.CreateGeoTableResponseBean;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public class CreateGeoTableResponseTransfer implements ResponseTransfer {
    public LBSBean transResponse(String response) {
        CreateGeoTableResponseBean responseBean = JSON.parseObject(response, CreateGeoTableResponseBean.class);
        return responseBean;
    }
}
