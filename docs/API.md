# API 文档

## 搜索 API

### SearchEngine

#### 搜索值

```kotlin
fun search(
    value: Any,
    dataType: DataType,
    options: SearchOptions = SearchOptions()
): List<Long>
```

**参数:**
- `value` - 要搜索的值
- `dataType` - 数据类型（INT, LONG, FLOAT, DOUBLE, etc.）
- `options` - 搜索选项（范围、精度等）

**返回:** 匹配的内存地址列表

#### 精确搜索

```kotlin
fun exactSearch(
    value: Any,
    dataType: DataType
): List<Long>
```

#### 范围搜索

```kotlin
fun rangeSearch(
    minValue: Any,
    maxValue: Any,
    dataType: DataType
): List<Long>
```

## 内存 API

### MemoryModifier

#### 读取内存

```kotlin
fun readByte(address: Long): Byte
fun readShort(address: Long): Short
fun readInt(address: Long): Int
fun readLong(address: Long): Long
fun readFloat(address: Long): Float
fun readDouble(address: Long): Double
fun readBytes(address: Long, size: Int): ByteArray
```

#### 写入内存

```kotlin
fun writeByte(address: Long, value: Byte)
fun writeShort(address: Long, value: Short)
fun writeInt(address: Long, value: Int)
fun writeLong(address: Long, value: Long)
fun writeFloat(address: Long, value: Float)
fun writeDouble(address: Long, value: Double)
fun writeBytes(address: Long, value: ByteArray)
```

## 数据类型

```kotlin
enum class DataType {
    BYTE,      // 8位
    SHORT,     // 16位
    INT,       // 32位
    LONG,      // 64位
    FLOAT,     // 浮点数
    DOUBLE,    // 双精度浮点数
    TEXT       // 文本
}
```

## 搜索选项

```kotlin
data class SearchOptions(
    val range: IntRange? = null,
    val caseSensitive: Boolean = true,
    val useThreadPool: Boolean = true,
    val threadCount: Int = 4,
    val progressCallback: ((progress: Int) -> Unit)? = null
)
```

## 函数管理 API

### FunctionManager

#### 注册函数

```kotlin
fun registerFunction(
    name: String,
    function: suspend (vararg args: Any?) -> Any?
)
```

#### 调用函数

```kotlin
suspend fun callFunction(
    name: String,
    vararg args: Any?
): Any?
```

#### 获取函数列表

```kotlin
fun getFunctions(): List<FunctionInfo>
```

## 回调和事件

### 搜索进度回调

```kotlin
val results = search.search(
    value = 100,
    dataType = DataType.INT,
    options = SearchOptions(
        progressCallback = { progress ->
            println("搜索进度: $progress%")
        }
    )
)
```

### 修改监听器

```kotlin
memory.addModificationListener { address, oldValue, newValue ->
    println("地址: 0x${address.toString(16)}, 旧值: $oldValue, 新值: $newValue")
}
```

## 错误处理

### 异常类型

```kotlin
class SearchException(message: String) : Exception(message)
class MemoryAccessException(message: String) : Exception(message)
class PermissionException(message: String) : Exception(message)
class FunctionException(message: String) : Exception(message)
```

## 示例

### 完整搜索示例

```kotlin
try {
    val results = searchEngine.search(
        value = 999,
        dataType = DataType.INT,
        options = SearchOptions(
            progressCallback = { progress ->
                updateUI("搜索进度: $progress%")
            }
        )
    )
    
    results.forEach { address ->
        val value = memory.readInt(address)
        println("找到: 0x${address.toString(16)} = $value")
    }
} catch (e: SearchException) {
    println("搜索失败: ${e.message}")
}
```

### 内存修改示例

```kotlin
try {
    memory.writeInt(0x12345678L, 9999)
    val newValue = memory.readInt(0x12345678L)
    println("新值: $newValue")
} catch (e: MemoryAccessException) {
    println("内存访问失败: ${e.message}")
}
```

### 自定义函数示例

```kotlin
// 注册函数
functionManager.registerFunction("myFunc") { args ->
    val value = args[0] as Int
    return@registerFunction value * 2
}

// 调用函数
val result = functionManager.callFunction("myFunc", 50)
println("结果: $result") // 输出: 结果: 100
```

## 最佳实践

1. 总是使用 try-catch 处理异常
2. 检查返回的地址列表是否为空
3. 验证内存地址有效性
4. 使用进度回调了解操作进度
5. 为耗时操作使用协程

## 性能建议

- 对大范围搜索使用多线程
- 利用缓存存储中间结果
- 限制返回结果的数量
- 使用适当的搜索选项优化性能
