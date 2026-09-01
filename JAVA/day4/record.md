# Java 学习记录：day4

## 记录约定

- 每次说“记录”时，先检查 `day4/src/main/java` 下最近新增或修改的 Java 文件。
- 记录代码涉及的知识点、关键语法、运行结果和当前学习进度。
- 已经记录过的内容不重复堆砌；发现新代码时追加新的章节。

## 2026-08-31

### 1. day4 当前文件

```text
src/main/java/hw/hw.java   基础 Hello World
src/main/java/hw/api.java  Java API、Scanner 和 String 入门
```

### 2. Java API

API 是 Application Programming Interface（应用程序编程接口）的缩写。Java 官方已经把许多常用功能封装成类和方法，我们可以直接按照规则调用，不需要先了解这些方法内部的全部实现。

使用 API 的一般步骤是：

```text
查找需要的类和方法 -> 导入对应的包 -> 创建对象或直接调用 -> 获取结果
```

例如 `Scanner` 属于 Java 提供的输入工具类：

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
String line = sc.nextLine();
```

`nextLine()` 用于读取一整行字符串。`Scanner` 使用完后，在完整程序中可以调用 `sc.close()` 释放资源；练习程序中通常重点关注输入功能即可。

### 3. String 的几种创建方式

`api.java` 演示了使用不同构造方法创建 `String` 对象。

#### 空构造方法

```java
String s1 = new String();
System.out.println(s1);
```

创建一个空字符串，打印时这一行没有可见字符，因此输出中会出现空白行。

#### 根据字符数组创建

```java
char[] chs = {'a', 'b', 'c'};
String s2 = new String(chs);
System.out.println(s2); // abc
```

`new String(chs)` 会按照字符数组中的顺序创建字符串。

#### 根据字节数组创建

```java
byte[] b = {97, 98, 99};
String s3 = new String(b);
System.out.println(s3); // abc
```

在默认字符编码能够按 ASCII 解释这些值时，`97`、`98`、`99` 分别对应字符 `a`、`b`、`c`。涉及中文或跨平台数据时，应明确指定字符集，例如 `new String(bytes, StandardCharsets.UTF_8)`，避免编码不一致。

### 4. 当前代码运行结果

`hw.java` 输出：

```text
Hello World
```

`api.java` 输出：

```text
Hello World

abc
abc
```

中间的空白行来自空字符串 `s1`。

### 5. day4 学习进度

```text
[已完成] 认识 Java API 和官方封装类
[已完成] 使用 import 导入 Scanner
[已完成] 使用 Scanner.nextLine() 读取字符串
[已完成] 使用 String 的不同构造方法
[已完成] 了解 char[] 和 byte[] 转换为 String
[进行中] String 常用方法、字符串比较、字符编码和 API 文档查阅
```

## 2026-09-01

### 6. `Stringbuilder.java`：`String` 和 `StringBuilder` 比较为什么是 `false`

第 46 行代码：

```java
String s = sb2.toString();
System.out.println(s.equals(sb2)); // false
```

虽然 `s` 和 `sb2` 打印出来的内容都是 `helloworldcyr`，但它们的类型不同：

```text
s   -> String
sb2 -> StringBuilder
```

`String.equals(Object)` 比较时，要求传入的对象也是 `String`，然后才比较字符串内容。`sb2` 是 `StringBuilder`，不是 `String`，所以直接比较返回 `false`。

正确做法是先把 `StringBuilder` 转成 `String`：

```java
System.out.println(s.equals(sb2.toString())); // true
```

或者：

```java
System.out.println(sb2.toString().equals(s)); // true
```

需要区分：

- `equals()`：通常用于比较对象内容，但具体规则由类的 `equals` 方法决定。
- `==`：对于引用类型通常比较两个引用是否指向同一个对象，不适合用来比较字符串内容。
- `StringBuilder` 是可变对象；使用 `toString()` 可以得到一个 `String` 快照，再与其他字符串比较。

### 7. `StringBuilder` 当前学习进度

```text
[已完成] 创建空的 StringBuilder
[已完成] 使用 append 追加字符串和数字
[已完成] 使用 reverse 反转内容
[已完成] 使用 toString 转换为 String
[已完成] 理解 String 与 StringBuilder 不能直接按内容比较
[进行中] StringBuilder 常用方法与 String 常用方法
```

### 8. `equal.java`：`==` 和 `equals()` 比较字符串

`new String(car)` 每次创建新的字符串对象，内容虽然相同，但引用不同，所以 `a == b`、`a == c` 为 `false`。字符串字面量 `d = "abc"` 和 `e = "abc"` 通常复用字符串常量池中的对象，因此 `d == e` 可能为 `true`。

比较引用类型时，`==` 比较是否为同一个对象；`String.equals()` 比较字符串内容：

```java
a.equals(b) // true
a.equals(c) // true
a.equals(d) // true
```

比较字符串内容应使用 `equals()`，不要使用 `==`。

### 9. `yonghudenglu.java`：用户名密码登录重试

程序用 `for` 循环限制最多登录 3 次，用 `&&` 要求用户名和密码同时正确，登录成功后用 `break` 结束循环。剩余次数通过 `3 - i` 计算。

用户名和密码属于 `String`，必须使用 `equals()` 比较内容。

当前代码把 `Scanner` 放在循环内部，每次重试都重新创建 Scanner。多个 Scanner 读取同一个 `System.in` 可能产生输入缓冲问题，批量输入时甚至出现 `NoSuchElementException`。推荐只创建一次并放在循环外：

```java
Scanner sc = new Scanner(System.in);
for (int i = 1; i <= 3; i++) {
    String userName1 = sc.nextLine();
    String password1 = sc.nextLine();
    // 登录判断
}
```

### 10. `Stringbuilder.java`：String 与 StringBuilder 互转

`StringBuilder.toString()` 可以把 `StringBuilder` 转成 `String`；也可以把 `String` 作为构造方法参数，创建 `StringBuilder`：

```java
String s1 = "hello";
StringBuilder sb3 = new StringBuilder(s1);
System.out.println(sb3); // hello
```

`String` 内容不可变，`StringBuilder` 内容可变，适合使用 `append()`、`reverse()` 进行修改。

### 11. day4 学习进度更新

```text
[已完成] Java API、Scanner 和 String 基础
[已完成] 使用 equals 比较字符串内容
[已完成] 理解 == 比较引用、字符串常量池现象
[已完成] for 循环实现登录次数限制
[已完成] 使用 && 组合登录条件
[注意] Scanner 应尽量只创建一个并复用
[进行中] String 常用 API、字符串处理和异常边界
```
