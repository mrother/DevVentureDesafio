package br.com.mauriciorother.devventurefinal.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import br.com.mauriciorother.devventurefinal.model.Picture;
import br.com.mauriciorother.devventurefinal.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PictureViewModel extends ViewModel {

    private static final String TAG = "PictureViewModel";

    private RetrofitConfig retrofitConfig = new RetrofitConfig();
    private MutableLiveData<Picture> pictureData = new MutableLiveData<>();

    public MutableLiveData<Picture> getPictureData() {
        Call<Picture> fetchPics = retrofitConfig
                .getFetchPhotosAPI()
                .getPictures("cats", "jpg");

        fetchPics.enqueue(new Callback<Picture>() {
            @Override
            public void onResponse(Call<Picture> call, Response<Picture> response) {
                if (response.body() != null) {
                    pictureData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Picture> call, Throwable t) {
                Log.e(TAG, "Error fetching data." + t.getMessage());
            }
        });
        return pictureData;
    }
}
