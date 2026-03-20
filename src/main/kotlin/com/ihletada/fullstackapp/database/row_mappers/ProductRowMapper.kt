package com.ihletada.fullstackapp.database.row_mappers

import com.ihletada.fullstackapp.database.model.Product
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.UUID

class ProductRowMapper : RowMapper<Product> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Product {
        return Product(
            internalId = rs.getObject("internal_id") as UUID,
            externalId = rs.getLong("external_id"),
            title = rs.getString("title"),
            bodyHTML = rs.getString("body_html"),
            productType = rs.getString("product_type"),
            imageUrl = rs.getString("image_url"),
            createdAt = rs.getTimestamp("created_at").toLocalDateTime(),
            modifiedAt = rs.getTimestamp("modified_at").toLocalDateTime()
        )
    }
}