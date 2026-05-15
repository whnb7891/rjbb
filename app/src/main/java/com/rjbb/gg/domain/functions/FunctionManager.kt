package com.rjbb.gg.domain.functions

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 自定义函数管理器
 * 管理用户定义的函数
 */
@Singleton
class FunctionManager @Inject constructor() {

    private val functions = mutableMapOf<String, CustomFunction>()

    /**
     * 注册函数
     */
    fun registerFunction(name: String, function: CustomFunction) {
        Timber.i("Registering function: $name")
        functions[name] = function
    }

    /**
     * 执行函数
     */
    suspend fun executeFunction(name: String, vararg args: Any?): Any? {
        val function = functions[name]
        if (function == null) {
            Timber.e("Function not found: $name")
            return null
        }
        return try {
            Timber.i("Executing function: $name")
            function.execute(*args)
        } catch (e: Exception) {
            Timber.e(e, "Error executing function: $name")
            null
        }
    }

    /**
     * 获取所有函数
     */
    fun getAllFunctions(): List<FunctionInfo> {
        return functions.map { (name, func) ->
            FunctionInfo(name, func.description)
        }
    }

    /**
     * 删除函数
     */
    fun removeFunction(name: String) {
        Timber.i("Removing function: $name")
        functions.remove(name)
    }
}

interface CustomFunction {
    val description: String
    suspend fun execute(vararg args: Any?): Any?
}

data class FunctionInfo(
    val name: String,
    val description: String
)