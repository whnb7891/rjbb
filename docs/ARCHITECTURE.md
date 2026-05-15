# 项目架构

## 概述

RJBB 采用分层模块化架构，分为以下几个主要层：

## 1. 表现层 (UI Layer)

负责用户界面和交互：

- **MainActivity** - 主界面容器
- **SearchFragment** - 搜索界面
- **ResultsFragment** - 结果展示
- **SettingsFragment** - 设置界面
- **CustomFunctionsFragment** - 自定义函数管理

### UI 组件
- **SearchBar** - 搜索输入框
- **ResultsAdapter** - 结果列表适配器
- **FunctionEditor** - 函数编辑器
- **ModificationDialog** - 修改对话框

## 2. 业务逻辑层 (Business Logic Layer)

处理核心功能：

### SearchEngine (搜索引擎)
- 值搜索
- 范围搜索
- 精确搜索
- 多线程优化

### MemoryModifier (内存修改器)
- 读取内存
- 写入内存
- 安全验证
- 修改日志

### DataTypeHandler (数据类型处理器)
- 类型转换
- 格式化输出
- 验证输入

### FunctionManager (函数管理器)
- 注册函数
- 执行函数
- 函数列表管理
- 函数编译/解释

## 3. 数据层 (Data Layer)

管理数据存储和访问：

### MemoryScanner (内存扫描器)
- 系统内存访问
- 内存映射
- 缓存管理

### Database (数据库)
- 使用 Room ORM
- 存储搜索历史
- 存储自定义函数
- 存储修改记录

### FileStorage (文件存储)
- 导出/导入配置
- 保存快照
- 管理脚本文件

### Cache (缓存管理)
- 内存缓存
- 搜索结果缓存
- 性能优化

## 4. 工具层 (Utility Layer)

提供通用工具：

### Logger (日志记录)
- 应用日志
- 操作日志
- 错误追踪

### Validator (验证器)
- 输入验证
- 地址验证
- 权限检查

### Converter (转换器)
- 进制转换
- 编码转换
- 格式转换

### Permission (权限管理)
- 权限申请
- 权限检查
- 权限授予

## 数据流

```
用户交互
    ↓
UI 层 (Fragment/Activity)
    ↓
业务逻辑层 (SearchEngine/MemoryModifier)
    ↓
数据层 (Memory/Database)
    ↓
工具层 (Validator/Logger)
    ↓
结果返回 & UI 更新
```

## 核心流程

### 搜索流程

```
输入值 
    ↓
验证输入 (Validator)
    ↓
初始扫描 (MemoryScanner)
    ↓
多线程搜索 (SearchEngine)
    ↓
结果过滤
    ↓
缓存结果 (Cache)
    ↓
UI 显示 (ResultsAdapter)
```

### 修改流程

```
选择地址
    ↓
输入新值
    ↓
权限检查 (Permission)
    ↓
验证地址 (Validator)
    ↓
写入内存 (MemoryModifier)
    ↓
记录操作 (Logger/Database)
    ↓
显示结果 (UI)
```

## 模块依赖关系

```
app (应用层)
    ├── ui (UI 组件库)
    │   └── core (核心库)
    │       ├── SearchEngine
    │       ├── MemoryModifier
    │       └── FunctionManager
    └── core (核心库)
        └── tools (工具库)
            ├── Logger
            ├── Validator
            └── Converter
```

## 关键设计模式

### 1. 单一职责原则 (SRP)
每个类只负责一个特定的功能

### 2. 依赖注入 (DI)
使用 Hilt 进行依赖注入，提高可测试性

### 3. 观察者模式
UI 使用 LiveData/StateFlow 观察数据变化

### 4. 策略模式
不同的搜索策略（精确、范围、递增等）

### 5. 工厂模式
创建不同类型的数据处理器

## 并发处理

### 线程策略
- **主线程** - UI 更新
- **IO 线程** - 数据库和文件操作
- **Default 线程** - CPU 密集操作
- **自定义线程池** - 内存搜索

### 协程使用
- 异步搜索
- 数据库查询
- 文件 I/O

## 安全考虑

### 权限管理
- 运行时权限申请
- 权限检查

### 内存安全
- 地址范围验证
- 类型检查
- 异常处理

### 错误处理
- try-catch 包装
- 异常日志
- 用户提示

## 性能优化

### 搜索优化
- 多线程扫描
- 结果缓存
- 增量搜索

### 内存优化
- 缓存管理
- 对象池
- 垃圾回收调优

### UI 优化
- 列表虚拟化
- 数据分页
- 视图回收

## 扩展点

### 添加新的搜索类型
1. 在 SearchEngine 中添加新方法
2. 在 UI 中添加对应选项
3. 编写测试用例

### 添加新的数据类型
1. 在 DataType 枚举中添加类型
2. 在 DataTypeHandler 中添加处理逻辑
3. 更新 UI 界面

### 添加新的存储方式
1. 实现新的 Storage 接口
2. 在 Database 中整合
3. 提供切换选项

## 技术栈

| 层次 | 技术 | 版本 |
|------|------|------|
| UI | Jetpack Compose | 最新 |
| 架构 | MVVM | - |
| DI | Hilt | 2.44+ |
| 异步 | Coroutines | 1.7+ |
| 数据库 | Room | 2.5+ |
| 日志 | Timber | 5.0+ |
| 测试 | JUnit/Espresso | - |

## 文件组织

```
app/src/main/java/com/example/rjbb/
├── ui/                     # UI 层
│   ├── MainActivity.kt
│   ├── fragments/
│   │   ├── SearchFragment.kt
│   │   ├── ResultsFragment.kt
│   │   └── SettingsFragment.kt
│   ├── adapters/
│   └── viewmodels/
├── domain/                 # 业务逻辑层
│   ├── search/
│   │   └── SearchEngine.kt
│   ├── memory/
│   │   └── MemoryModifier.kt
│   └── functions/
│       └── FunctionManager.kt
├── data/                   # 数据层
│   ├── db/
│   │   ├── AppDatabase.kt
│   │   └── entities/
│   ├── repository/
│   └── source/
├── utils/                  # 工具层
│   ├── Logger.kt
│   ├── Validator.kt
│   └── Converter.kt
└── di/                     # 依赖注入
    └── AppModule.kt
```
