package com.william.week4retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.william.week4retrofit.adapter.CompanyAdapter
import com.william.week4retrofit.adapter.GenreAdapter
import com.william.week4retrofit.databinding.ActivityMovieDetailBinding
import com.william.week4retrofit.helper.Const
import com.william.week4retrofit.viewmodel.MoviesViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetail : AppCompatActivity() {

    private lateinit var binding : ActivityMovieDetailBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var genreadapter : GenreAdapter
    private lateinit var prodcompadapter : CompanyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getIntExtra("movie_id",0)
        Toast.makeText(applicationContext, "Movie ID : ${movieId}", Toast.LENGTH_SHORT).show()

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getMovieDetails(movieId,Const.API_KEY)

        binding.progressBar.visibility = View.VISIBLE

        viewModel.movieDetails.observe(this) { response ->



                binding.tvTitleMovieDetail.apply {
                    text = response.title

                    Glide.with(applicationContext)
                        .load(Const.IMG_URL + response.backdrop_path)
                        .into(binding.imgPosterMovieDetail)
                }

            binding.tvOverview.apply{
                text=response.overview
            }
            binding.rvGenre.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            genreadapter = GenreAdapter(response.genres)
            binding.rvGenre.adapter = genreadapter

            binding.rvCompanyLogo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            prodcompadapter = CompanyAdapter(response.production_companies)
            binding.rvCompanyLogo.adapter = prodcompadapter

            binding.progressBar.visibility = View.INVISIBLE

        }

    }
}