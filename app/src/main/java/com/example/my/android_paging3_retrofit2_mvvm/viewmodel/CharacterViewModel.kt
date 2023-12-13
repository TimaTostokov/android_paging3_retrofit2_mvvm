package com.example.my.android_paging3_retrofit2_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.my.android_paging3_retrofit2_mvvm.api.ApiService
import com.example.my.android_paging3_retrofit2_mvvm.paging.RickyMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
@Inject
constructor(private val apiService: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        RickyMortyPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)

}