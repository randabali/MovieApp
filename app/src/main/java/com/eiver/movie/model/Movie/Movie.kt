package com.eiver.movie.model.Movie

import com.google.gson.annotations.SerializedName

/*
* Create by Randa {DATE}
*/

data class Movie(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("movie_poster") val moviePoster: String,
)

