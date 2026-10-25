package com.example.roomdem

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProductRepository(private val productDao: ProductDao) {

    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    fun insertProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            productDao.insertProduct(product)
        }
    }

    fun deleteProduct(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            productDao.deleteProduct(name)
        }
    }

    fun findProduct(name: String): Deferred<List<Product>> {
        return CoroutineScope(Dispatchers.IO).async {
            productDao.findProduct(name)
        }
    }
}
