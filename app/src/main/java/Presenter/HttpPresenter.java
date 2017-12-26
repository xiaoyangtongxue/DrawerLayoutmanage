package Presenter;

import java.util.Map;

import InView.Iview;
import Model.HttpModel;
import bean.AndroidBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Administrator on 2017/12/19.
 */

public class HttpPresenter implements Pview {

    private Iview iv;
    private DisposableSubscriber<AndroidBean>p1;
    public HttpPresenter(Iview iv){
        this.iv=iv;
    }

    public void getMap(Map<String,String>map,String tag){
        HttpModel httpModel=new HttpModel(this);
        httpModel.getApi(map,tag);
    }

    @Override
    public void getData(Flowable<AndroidBean> flowable, final String tag) {

        p1=flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<AndroidBean>() {
                    @Override
                    public void onNext(AndroidBean androidBean) {
                        iv.OnSuccess(androidBean,tag);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void distach(){
        if(iv!=null){
            iv=null;
        }
        if(p1!=null){
            if(p1.isDisposed()){
                p1.dispose();
            }
        }
    }
}
