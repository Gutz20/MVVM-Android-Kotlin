package com.optic.paqta.presentation.screens.ubication

import androidx.lifecycle.ViewModel
import com.optic.paqta.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UbicationViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {



}