package com.inonitylab.workwithretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://uatapi.emanbd.com/api/";

    EditText name,email, password;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        password= (EditText) findViewById(R.id.password);
        save = (Button) findViewById(R.id.save);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpClient client = new OkHttpClient();
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

               /* final Student student = new Student();
                student.setName(name.getText().toString());
                student.setEmail(email.getText().toString());
                student.setPassword(password.getText().toString());*/

               User user = new User();
                user.setMobile("01712345678");
                user.setPassword("password");

/*                //creating retrofit instance
*/                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
 /*               HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);

                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(logging);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();*/

                ApiService service = retrofit.create(ApiService.class);
                Log.d("test", "onClick: ............................ "+new Gson().toJson(user));

                Call<LoginResponse> call = service.createUser(user);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Log.d("MainActivity", "...........................onResponse: " +response.raw());
                        name.setText("");
                        email.setText("");
                        password.setText("");
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                        Log.i("onFailure","................ "+throwable);
                    }
                });

            }
        });
    }
}
