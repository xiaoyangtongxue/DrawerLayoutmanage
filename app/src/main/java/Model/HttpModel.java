package Model;


import java.util.Map;

import Presenter.Pview;
import Utils.HttpUtils;
import bean.AndroidBean;
import io.reactivex.Flowable;


/**
 * Created by xsj on 2017/12/14.
 */

public class HttpModel {
    private Pview pv;


    public HttpModel(Pview pv) {
        this.pv = pv;
    }


    public void getApi(Map<String,String> map, String tag){

        if(tag.equals("Android")){
            Flowable<AndroidBean> androidData = new HttpUtils().getApi().getAndroidData(map);
            pv.getData(androidData,tag);
        }

        if(tag.equals("IOS")){
            Flowable<AndroidBean> androidData = new HttpUtils().getApi().getIOSData(map);
            pv.getData(androidData,tag);
        }

        if(tag.equals("福利")){
            Flowable<AndroidBean> androidData = new HttpUtils().getApi().getFuLiData(map);
            pv.getData(androidData,tag);
        }

        if(tag.equals("瞎推荐")){
            Flowable<AndroidBean> androidBeanFlowable = new HttpUtils().getApi().gettuijianData(map);
            pv.getData(androidBeanFlowable,tag);
        }
    }
}
