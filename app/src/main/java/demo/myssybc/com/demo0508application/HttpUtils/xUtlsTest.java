package demo.myssybc.com.demo0508application.HttpUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class xUtlsTest {
    public static void xutilsGet(String url, Callback.CommonCallback<String> callback) {
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, callback);
    }
}
