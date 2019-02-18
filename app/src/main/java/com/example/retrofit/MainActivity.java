package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

public class MainActivity extends AppCompatActivity {
    TextView text;
    API api;
    private static final String url = "https://jsonplaceholder.typicode.com/";
    private static final String ur2 = "http://water.sitksahost.com/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ur2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
        // getPosts();
        //createPost();
        try {
            addUser();
        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void addUser() {
        User user = new User("ahmed", "ramadan", "anna@sas.com", "2130212", "sdsdsdfd", 01200101201, 1029101291, 5, 4, 5, 15);
        Call<Token> call = api.AddUser(user);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful()) {
                    text.setText("" + response.code());
                    Token token = response.body();
                    String content = " ";
                    content += token.getError();
                    /*content += "code : " + token.getCode() + "\n";
                    content += "token : " + token.getToken() + "\n";*/
                    text.setText(content);
                } else {
                    // error case
                    switch (response.code()) {
                        case 401:
                            text.setText(" "+response.errorBody());
                            Toast.makeText(MainActivity.this, "401", Toast.LENGTH_SHORT).show();
                            break;
                        case 404:
                            Toast.makeText(MainActivity.this, "not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(MainActivity.this, "server broken", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(MainActivity.this, "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });
    }

    private void createPost() {
        Post post = new Post(16, "new Title", "new Body");
        Call<Post> call = api.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    text.setText(response.code());
                    return;
                }
                Post post1 = response.body();
                String content = "";
                content += "code : " + response.code() + "\n";
                content += "title :" + post1.getTitle() + "\n";
                content += "id :" + post1.getId() + "\n";
                content += "userId :" + post1.getUserId() + "\n";
                content += "body :" + post1.getText() + "\n\n";
                text.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });
    }

    private void getPosts() {
        Call<List<Post>> call = api.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    text.setText(response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                    String content = "";
                    content += "code : " + response.code() + "\n";
                    content += "title :" + post.getTitle() + "\n";
                    content += "id :" + post.getId() + "\n";
                    content += "userId :" + post.getUserId() + "\n";
                    content += "body :" + post.getText() + "\n\n";
                    text.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });
    }

}
