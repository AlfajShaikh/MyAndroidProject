package com.example.companyproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{
    ArrayList<model> dataholder=new ArrayList<>();
      Context context;

    public myadapter(ArrayList<model> dataholder,Context context) {
        this.dataholder = dataholder;
        this.context=context;

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final  model temp=dataholder.get(position);
        holder.dname.setText(dataholder.get(position).getName());
        holder.dcontact.setText(dataholder.get(position).getContact());
        holder.demail.setText(dataholder.get(position).getEmail());
        
        holder.demail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile=holder.demail.getText().toString();
                String call="tel:"+mobile.trim();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(call));
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dname,dcontact,demail,line;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dname=(TextView)itemView.findViewById(R.id.displayname);
            dcontact=(TextView)itemView.findViewById(R.id.displaycontact);
            demail=(TextView)itemView.findViewById(R.id.displayemail);


        }
    }
}

