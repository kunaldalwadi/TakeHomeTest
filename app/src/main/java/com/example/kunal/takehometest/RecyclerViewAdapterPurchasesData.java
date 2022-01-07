package com.example.kunal.takehometest;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kunal.takehometest.databinding.OneRowPurchasesBinding;

import java.util.List;

public class RecyclerViewAdapterPurchasesData extends RecyclerView.Adapter<RecyclerViewAdapterPurchasesData.RecyclerViewHolderPurchasesData> {

    private List<Purchases> purchasesList;
    private Context context;

    public RecyclerViewAdapterPurchasesData(List<Purchases> purchasesList, Context context) {
        this.purchasesList = purchasesList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolderPurchasesData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolderPurchasesData(OneRowPurchasesBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderPurchasesData holder, int position) {

        Glide.with(context).load(purchasesList.get(position).getImage()).centerCrop().placeholder(R.drawable.loading).into(holder.oneRowPurchasesBinding.ivPic);
        holder.oneRowPurchasesBinding.tvProductName.setText(purchasesList.get(position).getItem_name());
        holder.oneRowPurchasesBinding.tvPurchaseDate.setText(Utils.formatDate(purchasesList.get(position).getPurchase_date()));
        holder.oneRowPurchasesBinding.tvSerialNumber.setText("Serial: " + purchasesList.get(position).getSerial());
        holder.oneRowPurchasesBinding.tvDescription.setText("Description: " + purchasesList.get(position).getDescription());
        holder.oneRowPurchasesBinding.tvPrice.setText(purchasesList.get(position).getPrice());

        holder.oneRowPurchasesBinding.llWholerow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.oneRowPurchasesBinding.tvDescription.getVisibility() == View.GONE)
                {
                    holder.oneRowPurchasesBinding.tvSerialNumber.setVisibility(View.VISIBLE);
                    holder.oneRowPurchasesBinding.tvDescription.setVisibility(View.VISIBLE);
                }
                else if (holder.oneRowPurchasesBinding.tvDescription.getVisibility() == View.VISIBLE)
                {
                    holder.oneRowPurchasesBinding.tvSerialNumber.setVisibility(View.GONE);
                    holder.oneRowPurchasesBinding.tvDescription.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return purchasesList.size();
    }

    public class RecyclerViewHolderPurchasesData extends RecyclerView.ViewHolder{

        private OneRowPurchasesBinding oneRowPurchasesBinding;

        public RecyclerViewHolderPurchasesData(@NonNull OneRowPurchasesBinding oneRowPurchasesBinding) {
            super(oneRowPurchasesBinding.getRoot());

            this.oneRowPurchasesBinding = oneRowPurchasesBinding;
        }

    }
}
