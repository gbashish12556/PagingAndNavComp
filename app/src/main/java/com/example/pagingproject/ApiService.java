package com.example.pagingproject;

import com.example.pagingproject.pojo.StackResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("answers")
    Call<StackResponse> getResponse(
            @Query("page") int page, @Query("pagesize") int sort,@Query("site") String site
    );
}
