package com.ihletada.fstest2

import com.ihletada.fstest2.database.model.ProductVariant
import com.ihletada.fstest2.database.repository.ProductVariantRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration


@SpringBootTest
@ContextConfiguration(classes = [TestConfig::class])
class ProductVariantRepositoryTest {
    @Autowired
    lateinit var productVariantRepository: ProductVariantRepository

    val knownExistingVariantId = "019d00cb-db42-7d6b-a9e7-a6f335b1fffe"

    @Test
    fun testSave() {
        val productId = "019cff8a-960c-79a9-94b1-1a6d45378ca7"

        val productVariant = ProductVariant(
            productInternalId = java.util.UUID.fromString(productId),
            externalId = 123456789,
            sku = "Test Variant",
            title = "Test Variant",
            price = 123.45,
            color = "Red",
            size = "M",
            imageUrl = "https://example.com/image.jpg"
        )

        val variant = productVariantRepository.save(productVariant)
        println(variant)
    }

    @Test
    fun testFetchById() {
        val variantId = java.util.UUID.fromString(knownExistingVariantId)
        val variant = productVariantRepository.fetchByInternalId(variantId)
        println(variant)
    }

    @Test
    fun testUpdate() {
        val variantId = java.util.UUID.fromString(knownExistingVariantId)
        val variant = productVariantRepository.fetchByInternalId(variantId)

        val newVariant = variant!!.copy(title = "Updated Variant")
        val updated = productVariantRepository.update(newVariant)
        println(updated)
    }

    @Test
    fun testDelete() {
        val variantId = java.util.UUID.fromString(knownExistingVariantId)
        val deleted = productVariantRepository.delete(variantId)
        println(deleted)
    }
}