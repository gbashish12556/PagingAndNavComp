package com.example.pagingproject;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.pagingproject.pojo.Item;
import com.example.pagingproject.pojo.StackResponse;
import com.example.shadiproject.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Item> {


    public static final int FIRST_PAGE_KEY = 1;
    public static final int PAGE_SIZE = 50;
    public static final String SITE_NAME = "stackoverflow";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {
        RetrofitClient.Companion.getInstance().getApi().getResponse(FIRST_PAGE_KEY,PAGE_SIZE,SITE_NAME).enqueue(new Callback<StackResponse>() {
            @Override
            public void onResponse(Call<StackResponse> call, Response<StackResponse> response) {

                if(response.isSuccessful() && response.body() != null){
                    callback.onResult(response.body().getItems(),0, FIRST_PAGE_KEY+1);
                }
            }

            @Override
            public void onFailure(Call<StackResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final  LoadCallback<Integer, Item> callback) {
        RetrofitClient.Companion.getInstance().getApi().getResponse(params.key,PAGE_SIZE,SITE_NAME).enqueue(new Callback<StackResponse>() {
            @Override
            public void onResponse(Call<StackResponse> call, Response<StackResponse> response) {

                Integer key = (params.key  > 1) ? params.key-1 : null;

                if(response.isSuccessful() && response.body() != null){
                    callback.onResult(response.body().getItems(), key);
                }
            }

            @Override
            public void onFailure(Call<StackResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {

        RetrofitClient.Companion.getInstance().getApi().getResponse(params.key,PAGE_SIZE,SITE_NAME).enqueue(new Callback<StackResponse>() {
            @Override
            public void onResponse(Call<StackResponse> call, Response<StackResponse> response) {

                Integer key =response.body().getHasMore() ? params.key+11 : null;

                if(response.isSuccessful() && response.body() != null){
                    callback.onResult(response.body().getItems(), key);
                }
            }

            @Override
            public void onFailure(Call<StackResponse> call, Throwable t) {

            }
        });

    }

    public void fetchData(int pageNo, int pageSize, String siteName, LoadCallback<Integer, Item> callback){


    }
}
