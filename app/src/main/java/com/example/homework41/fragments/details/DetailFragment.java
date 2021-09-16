package com.example.homework41.fragments.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework41.Model.BooksModel;
import com.example.homework41.R;
import com.example.homework41.databinding.FragmentDetailBinding;
import com.example.homework41.fragments.home.BooksViewModel;

import java.util.ArrayList;

public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;
    BooksViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        openPosition();
    }

    private void openPosition() {
        viewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<BooksModel>() {
            @Override
            public void onChanged(BooksModel booksModel) {
                binding.txtName.setText(booksModel.getTitle());
                binding.itemImage.setImageResource(booksModel.getImage());
                binding.txtDescription.setText(booksModel.getDescription());
            }
        });
    }


    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(BooksViewModel.class);

    }
}