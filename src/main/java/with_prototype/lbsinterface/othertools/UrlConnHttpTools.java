package with_prototype.lbsinterface.othertools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class UrlConnHttpTools
{
    public UrlConnHttpTools getInstance(){
        return new UrlConnHttpTools();
    }

    /**
     * 发送请求
     * @param url	 请求地址
     * @param params form表单参数
     * @param encode 字节流编码
     * @return
     */
    public UrlConnHttpToolsResponse sendRequest(String url, Map<String, String> params, String encode)
    {
        setEncode(encode);
        prepareParams(params);
        return communicate(url);
    }

    String paramString = "";
    byte[] encodeParamBytes;
    int pramsCount = 0;
    private String encode = "";
    private int defaultBufferSize = 1024;

    private String getEncode()
    {
        return "".equals(encode) ? "UTF-8" : encode;
    }

    private void setEncode(String encode)
    {
        this.encode = encode;
    }

    private void prepareParams(Map<String, String> params)
    {
        String paramString = "";
        if (params != null && params.size() > 0)
        {
            int index = 0;
            for (String formKey : params.keySet())
            {
                String value = params.get(formKey);
                if ("".equals(paramString))
                {
                    paramString += formKey + "=" + value;
                } else
                {
                    paramString += "&" + formKey + "=" + value;
                }
            }
        }
        this.paramString = paramString;
        try
        {
            encodeParamBytes = paramString.getBytes(getEncode());
        } catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException(e.getCause());
        }
        this.pramsCount = params.size();
    }

    private UrlConnHttpToolsResponse communicate(String url)
    {
        UrlConnHttpToolsResponse response = null;
        HttpURLConnection urlConnection = null;
        try
        {
            // 创建链接
            urlConnection = createUrlConnection(url);
            // 以流的形式写给服务器
            sendRequest(urlConnection);
            // 读取服务器的返回流
            response = getResponse(urlConnection);
        } catch (IOException e)
        {
            throw new RuntimeException(e.getCause());
        } finally
        {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
        }
        return response;
    }

    private UrlConnHttpToolsResponse getResponse(HttpURLConnection urlConnection) throws IOException
    {
        UrlConnHttpToolsResponse response = null;
        InputStream contentStream = null;
        ByteArrayOutputStream baos = null;
        try
        {
            contentStream = urlConnection.getInputStream();
            byte[] buffer = new byte[defaultBufferSize];
            int len;
            baos = new ByteArrayOutputStream();
            while ((len = contentStream.read(buffer)) != -1)
            {
                baos.write(buffer, 0, len);
            }
            String responseString = baos.toString();
            int responseCode = urlConnection.getResponseCode();
            response = new UrlConnHttpToolsResponse(responseCode, responseString);
        } finally
        {
            if (contentStream != null)
            {
                contentStream.close();
            }
            if (baos != null)
            {
                baos.close();
            }
        }
        return response;
    }

    private void sendRequest(HttpURLConnection urlConnection) throws IOException
    {
        OutputStream outputStream = null;
        try
        {
            outputStream = urlConnection.getOutputStream();
            outputStream.write(encodeParamBytes);
            outputStream.flush();
        } finally
        {
            if (outputStream != null)
            {
                outputStream.close();
            }
        }
    }

    private HttpURLConnection createUrlConnection(String url)
            throws IOException, MalformedURLException, ProtocolException
    {
        HttpURLConnection urlConnection;
        urlConnection = (HttpURLConnection) new URL(url).openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setConnectTimeout(5 * 1000);
        // application/json 对象 args必须是json格式字符串
        // application/x-www-form-urlencoded->普通参数传递
        // args必须以"name="+URLEncoder.encode("中国","UTF-8")+"&password=12345"
        // 这种形式
        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + getEncode());
        urlConnection.setRequestProperty("Content-Length", String.valueOf(this.pramsCount));
        urlConnection.setRequestProperty("accept", "*/*");
        urlConnection.setRequestProperty("connection", "Keep-Alive"); // 维持长连接
        urlConnection.setRequestProperty("Charset", getEncode());
        urlConnection.setInstanceFollowRedirects(true); // 重定向
        urlConnection.setUseCaches(false); // 不允许缓存
        urlConnection.setDoOutput(true); // 默认false 允许向服务器写入数据
        urlConnection.setDoInput(true); // 默认true 允许从接收服务器数据
        urlConnection.connect();
        return urlConnection;
    }

}
