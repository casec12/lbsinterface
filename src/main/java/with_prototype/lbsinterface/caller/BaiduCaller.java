package with_prototype.lbsinterface.caller;

import with_prototype.lbsinterface.core.Config;
import with_prototype.lbsinterface.core.*;

import java.util.Map;

/**
 * Created by chenzhaolei on 2016/12/25.
 */
public class BaiduCaller extends LBSCaller {

    public BaiduCaller(RequestTransfer requestTransfer, ResponseTransfer responseTransfer, Communicator communicator, Config config) {
        super(requestTransfer, responseTransfer, communicator, config);
    }

    @Override
    public LBSBean call(LBSBean bean) {
        Map<String, String> params = this.getRequestTransfer().transRequestParam(bean);
        String responseString = (String) this.getCommunicator().sendPost(this.getConfig().getUrl(), params);
        return this.getResponseTransfer().transResponse(responseString);
    }
}
