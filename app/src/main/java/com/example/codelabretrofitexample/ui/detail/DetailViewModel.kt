package com.example.codelabretrofitexample.ui.detail

import android.app.Application
import androidx.lifecycle.*
import com.example.codelabretrofitexample.model.MarsProperties
import com.example.codelabretrofitexample.R

class DetailViewModel(val marsProperty: MarsProperties, app: Application) : AndroidViewModel(app) {
    val _selectedProperty = MutableLiveData<MarsProperties>()
    val selectedProperty: LiveData<MarsProperties>
        get() = _selectedProperty

    init {
        _selectedProperty.value = marsProperty
    }

    val displyPropertyPrice = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
            when (it.isRental) {
                true -> R.string.display_monthly_rental
                false -> R.string.disply_price
            }, it.price
        )
    }
    val displaypropertytype = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
            when (it.isRental) {
                true -> R.string.type_rent
                false -> R.string.type_sale
            }
        )
    }
}