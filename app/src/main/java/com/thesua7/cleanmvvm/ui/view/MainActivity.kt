package com.thesua7.cleanmvvm.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.thesua7.cleanmvvm.R
import com.thesua7.cleanmvvm.databinding.ActivityMainBinding
import com.thesua7.cleanmvvm.ui.adapter.RickMortyAdapter
import com.thesua7.cleanmvvm.ui.viewmodel.RickMortyViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: RickMortyAdapter
    private val viewModel: RickMortyViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = RickMortyAdapter()

        binding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when {
                        it.isLoading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        it.fail.isNotBlank() -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this@MainActivity, it.fail, Toast.LENGTH_SHORT).show()

                        }

                        it.success.isNotEmpty() -> {
                            binding.progressBar.visibility = View.GONE
                            mAdapter.submitList(it.success)
                        }
                    }
                }
            }

        }


    }
}