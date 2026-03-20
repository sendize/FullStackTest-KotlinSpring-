package com.ihletada.fullstackapp.controllers.view

import com.ihletada.fullstackapp.database.model.Product
import com.ihletada.fullstackapp.database.repository.ProductRepository
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/products")
class ProductController(
    private val productRepository: ProductRepository
) {

    @GetMapping("")
    fun products() = "products"  // Add this

    @GetMapping("/list")
    fun listProducts(model: Model): String {
        val products = productRepository.fetchWithVariants()
        model.addAttribute("products", products)
        return "fragments/fragment-products :: products-table"
    }

    @PostMapping("/add")
    fun addProduct(
        @RequestParam title: String,
        @RequestParam bodyHTML: String,
        @RequestParam productType: String,
        @RequestParam imageUrl: String,
        model: Model,
        response: HttpServletResponse
    ): String {
        val product = Product(
            title = title,
            bodyHTML = bodyHTML,
            productType = productType,
            imageUrl = imageUrl
        )

        productRepository.save(product)

        // Reload the products list
        val products = productRepository.fetchWithVariants()
        model.addAttribute("products", products)

//        response.addHeader("HX-Trigger", "productAdded")
        return "fragments/fragment-products :: products-table"
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String, model: Model): String {
        productRepository.delete(id)

        // Reload the products list
        val products = productRepository.fetchWithVariants()
        model.addAttribute("products", products)
        return "fragments/fragment-products :: products-table"
    }
}