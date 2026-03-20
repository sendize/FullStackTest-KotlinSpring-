package com.ihletada.fstest2.database.row_mappers

import com.ihletada.fstest2.database.model.ProductVariant
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.UUID

class ProductVariantRowMapper : RowMapper<ProductVariant> {
    override fun mapRow(rs: ResultSet, rowNum: Int): ProductVariant {
        return ProductVariant(
            productInternalId = rs.getObject("product_internal_id") as UUID?,
            internalId = rs.getObject("internal_id") as UUID,
            externalId = rs.getLong("external_id"),
            sku = rs.getString("sku"),
            title = rs.getString("title"),
            price = rs.getDouble("price"),
            color = rs.getString("color"),
            size = rs.getString("size"),
            imageUrl = rs.getString("image_url"),
            createdAt = rs.getTimestamp("created_at").toLocalDateTime(),
            modifiedAt = rs.getTimestamp("modified_at").toLocalDateTime()
        )
    }
}