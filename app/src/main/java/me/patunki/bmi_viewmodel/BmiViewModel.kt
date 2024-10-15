package me.patunki.bmi_viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class BmiViewModel : ViewModel() {

    var heightInput by mutableStateOf("")
        private set
    var weightInput by mutableStateOf("")
        private set
    var bmiResult by mutableStateOf(0.0)
        private set

    fun onHeightChange(newHeight: String) {
        heightInput = newHeight
        calculateBmi()
    }

    fun onWeightChange(newWeight: String) {
        weightInput = newWeight
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toFloatOrNull() ?: 0.0f
        bmiResult = if (weight > 0 && height > 0) (weight / (height * height)).toDouble() else 0.0
    }
}
