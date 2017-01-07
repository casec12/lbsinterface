package with_prototype.lbsinterface.communicator;

import with_prototype.lbsinterface.core.Communicator;
import with_prototype.lbsinterface.othertools.UrlConnHttpTools;
import with_prototype.lbsinterface.othertools.UrlConnHttpToolsResponse;

import java.util.Map;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public class BaiduCommunicator implements Communicator {
    public Object sendPost(String url) {
        return null;
    }

    public Object sendPost(String url, Map<String, String> param) {
        UrlConnHttpToolsResponse response = new UrlConnHttpTools().sendRequest(url,param,"UTF-8");
        return response.getResponseString();
    }

    public Object sendGet(String url) {
        return null;
    }

    public Object sendGet(String url, Map<String, String> params) {
        return null;
    }
}
