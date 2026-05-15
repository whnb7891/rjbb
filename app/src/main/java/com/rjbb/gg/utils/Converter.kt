package com.rjbb.gg.utils

object Converter {
    fun intToHex(value: Int): String {
        return "0x" + Integer.toHexString(value).uppercase()
    }

    fun hexToInt(hex: String): Int? {
        return try {
            hex.removePrefix("0x").removePrefix("0X")
                .toInt(16)
        } catch (e: Exception) {
            null
        }
    }

    fun longToHex(value: Long): String {
        return "0x" + java.lang.Long.toHexString(value).uppercase()
    }

    fun hexToLong(hex: String): Long? {
        return try {
            hex.removePrefix("0x").removePrefix("0X")
                .toLong(16)
        } catch (e: Exception) {
            null
        }
    }
}