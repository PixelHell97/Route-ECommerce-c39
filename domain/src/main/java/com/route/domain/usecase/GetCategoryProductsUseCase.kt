package com.route.domain.usecase

import com.route.domain.common.Resource
import com.route.domain.contract.products.ProductsRepository
import com.route.domain.models.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository,
) {
    suspend fun invoke(categoryId: String): Flow<Resource<List<Product>?>> {
        return productsRepository.getCategoryProducts(categoryId)
    }
}