package com.route.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartItem(
    val product: Product? = null,
    val price: Int? = null,
    val count: Int? = null,
    val id: String? = null,
) : Parcelable
