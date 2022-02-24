package com.example.basicapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        //Response response = new Response();
      //  Response txt = txt.getData().toString();

    }
        @OnClick(R.id.btn)
    public void onButtonClicked() {
          //  String btn1 = btn.getText().toString().trim();
          //  String txt1 = txt.getText().toString().trim();

            IMethods methods = RetrofitClient.getRetrofitInstance().create(IMethods.class);
            Call<Response1>call = methods.getAllData();
            call.enqueue(new Callback<Response1>() {
                @Override
                public void onResponse(Call <Response1>call, Response <Response1>response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "API SUCCESSFULL", Toast.LENGTH_SHORT).show();
                        Log.i("response", String.valueOf(response.body().getPage()));
                    } else {
                        Toast.makeText(MainActivity.this, "API ERROR", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                }

            });

        }

    }
