package with_prototype.lbsinterface.core;

import java.util.Map;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public interface Communicator {
    Object sendPost(String url);

    Object sendPost(String url, Map<String, String> param);

    Object sendGet(String url);

    Object sendGet(String url, Map<String, String> params);
}
