package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CardContent(
    var id:Long,
    var image: Int,
    var title: String,
    var subtitle: String,
): Parcelable