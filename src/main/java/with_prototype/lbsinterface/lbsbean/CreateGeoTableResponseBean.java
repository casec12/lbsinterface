package with_prototype.lbsinterface.lbsbean;

import with_prototype.lbsinterface.core.LBSBean;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public class CreateGeoTableResponseBean extends LBSBean{
    private int status;
    private String message;
    private String id;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("status:"+this.status+"\n");
        stringBuffer.append("message:"+this.message+"\n");
        stringBuffer.append("id:"+this.id+"\n");
        return stringBuffer.toString();
    }
}
