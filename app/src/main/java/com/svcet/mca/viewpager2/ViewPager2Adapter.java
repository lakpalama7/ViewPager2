package com.svcet.mca.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.MyViewHolder> {

    private ViewPager2 viewPager2;
    private LayoutInflater inflater;
    private List<String> listdata;
    private int [] bgcolor={android.R.color.holo_blue_bright,android.R.color.background_light,android.R.color.darker_gray,android.R.color.holo_orange_dark};
    public ViewPager2Adapter(List<String> listdata, Context context, ViewPager2 viewPager2){
        this.inflater=LayoutInflater.from(context);
        this.listdata=listdata;
        this.viewPager2=viewPager2;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.single_page_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(listdata.get(position));
        holder.relativeLayout.setBackgroundColor(bgcolor[position]);

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout relativeLayout;
        Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.title);
            relativeLayout=itemView.findViewById(R.id.container);
            button=itemView.findViewById(R.id.btn);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(viewPager2.getOrientation()==ViewPager2.ORIENTATION_HORIZONTAL){
                        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                    }
                    else {
                        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                    }
                }
            });

        }
    }
}
