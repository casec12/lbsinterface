package with_prototype.lbsinterface.core;

import java.util.Map;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public interface RequestTransfer {
    Map<String, String> transRequestParam(LBSBean bean);
}
