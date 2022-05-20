package com.example.finalproject.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "countries"
)
data class Countries(
    @SerializedName("Country")
    var country: String,
    @SerializedName("Slug")
    var slug: String,
    @SerializedName("ISO2")
    var iso2: String,
): Serializable
