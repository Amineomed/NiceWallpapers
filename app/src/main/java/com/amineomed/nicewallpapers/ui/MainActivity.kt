package com.amineomed.nicewallpapers.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.amineomed.nicewallpapers.R
import com.amineomed.nicewallpapers.data.remote.Resource
import com.amineomed.nicewallpapers.databinding.ActivityMainBinding
import com.amineomed.nicewallpapers.ui.photos.PhotosViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

     lateinit var viewModel: PhotosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[PhotosViewModel::class.java]
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as  NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
        test()
    }

    private fun test(){
        viewModel.randomPhotos.observe(this, Observer {res ->
            when(res){
                is Resource.Success -> {
                    res.data?.let {
                        Log.e("test",res.data[0].urls.full)
                    }
                }
                is Resource.Error -> {
                    res.message?.let {
                        Log.e("test",it)
                    }
                }
            }
        })
    }

}