package com.example.my.android_paging3_retrofit2_mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.my.android_paging3_retrofit2_mvvm.adapter.CharacterAdapter
import com.example.my.android_paging3_retrofit2_mvvm.databinding.ActivityMainBinding
import com.example.my.android_paging3_retrofit2_mvvm.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var characterAdapter: CharacterAdapter
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {

        characterAdapter = CharacterAdapter()

        binding.recyclerView.apply {
            adapter = characterAdapter
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }
    }

    private fun loadData() {
        lifecycleScope.launch {
            viewModel.listData.collect {

                Log.d("aaa", "load: $it")
                characterAdapter.submitData(it)
            }
        }
    }

}