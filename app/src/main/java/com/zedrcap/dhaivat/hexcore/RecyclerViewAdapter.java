package com.zedrcap.dhaivat.hexcore;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<trading> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<trading> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        trading trade = MainImageUploadInfoList.get(position);

        holder.month.setText(trade.getMonth());
        holder.day.setText(trade.getDay());
        holder.var.setText(trade.getVar());
        holder.stockname.setText(trade.getStockname());
        //holder.time.setText(trade.getTime());
        holder.buyprice.setText(trade.getBuyprice());
        holder.buytp.setText(trade.getBuytp());
        holder.buysl.setText(trade.getBuysl());
        holder.sellprice.setText(trade.getSellprice());
        holder.selltp.setText(trade.getSelltp());
        holder.sellsl.setText(trade.getSellsl());

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView month;
        public TextView day;
        public TextView var;
        public TextView stockname;
        //public TextView time;
        public TextView buyprice;
        public TextView buytp;
        public TextView buysl;
        public TextView sellprice;
        public TextView selltp;
        public TextView sellsl;

        public ViewHolder(View itemView) {

            super(itemView);

            month = (TextView) itemView.findViewById(R.id.month);
            day = (TextView) itemView.findViewById(R.id.day);
            var = (TextView) itemView.findViewById(R.id.var);
            stockname = (TextView) itemView.findViewById(R.id.stockname);
            //time = (TextView) itemView.findViewById(R.id.time);
            buyprice = (TextView) itemView.findViewById(R.id.buyprice);
            buytp = (TextView) itemView.findViewById(R.id.buytp);
            buysl = (TextView) itemView.findViewById(R.id.buysl);
            sellprice = (TextView) itemView.findViewById(R.id.sellprice);
            selltp = (TextView) itemView.findViewById(R.id.selltp);
            sellsl = (TextView) itemView.findViewById(R.id.sellsl);
        }
    }
}