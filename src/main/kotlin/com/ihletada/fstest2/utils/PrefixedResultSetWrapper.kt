package com.ihletada.fstest2.utils

import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.SQLException

/**
 * Wrapper for ResultSet that strips a prefix from column names.
 * This allows reusing row mappers that expect unprefixed column names.
 */
class PrefixedResultSetWrapper(
    private val delegate: ResultSet,
    private val prefix: String
) : ResultSet by delegate {

    override fun getObject(columnLabel: String): Any? {
        return delegate.getObject(prefix + columnLabel)
    }

//    override fun getObject(columnLabel: String, type: Class<*>): Any? {
//        return delegate.getObject(prefix + columnLabel, type)
//    }

    override fun getString(columnLabel: String): String? {
        return delegate.getString(prefix + columnLabel)
    }

    override fun getLong(columnLabel: String): Long {
        return delegate.getLong(prefix + columnLabel)
    }

    override fun getDouble(columnLabel: String): Double {
        return delegate.getDouble(prefix + columnLabel)
    }

    override fun getTimestamp(columnLabel: String): java.sql.Timestamp? {
        return delegate.getTimestamp(prefix + columnLabel)
    }
}