# RJBB - GG 修改器 Android 版本

一个高效的 Android 游戏修改工具，提供快速的搜索和响应速度。

## 功能特性

- ⚡ **高效搜索** - 快速的值搜索和扫描功能
- 🔍 **智能筛选** - 多条件筛选和精确定位
- 🎮 **游戏修改** - 支持修改游戏内存值
- 🔧 **自定义函数** - 用户可以自定义添加函数
- 🎨 **友好界面** - 类似 AGG 修改器的直观 UI
- 📱 **原生 Android** - 完全的 Android 原生应用

## 项目结构

```
rjbb/
├── app/                          # Android 应用模块
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/            # Java/Kotlin 源代码
│   │   │   ├── res/             # 资源文件
│   │   │   └── AndroidManifest.xml
│   │   └── test/                # 测试代码
│   └── build.gradle
├── core/                         # 核心功能库
│   ├── src/
│   └── build.gradle
├── ui/                           # UI 组件库
│   ├── src/
│   └── build.gradle
├── docs/                         # 文档
│   ├── API.md                    # API 文档
│   ├── ARCHITECTURE.md           # 项目架构
│   └── CUSTOM_FUNCTIONS.md       # 自定义函数指南
├── build.gradle                  # 项目级 gradle
├── settings.gradle               # 模块配置
├── LICENSE                       # MIT 许可证
├── .gitignore                    # Git 忽略配置
└── README.md                     # 本文件
```

## 快速开始

### 系统要求

- Android SDK 26 或更高版本
- Android Studio 4.0 或更高版本
- JDK 11 或更高版本

### 安装

1. 克隆仓库
```bash
git clone https://github.com/whnb7891/rjbb.git
cd rjbb
```

2. 在 Android Studio 中打开项目
- File → Open → 选择项目目录

3. 构建项目
```bash
./gradlew build
```

4. 安装应用
```bash
./gradlew installDebug
```

## 使用指南

### 基础搜索

1. 打开应用
2. 输入要搜索的值
3. 选择数据类型（整数、浮点数等）
4. 点击搜索
5. 查看结果列表

### 精确搜索

1. 在搜索结果上进行再次搜索
2. 输入新的搜索值
3. 缩小结果范围

### 修改内存值

1. 从搜索结果中选择地址
2. 输入新值
3. 点击修改
4. 确认修改

### 自定义函数

详见 [自定义函数指南](docs/CUSTOM_FUNCTIONS.md)

## 架构

项目采用分层模块化架构：

- **表现层** - UI 组件和界面
- **业务逻辑层** - 搜索引擎、内存修改器
- **数据层** - 数据库、文件存储
- **工具层** - 日志、验证、转换等

详见 [架构文档](docs/ARCHITECTURE.md)

## API 文档

完整的 API 参考见 [API 文档](docs/API.md)

## 贡献

欢迎贡献代码！请遵循以下步骤：

1. Fork 本仓库
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

## 许可证

本项目采用 MIT License 开源。详见 [LICENSE](LICENSE) 文件

## 免责声明

本项目仅供学习和研究使用。使用本工具进行的任何修改行为由用户承担全部责任。

## 联系方式

- GitHub: [@whnb7891](https://github.com/whnb7891)

## 更新日志

### v0.1.0 (2026-05-15)
- 项目初始化
- 基础架构搭建
- 文档完成

## 致谢

感谢所有为这个项目做出贡献的人！

## 相关链接

- [Android 官方文档](https://developer.android.com)
- [Kotlin 官方文档](https://kotlinlang.org)
- [Android Jetpack](https://developer.android.com/jetpack)
