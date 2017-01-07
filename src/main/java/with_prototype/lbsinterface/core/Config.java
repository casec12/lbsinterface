package with_prototype.lbsinterface.core;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public class Config {
    private String interfaceName;
    private String requestTransferName;
    private String responseTranferName;
    private String communicatorName;
    private String url;
    private String callerName;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getRequestTransferName() {
        return requestTransferName;
    }

    public void setRequestTransferName(String requestTransferName) {
        this.requestTransferName = requestTransferName;
    }

    public String getResponseTranferName() {
        return responseTranferName;
    }

    public void setResponseTranferName(String responseTranferName) {
        this.responseTranferName = responseTranferName;
    }

    public String getCommunicatorName() {
        return communicatorName;
    }

    public void setCommunicatorName(String communicatorName) {
        this.communicatorName = communicatorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public Config(){};

    public Config(String interfaceName,
                  String requestTransferName,
                  String responseTranferName,
                  String communicatorName,
                  String url,
                  String callerName
    ){
        this.requestTransferName = requestTransferName;
        this.responseTranferName = responseTranferName;
        this.communicatorName = communicatorName;
        this.url = url;
        this.callerName = callerName;
    }
}
