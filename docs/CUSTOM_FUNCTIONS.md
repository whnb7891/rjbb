# 自定义函数指南

## 概述

RJBB 允许用户创建和使用自定义函数来扩展功能。

## 函数定义

### 基本语法

```kotlin
function myFunction(input: Any): Any {
    // 你的逻辑
    return result
}
```

### 支持的数据类型

- `Int` - 32位整数
- `Long` - 64位整数
- `Float` - 浮点数
- `Double` - 双精度浮点数
- `String` - 字符串
- `Boolean` - 布尔值
- `ByteArray` - 字节数组

## 创建自定义函数

### 步骤 1: 打开函数编辑器

1. 打开应用
2. 进入 "设置" 或 "自定义函数" 页面
3. 点击 "新建函数" 按钮

### 步骤 2: 编写函数代码

```kotlin
function hexToInt(hexString: String): Int {
    return Integer.parseInt(hexString, 16)
}
```

### 步骤 3: 测试函数

- 输入测试数据
- 点击 "测试" 按钮
- 查看输出结果

### 步骤 4: 保存函数

- 给函数命名
- 点击 "保存" 按钮

## 常用函数示例

### 1. 十六进制转整数

```kotlin
function hexToInt(hex: String): Int {
    return Integer.parseInt(hex, 16)
}
```

**使用**: `hexToInt("FF")` → `255`

### 2. 整数转十六进制

```kotlin
function intToHex(value: Int): String {
    return "0x" + Integer.toHexString(value)
}
```

**使用**: `intToHex(255)` → `"0xff"`

### 3. 浮点数舍入

```kotlin
function roundFloat(value: Float, decimals: Int): Float {
    val multiplier = Math.pow(10.0, decimals.toDouble()).toFloat()
    return Math.round(value * multiplier) / multiplier
}
```

**使用**: `roundFloat(3.14159, 2)` → `3.14`

### 4. 值范围检查

```kotlin
function inRange(value: Int, min: Int, max: Int): Boolean {
    return value >= min && value <= max
}
```

**使用**: `inRange(50, 0, 100)` → `true`

### 5. 位运算 - 设置位

```kotlin
function setBit(value: Int, bitPosition: Int): Int {
    return value or (1 shl bitPosition)
}
```

**使用**: `setBit(8, 1)` → `10` (二进制: 1010)

### 6. 位运算 - 清除位

```kotlin
function clearBit(value: Int, bitPosition: Int): Int {
    return value and (1 shl bitPosition).inv()
}
```

### 7. 绝对值

```kotlin
function abs(value: Int): Int {
    return if (value < 0) -value else value
}
```

### 8. 最大值

```kotlin
function max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```

## 高级用法

### 使用内存 API

```kotlin
function readAndDouble(address: Long): Int {
    val value = memory.readInt(address)
    return value * 2
}
```

### 使用搜索 API

```kotlin
function searchAndCount(searchValue: Int): Int {
    val results = search.find(searchValue)
    return results.size
}
```

### 修改多个地址

```kotlin
function multiModify(addresses: Array<Long>, newValue: Int) {
    addresses.forEach { address ->
        memory.writeInt(address, newValue)
    }
}
```

## 调试

### 日志输出

```kotlin
function debugFunction(value: Int): Int {
    log("输入值: $value")
    val result = value * 2
    log("输出值: $result")
    return result
}
```

### 断点调试

在编辑器中设置断点，步进执行代码

### 变量监视

查看变量值在执行过程中的变化

## 错误处理

### 异常捕获

```kotlin
function safeFunction(value: Any): Any {
    try {
        // 你的逻辑
        return result
    } catch (e: Exception) {
        log("错误: " + e.message)
        return null
    }
}
```

### 输入验证

```kotlin
function validateInput(value: Int): Boolean {
    if (value < 0) {
        log("值不能为负数")
        return false
    }
    return true
}
```

## 性能优化

### 避免循环中的大量运算

```kotlin
// ❌ 不推荐
function badPerformance(n: Int): Int {
    var sum = 0
    for (i in 0 until n) {
        sum += Math.sqrt(i.toDouble()).toInt()
    }
    return sum
}

// ✅ 推荐
function goodPerformance(n: Int): Int {
    return (0 until n).map { Math.sqrt(it.toDouble()).toInt() }.sum()
}
```

### 缓存中间结果

```kotlin
function efficientFunction(value: Int): Int {
    val cached = cache.get("myValue")
    if (cached != null) {
        return cached as Int
    }
    
    val result = expensiveCalculation(value)
    cache.set("myValue", result)
    return result
}
```

## 函数库

浏览和下载社区贡献的函数库：

1. 访问函数市场
2. 搜索需要的函数
3. 下载并导入
4. 在你的脚本中使用

## API 参考

详见 [API 文档](API.md)

## 常见问题

### Q: 如何访问内存？
A: 使用 `memory.readInt(address)` 和 `memory.writeInt(address, value)` 等 API

### Q: 如何进行搜索？
A: 使用 `search.find(value)` 进行搜索

### Q: 函数支持什么参数类型？
A: 支持所有基本类型、String 和自定义对象

### Q: 可以调用其他函数吗？
A: 是的，可以调用已注册的其他函数

## 最佳实践

1. 给函数起有意义的名字
2. 添加注释说明函数功能
3. 进行彻底的测试
4. 处理异常和边界情况
5. 优化性能关键部分
6. 记录函数的使用示例
