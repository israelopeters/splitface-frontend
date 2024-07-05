package com.northcoders.tatooine.ui.userprofileview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.tatooine.R;
import com.northcoders.tatooine.databinding.ActivityUserProfileViewBinding;
import com.northcoders.tatooine.model.Style;
import com.northcoders.tatooine.model.Tattoo;

import java.util.ArrayList;
import java.util.List;

public class UserProfileViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Tattoo> tattoos;
    private TattooAdapter adapter;
    private UserProfileViewModel viewModel;
    private ActivityUserProfileViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile_view);
        viewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);

        recyclerView = binding.recyclerViewOfPosts;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        tattoos = new ArrayList<>();
        adapter = new TattooAdapter(tattoos, this);
        recyclerView.setAdapter(adapter);

        getAllTattoos();
    }

    private void getAllTattoos() {
        viewModel.getAllTattoos().observe(this, new Observer<List<Tattoo>>() {
            @Override
            public void onChanged(List<Tattoo> tattoosFromLiveData) {
                tattoos.clear();
                if (tattoosFromLiveData != null) {
                    tattoos.addAll(tattoosFromLiveData);
                }
                List<Style> styles = List.of(new Style(1L, "REALISM"), new Style(2L, "FINE LINE"), new Style(3L, "WATERCOLOUR"));
                tattoos.add(new Tattoo(1L, "£1000", "", "3 hours", styles, "Now"));
                tattoos.add(new Tattoo(1L, "£100", "", "3 hours", styles, "Now"));
                adapter.notifyDataSetChanged();
            }
        });
    }
}
