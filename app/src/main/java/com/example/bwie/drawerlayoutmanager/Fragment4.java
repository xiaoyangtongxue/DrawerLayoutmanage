package com.example.bwie.drawerlayoutmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

import InView.Iview;
import Presenter.HttpPresenter;
import adapter.AndroidAdapter;
import adapter.FuliAdapter;
import bean.AndroidBean;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment4 extends Fragment implements Iview, XRecyclerView.LoadingListener {

    private HttpPresenter presenter;
    AndroidAdapter adapter;
    private XRecyclerView xRecyclerView;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment4,null);
        unbinder = ButterKnife.bind(this, view);
        xRecyclerView=view.findViewById(R.id.xrecy);
       presenter=new HttpPresenter(this);

        HashMap<String, String> map = new HashMap<>();
        presenter.getMap(map,"福利");


        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);
        //xRecyclerView.setAdapter(adapter);
      xRecyclerView.setLoadingListener(this);
        return  view;
    }

    @Override
    public void OnSuccess(Object o, String tag) {
          if(tag.equals("福利")){
              AndroidBean androidBean = (AndroidBean) o;
              final List<AndroidBean.ResultsBean> results = androidBean.getResults();

              xRecyclerView.setAdapter(new FuliAdapter(results,getActivity()));
          }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.distach();
    }

    @Override
    public void onRefresh() {
        xRecyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {

    }
}
