package with_prototype.lbsinterface.core;

/**
 * Created by chenzhaolei on 2016/12/25.
 */

/**
 * 接口调用方法，传一个LBSBean，返回一个LBSBean，通过CallerBuilder+Config，构建Caller
 */
public abstract class LBSCaller {
    private RequestTransfer requestTransfer;
    private ResponseTransfer responseTransfer;
    private Communicator communicator;
    private Config config;

    protected RequestTransfer getRequestTransfer() {
        return requestTransfer;
    }

    protected void setRequestTransfer(RequestTransfer requestTransfer) {
        this.requestTransfer = requestTransfer;
    }

    protected ResponseTransfer getResponseTransfer() {
        return responseTransfer;
    }

    protected void setResponseTransfer(ResponseTransfer responseTransfer) {
        this.responseTransfer = responseTransfer;
    }

    protected Communicator getCommunicator() {
        return communicator;
    }

    protected Config getConfig() {
        return config;
    }

    protected void setConfig(Config config) {
        this.config = config;
    }

    protected void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    protected LBSCaller(RequestTransfer requestTransfer, ResponseTransfer responseTransfer, Communicator communicator, Config config) {
        this.requestTransfer = requestTransfer;
        this.responseTransfer = responseTransfer;
        this.communicator = communicator;
        this.config = config;
    }

    public abstract LBSBean call(LBSBean bean);
}
