package com.route.data.repositories

import com.route.data.contract.CartOnlineDataSource
import com.route.data.toFlow
import com.route.domain.common.Resource
import com.route.domain.contract.CartRepository
import com.route.domain.models.Cart
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepositoryImpl
    @Inject
    constructor(private val cartOnlineDataSource: CartOnlineDataSource) :
    CartRepository {
        override suspend fun addProductToCart(
            token: String,
            productId: String,
        ): Flow<Resource<Cart?>> {
            return toFlow { cartOnlineDataSource.addProductToCart(token, productId) }
        }

        override suspend fun updateCartProductQuantity(
            token: String,
            cartProductId: String,
            productCount: String,
        ): Flow<Resource<Cart?>> {
            return toFlow {
                cartOnlineDataSource.updateCartProductQuantity(
                    token,
                    cartProductId,
                    productCount,
                )
            }
        }

        override suspend fun getLoggedUserCart(token: String): Flow<Resource<Cart?>> {
            return toFlow { cartOnlineDataSource.getLoggedUserCart(token) }
        }

        override suspend fun removeSpecificCartItem(
            token: String,
            cartProductId: String,
        ): Flow<Resource<Cart?>> {
            return toFlow { cartOnlineDataSource.removeSpecificCartItem(token, cartProductId) }
        }
    }