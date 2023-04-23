package com.optic.paqta.presentation.screens.detail_backpack

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.optic.paqta.domain.model.Backpack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailBackpackViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val data = savedStateHandle.get<String>("backpack")
    val backpack = Backpack.fromJson(data!!)

}