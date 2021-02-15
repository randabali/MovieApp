package com.eiver.movie.model.Trailer

import com.eiver.movie.model.Movie.GetMoviesResponse
import com.eiver.movie.model.Movie.Movie
import com.eiver.movie.model.Movie.MoviesRepository
import com.eiver.movie.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Create by Randa {DATE}
*/class TrailerRepository {
    private val api: Api

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }
    fun getTrailerMovies(
        page: Int = 1,
        onSuccess: (trailer: List<Trailer>) -> Unit,
        onError: () -> Unit
    ) {
        api.getTrailerMovies(page = page)
            .enqueue(object : Callback<GetTrailerResponse> {
                override fun onResponse(
                    call: Call<GetTrailerResponse>,
                    response: Response<GetTrailerResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.trailer)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetTrailerResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}