package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bwie.drawerlayoutmanager.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import bean.AndroidBean;

/**
 * Created by xsj on 2017/12/17.
 */

public class FuliAdapter extends RecyclerView.Adapter<FuliAdapter.ViewHolder>{

    private List<AndroidBean.ResultsBean> list ;
    private Context context;

    public FuliAdapter(List<AndroidBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.androiditem, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(context).load(list.get(position).getUrl()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder{

        private  ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);

        }
    }
}
