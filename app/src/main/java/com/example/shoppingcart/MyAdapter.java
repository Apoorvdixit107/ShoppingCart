package com.example.shoppingcart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
List<Product> products;
TextView rateview;
    public MyAdapter(List<Product> products,TextView rateview) {
    this.products=products;
    this.rateview=rateview;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
holder.tv1.setText(String.valueOf(products.get(position).getPid()));
holder.tv2.setText(String.valueOf(products.get(position).getPname()));
holder.tv3.setText(String.valueOf(products.get(position).getPrice()));
holder.tv4.setText(String.valueOf(products.get(position).getQty()));
holder.btn.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v) {
        DataBase db = Room.databaseBuilder(holder.tv1.getContext(),
                DataBase.class, "cart-database").allowMainThreadQueries().build();
        ProductDao productDao = db.ProductDao();
        productDao.deletebyid(products.get(position).getPid());
products.remove(position);
notifyItemRemoved(position);
updateprice();

    }
});


    }

    private void updateprice() {
        int sum=0,i;
        for(i=0;i<products.size();i++){
            sum+=products.get(i).getPrice()*products.get(i).getQty();
            rateview.setText("Total Ammount: INR"+sum);
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
TextView tv1,tv2,tv3,tv4;
ImageButton btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        tv1=itemView.findViewById(R.id.textView);
            tv2=itemView.findViewById(R.id.textView2);
            tv3=itemView.findViewById(R.id.textView3);
            tv4=itemView.findViewById(R.id.textView4);
            btn=itemView.findViewById(R.id.button3);

        }
    }
}
