package com.sgt.it.ookbeequiz.service;

import com.sgt.it.ookbeequiz.dao.BookRequest;
import com.sgt.it.ookbeequiz.dao.BookResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @POST("user/{userId}/books")
    Call<List<BookResponse>> saveBook(@Path("userId") String userId,
                                      @Body BookRequest bookRequest);

}
