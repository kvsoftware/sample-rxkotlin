package com.kvsoftware.rxkotlin.transforming.groupby

data class PetDataModel(val name: String, val type: String) {
    companion object {
        const val TYPE_DOG = "dog"
        const val TYPE_CAT = "cat"
    }
}