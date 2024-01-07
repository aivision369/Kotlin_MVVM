package com.vision.cleancare.view.base

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vision.cleancare.R
import com.vision.cleancare.databinding.ActivityMainBinding
import com.vision.cleancare.network.ContextViewModelFactory
import com.vision.cleancare.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    lateinit var viewModel: MainViewModel

    //private val adapter = MovieAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        observer();
    }

    private fun initViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(
            this, ContextViewModelFactory(
                this@MainActivity, mainRepository
            )
        )[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun observer() {
        viewModel.getAllMovies()
        viewModel.errorMessage.observe(this, {
            Log.e("errorMessage", "Error :: $it" )
        })

        viewModel.loading.observe(this, Observer {
            if (it) {
                Log.e("loading", "Started......")
            } else {
                Log.e("loading", "completed......")
            }
        })

        viewModel.movieList.observe(this, {
            Log.e("movieList", "movieList : -> ${it.string().toString()}")
        })
    }
}