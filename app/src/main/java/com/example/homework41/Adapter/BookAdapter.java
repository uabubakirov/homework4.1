package com.example.homework41.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework41.Model.BooksModel;
import com.example.homework41.databinding.BookItemsBinding;
import com.example.homework41.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    ArrayList<BooksModel> list = new ArrayList<>();
    OnItemClickListener onItemClickListener;

    public void addBook(ArrayList<BooksModel> book) {
        list = book;
        notifyDataSetChanged();
    }
    public void onClick(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(BookItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        BookItemsBinding binding;

        public ViewHolder(BookItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
        public void onBind(BooksModel s) {
            binding.txtName.setText(s.getTitle());
            binding.itemImage.setImageResource(s.getImage());
            binding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onClick(s);
            });
        }
    }
}
