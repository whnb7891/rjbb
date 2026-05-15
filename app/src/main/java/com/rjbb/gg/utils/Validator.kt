package com.rjbb.gg.utils

object Validator {
    fun isValidAddress(address: Long): Boolean {
        return address > 0
    }

    fun isValidValue(value: String, dataType: String): Boolean {
        return when (dataType) {
            "INT" -> value.toIntOrNull() != null
            "LONG" -> value.toLongOrNull() != null
            "FLOAT" -> value.toFloatOrNull() != null
            "DOUBLE" -> value.toDoubleOrNull() != null
            "TEXT" -> value.isNotEmpty()
            else -> false
        }
    }

    fun isValidDataType(dataType: String): Boolean {
        return dataType in listOf("INT", "LONG", "FLOAT", "DOUBLE", "TEXT")
    }
}