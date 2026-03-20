package com.ihletada.fullstackapp

import com.ihletada.fullstackapp.database.repository.ProductRepository
import com.ihletada.fullstackapp.tasks.ProductFetcher
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [TestConfig::class])
class ProductFetcherTest {

    @Autowired
    lateinit var productFetcher: ProductFetcher

    @Autowired
    lateinit var productRepository: ProductRepository

//    @MockitoBean
//    lateinit var productRepository: ProductRepository

    @Test
    fun testFetchJsonFromSite() {
        val products = productFetcher.fetchJsonFromSite()
//        assert(products is List<Product>)
    }

    @Test
    fun testFetchAll() {
        val products = productRepository.fetchWithVariants()
//        assert(products.isNotEmpty())
    }

    @Test
    fun testFetchById() {
        val products = productRepository.fetchByInternalId("019cff8a-960c-79a9-94b1-1a6d45378c27")
        println(products)
//        assert(products is Product)
    }
}