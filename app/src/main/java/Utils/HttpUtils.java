package Utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/19.
 */

public class HttpUtils {

    private static volatile  HttpUtils instance;
    private  Api api;

    public static HttpUtils getInstance(){
        if(instance==null){
            synchronized (HttpUtils.class){
                if(null==instance){
                    instance=new HttpUtils();
                }
            }
        }
        return instance;
    }


    public HttpUtils(){
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://gank.io/api/")
                .client(new OkHttpClient.Builder().build())
                .build();
        api=retrofit.create(Api.class);

    }
    public Api getApi(){
        return  api;
    }
}
