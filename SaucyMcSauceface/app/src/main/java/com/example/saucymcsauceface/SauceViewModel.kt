package com.example.saucymcsauceface

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.UUID

class SauceViewModel: ViewModel() {
    var sauceItems = MutableLiveData<MutableList<SauceItem>>()

    init {
        sauceItems.value = mutableListOf()
    }

    fun addSauceItem(newSauce: SauceItem) {
        val list = sauceItems.value
        list!!.add(newSauce)
        sauceItems.postValue(list)
    }

    fun updateSauceItem(id: UUID, name: String, code: Int, source: String, group: String, authors: List<String>, tags: List<String>) {
        val list = sauceItems.value
        val sauce = list!!.find {it.id == id}!!
        sauce.name = name
        sauce.code = code
        sauce.source = source
        sauce.group = group
        sauce.authors = authors
        sauce.tags = tags
        sauceItems.postValue(list)
    }

    fun toggleCompleted(sauceItem: SauceItem) {
        val list = sauceItems.value
        val sauce = list!!.find{it.id == sauceItem.id}
        sauce!!.complete = !sauce.complete
    }
}