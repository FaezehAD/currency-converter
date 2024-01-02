package com.example.p4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val DOLLAR_US_EXCHANGE_RATE = 356950.0
const val DOLLAR_CANADA_EXCHANGE_RATE = 268200.0
const val EURO_EXCHANGE_RATE = 374760.0
const val POUND_EXCHANGE_RATE = 438080.0
const val DIRHAM_EXCHANGE_RATE = 97400.0


class CurrencyViewModel : ViewModel() {

    private val _currentRial = MutableLiveData<Double>()
    val currentRial: MutableLiveData<Double>
        get() = _currentRial

    private val _currentDollarUS = MutableLiveData<Double>()
    val currentDollarUS: MutableLiveData<Double>
        get() = _currentDollarUS

    private val _currentDollarCanada = MutableLiveData<Double>()
    val currentDollarCanada: MutableLiveData<Double>
        get() = _currentDollarCanada

    private val _currentPound = MutableLiveData<Double>()
    val currentPound: MutableLiveData<Double>
        get() = _currentPound

    private val _currentEuro = MutableLiveData<Double>()
    val currentEuro: MutableLiveData<Double>
        get() = _currentEuro

    private val _currentDirham = MutableLiveData<Double>()
    val currentDirham: MutableLiveData<Double>
        get() = _currentDirham


    fun reinitializeData() {
        _currentRial.value = 0.0
        _currentDollarUS.value = 0.0
        _currentDollarCanada.value = 0.0
        _currentPound.value = 0.0
        _currentEuro.value = 0.0
        _currentDirham.value = 0.0
    }


    fun rialHasChanged(currRial: Double) {
        _currentDollarUS.value = currRial * (1 / DOLLAR_US_EXCHANGE_RATE)
        _currentDollarCanada.value = currRial * (1 / DOLLAR_CANADA_EXCHANGE_RATE)
        _currentEuro.value = currRial * (1 / EURO_EXCHANGE_RATE)
        _currentPound.value = currRial * (1 / POUND_EXCHANGE_RATE)
        _currentDirham.value = currRial * (1 / DIRHAM_EXCHANGE_RATE)
    }

    fun dollarUSHasChanged(currDollarUS: Double): Double {
        _currentRial.value = currDollarUS * DOLLAR_US_EXCHANGE_RATE
        return currDollarUS * DOLLAR_US_EXCHANGE_RATE
    }

    fun dollarCanadaHasChanged(currDollarCanada: Double): Double {
        _currentRial.value = currDollarCanada * DOLLAR_CANADA_EXCHANGE_RATE
        return currDollarCanada * DOLLAR_CANADA_EXCHANGE_RATE
    }

    fun euroHasChanged(currEuro: Double): Double {
        _currentRial.value = currEuro * EURO_EXCHANGE_RATE
        return currEuro * EURO_EXCHANGE_RATE
    }

    fun poundHasChanged(currPound: Double): Double {
        _currentRial.value = currPound * POUND_EXCHANGE_RATE
        return currPound * POUND_EXCHANGE_RATE
    }

    fun dirhamHasChanged(currDirham: Double): Double {
        _currentRial.value = currDirham * DIRHAM_EXCHANGE_RATE
        return currDirham * DIRHAM_EXCHANGE_RATE
    }

}