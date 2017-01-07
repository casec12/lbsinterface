package with_prototype.lbsinterface.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by chenzhaolei on 2016/12/25.
 */
public class CallerBuilder {
    private static RequestTransfer buildRequestTransfer(Config config) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (RequestTransfer)Class.forName(config.getRequestTransferName()).newInstance();
    }

    private static ResponseTransfer buildResponseTransfer(Config config) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (ResponseTransfer)Class.forName(config.getResponseTranferName()).newInstance();
    }

    private static Communicator buildCommunicator(Config config) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Communicator)Class.forName(config.getCommunicatorName()).newInstance();
    }

    private static LBSCaller createCaller(RequestTransfer requestTransfer, ResponseTransfer responseTransfer, Communicator communicator, Config config) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = Class.forName(config.getCallerName()).getConstructor(RequestTransfer.class, ResponseTransfer.class, Communicator.class, Config.class);
        LBSCaller lbsCaller = (LBSCaller) constructor.newInstance(requestTransfer, responseTransfer, communicator, config);
        return lbsCaller;
    }

    public static LBSCaller build(Config config) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        RequestTransfer requestTransfer = buildRequestTransfer(config);
        ResponseTransfer responseTransfer = buildResponseTransfer(config);
        Communicator communicator = buildCommunicator(config);

        LBSCaller lbsCaller = createCaller(requestTransfer, responseTransfer, communicator, config);
        lbsCaller.setRequestTransfer(requestTransfer);
        lbsCaller.setResponseTransfer(responseTransfer);
        lbsCaller.setCommunicator(communicator);
        lbsCaller.setConfig(config);

        return lbsCaller;
    }
}
