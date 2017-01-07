package with_prototype.lbsinterface.othertools;

/**
 * Created by chenzhaolei on 2016/12/24.
 */
public class UrlConnHttpToolsResponse {
    private int responseCode;
    private String responseString = "";

    public UrlConnHttpToolsResponse() {
    }

    public UrlConnHttpToolsResponse(int responseCode, String responseString) {
        this.responseCode = responseCode;
        this.responseString = responseString;
    }

    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
