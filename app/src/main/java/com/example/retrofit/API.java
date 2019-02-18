package com.example.retrofit;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @GET("posts")
    Call<List<Post>> getPosts();
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @POST("register")
    Call<Token> AddUser(@Body User user);
}
