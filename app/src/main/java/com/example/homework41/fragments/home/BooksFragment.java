package com.example.homework41.fragments.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homework41.Adapter.BookAdapter;
import com.example.homework41.Model.BooksModel;
import com.example.homework41.R;
import com.example.homework41.databinding.FragmentHomeBinding;
import com.example.homework41.fragments.details.DetailFragment;
import com.example.homework41.utils.OnItemClickListener;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;


public class BooksFragment extends Fragment {
    FragmentHomeBinding binding;
    BooksViewModel viewModel;
    BookAdapter adapter = new BookAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupListener();
        setupObserve();
        onItemClick();
    }

    private void setupObserve() {
        viewModel.books.observe(getViewLifecycleOwner(), booksModels -> {
            adapter.addBook(booksModels);
        });
    }

    private void setupListener() {
        binding.btnFill.setOnClickListener(v -> {
            binding.btnFill.setVisibility(View.GONE);
            binding.rvBooks.setVisibility(View.VISIBLE);
            viewModel.addBook();
        });

    }

    private void onItemClick() {
        adapter.onClick(booksModel -> {
            viewModel.select(booksModel);
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.action_homeFragment_to_detailFragment );
        });
    }

    private void initialize() {
        binding.rvBooks.setAdapter(adapter);
        viewModel = new ViewModelProvider(requireActivity()).get(BooksViewModel.class);

    }
}