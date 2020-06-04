package br.com.mauriciorother.devventurefinal.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import br.com.mauriciorother.devventurefinal.adapter.PictureAdapter;
import br.com.mauriciorother.devventurefinal.databinding.ActivityMainBinding;
import br.com.mauriciorother.devventurefinal.model.Picture;
import br.com.mauriciorother.devventurefinal.viewmodel.PictureViewModel;

public class MainActivity extends AppCompatActivity {

    public static final int LAYOUT_COLUMNS = 4;

    private PictureAdapter adapter;
    private List<String> imagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding;
        PictureViewModel viewModel;

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(PictureViewModel.class);

        imagesList = new ArrayList<>();

        adapter = new PictureAdapter(imagesList);
        binding.recyclerview.setLayoutManager(new GridLayoutManager(this, LAYOUT_COLUMNS));
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setAdapter(adapter);

        viewModel.getPictureData().observe(this, picture -> {
            if (picture != null) {
                for (Picture.Data pictureData : picture.getData()) {
                    for (Picture.Images pictureImages : pictureData.getImages()) {
                        imagesList.add(pictureImages.getLink());
                    }
                }
            }
            adapter.notifyDataSetChanged();
        });

        setContentView(binding.getRoot());
    }
}