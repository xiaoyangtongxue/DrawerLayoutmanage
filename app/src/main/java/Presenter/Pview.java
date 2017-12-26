package Presenter;

import bean.AndroidBean;
import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/12/19.
 */

public interface Pview {
    void getData(Flowable<AndroidBean>flowable,String tag);
}
