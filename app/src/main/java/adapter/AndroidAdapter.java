package adapter;

import android.content.Context;
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

public class AndroidAdapter extends XRecyclerView.Adapter<AndroidAdapter.ViewHolder>{

    private List<AndroidBean.ResultsBean> list ;
    private Context context;

    public AndroidAdapter(List<AndroidBean.ResultsBean> list, Context context) {
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
        final List<String> images = list.get(position).getImages();
//        if(images!=null){
//            holder.img.setImageURI(images.get(0).toString());
//        }else{
//            holder.img.setImageURI(Uri.parse("res://com.example.xsj.shipei.Adapters/" + R.mipmap.ic_launcher));
//        }
        Glide.with(context).load(list.get(position).getImages()).into(holder.img);
//        holder.title.setText(list.get(position).getDesc());
//        holder.name.setText(list.get(position).getWho());
//        holder.time.setText(list.get(position).getPublishedAt());


    }

    @Override
    public int getItemCount() {
        if(list==null){
            return 0;
        }
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder{

//        private final SimpleDraweeView img;
//        private final TextView title,name,time;
//        private final LinearLayout linear1;
           ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
  img=(ImageView)itemView.findViewById(R.id.img);
//            img = (SimpleDraweeView) itemView.findViewById(R.id.sdv_head_image);
//            title = (TextView) itemView.findViewById(R.id.title);
//            name = (TextView) itemView.findViewById(R.id.name);
//            time = (TextView) itemView.findViewById(R.id.time);
//            linear1 = (LinearLayout) itemView.findViewById(R.id.linear1);

        }
    }
}
