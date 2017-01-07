package with_prototype.lbsinterface.transfer;

import with_prototype.lbsinterface.core.LBSBean;
import with_prototype.lbsinterface.core.RequestTransfer;
import with_prototype.lbsinterface.lbsbean.GEOTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public class CreateGeoTableRequestTransfer implements RequestTransfer {
    public Map<String, String> transRequestParam(LBSBean lbsBean) {
        GEOTable table = (GEOTable) lbsBean;
        Map<String,String> params = new HashMap<String,String>();
        params.put("name",table.getTableName());
        params.put("geotype",String.valueOf(table.getTableType()));
        params.put("is_published",String.valueOf(table.getIsPublished()));
        params.put("ak",table.getAk());
        return params;
    }
}
