package com.sgt.it.ookbeequiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.sgt.it.ookbeequiz.dao.BookRequest;
import com.sgt.it.ookbeequiz.dao.BookResponse;
import com.sgt.it.ookbeequiz.service.APIService;
import com.sgt.it.ookbeequiz.service.RetrofitManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    int[] numbers = {1, 8, 2, 6, 5, 3, 5, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.text);

        tv.setText(String.valueOf(isOverlapped("20210420", "20210423", "20210422", "20210427")));
        tv.setText(String.valueOf(isOverlapped("", "20210416", "20210417", "20210418")));

        tv.setText(Arrays.toString(getMaxTwo(numbers)));

        BookRequest request = new BookRequest();
        request.setBookId(1);
        request.setBookName("Joylada");
        request.setBookAuthor("Ookbee");
        request.setBookPrice(5000.50);
        saveBook(request);

    }

    @SuppressLint("SimpleDateFormat")
    boolean isOverlapped(String start1, String end1, String start2, String end2) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date startDate1 = dateFormat.parse(start1);
            Date endDate1 = dateFormat.parse(end1);
            Date startDate2 = dateFormat.parse(start2);
            Date endDate2 = dateFormat.parse(end2);

            if (startDate1 != null && startDate2 != null)
                return startDate1.before(endDate2) && startDate2.before(endDate1);
            else
                return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    int[] getMaxTwo(int[] numbers) {
        int maximum = 0;
        int nearlyMaximum = 0;

        for (int number : numbers) {
            if (number > maximum) {
                maximum = number;
            } else if (number > nearlyMaximum) {
                nearlyMaximum = number;
            }
        }

        return new int[]{maximum, nearlyMaximum};
    }

    void saveBook(BookRequest book) {
        APIService service = RetrofitManager.getInstance().getRetrofit().create(APIService.class);
        Call<List<BookResponse>> call = service.saveBook("userId01", book);
        call.enqueue(new Callback<List<BookResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<BookResponse>> call
                    , @NonNull Response<List<BookResponse>> response) {

                if (response.isSuccessful()) {
                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<BookResponse>> call, @NonNull Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}