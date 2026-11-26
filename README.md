# java-se-core

![Java](https://img.shields.io/badge/Java-21%2B%20(LTS)-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Conventional Commits](https://img.shields.io/badge/Commits-Conventional-FE5196?style=flat-square&logo=conventionalcommits&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

面向 Java 后端工程实践的 **Java SE 核心基础与底层原理代码库**，聚焦数据结构与算法实现、集合源码剖析、IO/网络模型、并发编程（JUC）及
JVM 底层机制的编码验证。

> 本仓库按专题模块持续迭代构建，所有实现均基于纯标准库（JDK Standard Library），不引入外部框架依赖。

## Module Architecture

| Module                  | Core Topics              | Engineering Focus           |
|:------------------------|:-------------------------|:----------------------------|
| `m01-algorithm`         | 排序、查找、递归与常见基础算法          | 手写核心逻辑，明确边界条件与时间/空间复杂度权衡    |
| `m02-collection-stream` | 集合框架进阶、泛型、Stream 流与方法引用  | 容器底层结构对比、迭代器机制与函数式数据处理      |
| `m03-exception-io`      | 异常体系、NIO/IO 流与文件系统操作     | 资源安全释放、缓冲机制与字节/字符流选型        |
| `m04-thread-net`        | 多线程基础、线程通信与 Socket 网络编程  | 线程生命周期、同步原语与基础 C/S 网络模型     |
| `m05-reflect-proxy`     | 反射机制、注解处理与动态代理           | 运行时元数据解析及 JDK 动态代理底层原理      |
| `m06-juc`               | 线程池、锁机制、CAS、并发容器与异步编排    | 高并发场景下的线程安全、锁粒度控制与性能调优      |
| `m07-jvm`               | 类加载机制、运行时数据区、JMM 与 GC 调优 | 内存模型验证、字节码分析与常见 OOM/GC 排查实验 |

## Project Structure

```text
java-se-core
├── m01-algorithm/          # 基础数据结构与经典算法实现
├── m02-collection-stream/  # 集合进阶与 Stream API 实战
├── m03-exception-io/       # 异常处理与 IO 体系（规划演进）
├── m04-thread-net/         # 并发基础与网络编程（规划演进）
├── m05-reflect-proxy/      # 反射与动态代理（规划演进）
├── m06-juc/                # JUC 并发编程进阶（规划演进）
└── m07-jvm/                # JVM 底层原理实验（规划演进）