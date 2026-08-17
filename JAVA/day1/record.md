# Java Day 1 学习记录

- 学习日期：2026-08-17
- 练习文件：`src/main/java/hl/hl1.java`
- Java 版本：Java 8

## 一、今日学习目标

今天通过编写一个简单的 Java 程序，学习并练习了以下内容：

1. Java 程序的基本结构和 `main` 方法。
2. 使用 `System.out.println()` 输出内容。
3. 定义和使用 `int` 类型变量。
4. 使用比较运算符和逻辑运算符。
5. 理解 `&&` 的短路特性以及自增运算的执行时机。
6. 使用 `Scanner` 接收键盘输入。
7. 观察数字与字符串相加时的字符串拼接效果。
8. 初步了解三元运算符和 `if...else` 条件分支。

## 二、Java 程序基本结构

程序定义在 `hl` 包中，入口是 `main` 方法：

```java
package hl;

public class hl1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

我的理解：

- `package hl;` 表示当前类属于 `hl` 包。
- `public class hl1` 定义了一个公共类。
- `main` 方法是 Java 应用程序的入口。
- `System.out.println()` 会输出内容，并在末尾换行。

## 三、变量、比较和逻辑运算

代码中定义了三个整型变量：

```java
int i = 10;
int j = 20;
int k = 30;
```

然后使用 `>` 比较大小，并使用 `&&` 连接两个布尔表达式：

```java
System.out.println((k > i) && (j > i)); // true
System.out.println((i > k) && (j > i)); // false
```

运算过程：

| 表达式 | 左侧结果 | 右侧结果 | 最终结果 |
| --- | --- | --- | --- |
| `(k > i) && (j > i)` | `30 > 10`，为 `true` | `20 > 10`，为 `true` | `true` |
| `(i > k) && (j > i)` | `10 > 30`，为 `false` | 因短路不再计算 | `false` |

## 四、短路与 `&&`

这段代码是今天最重要的练习：

```java
System.out.println((i++ > 100) && (j++ > 100));
System.out.println(i);
System.out.println(j);
```

执行结果为：

```text
false
11
20
```

原因如下：

1. `i++ > 100` 比较时先使用原值 `10`，所以结果是 `false`。
2. 比较结束后执行自增，因此 `i` 变成 `11`。
3. `&&` 左侧已经是 `false`，整个表达式一定是 `false`。
4. 因为发生短路，右侧的 `j++ > 100` 不会执行，所以 `j` 仍然是 `20`。

### `&&` 与 `&` 的区别

- `&&`：短路与。左侧为 `false` 时，不执行右侧表达式。
- `&`：用于布尔表达式时，两侧都会执行，不会短路。
- `||`：短路或。左侧为 `true` 时，不执行右侧表达式。
- `|`：用于布尔表达式时，两侧都会执行，不会短路。

如果把练习中的 `&&` 改为 `&`，右侧的 `j++` 也会执行，此时 `j` 会变成 `21`。这说明在表达式中使用 `++` 等带有副作用的操作时，需要特别注意短路规则。

## 五、使用 Scanner 接收输入

程序使用 `Scanner` 读取控制台输入：

```java
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
String b = sc.next();
System.out.println(a + b);
```

相关知识点：

- `new Scanner(System.in)` 创建一个读取键盘输入的对象。
- `nextInt()` 读取一个整数；输入内容不是合法整数时会产生输入格式异常。
- `next()` 读取下一个以空白字符分隔的字符串，不能直接读取包含空格的完整句子。
- 当 `+` 的任意一侧是字符串时，执行字符串拼接，而不是纯数字加法。

例如依次输入：

```text
18
Java
```

输出为：

```text
18Java
```

## 六、已接触但尚未完成的内容

### 三元运算符

代码中已经添加了三元运算符的注释，但还没有写出实际练习。其基本格式是：

```java
条件表达式 ? 条件成立时的值 : 条件不成立时的值
```

例如：

```java
int max = i > j ? i : j;
```

### if...else 条件分支

代码中写出了条件分支的基本框架：

```java
if (条件1) {
    // 条件1成立时执行
} else if (条件2) {
    // 条件1不成立、条件2成立时执行
} else {
    // 前面的条件都不成立时执行
}
```

目前只完成了结构记录，下一次可以加入具体判断，例如根据成绩输出等级。

## 七、运行结果整理

在输入内容之前，当前程序会依次输出：

```text
Hello World
true
false
false
11
20
```

之后程序等待输入一个整数和一个字符串，并输出二者拼接后的结果。

## 八、发现的问题与改进点

1. `java.util.logging.Logger` 已导入但没有使用，可以删除该导入，避免无效代码。
2. Java 类名通常使用大驼峰命名法，因此 `hl1` 更规范的写法是 `Hl1`。
3. 输入前可以增加提示文字，让使用者知道应该输入什么。
4. 可以继续练习 `nextLine()`，并比较它与 `next()` 的区别。
5. 尽量避免在复杂逻辑表达式中直接使用 `i++`，否则代码结果容易被误判。

## 九、今日总结

今天完成了第一个 Java 控制台练习。我不仅熟悉了变量、输出和键盘输入，还通过 `i++` 与 `j++` 的变化验证了 `&&` 的短路机制：左侧为 `false` 时，右侧不会执行。后续需要把三元运算符和 `if...else` 从注释框架扩展为可运行的练习，并继续熟悉不同输入方法。

## 十、新增练习：成绩区间判断

- 练习文件：`src/main/java/hl/test.java`
- 学习问题：Java 中如何表示 `0 < a < 80`？

Java 不支持数学中的连续比较写法 `0 < a < 80`。需要把区间拆成两个布尔表达式，再用短路与 `&&` 连接：

```java
a > 0 && a < 80
```

含义是：`a` 大于 `0`，并且 `a` 小于 `80`。

我在代码中实际写的是：

```java
if (a >= 0 && a < 80) {
    System.out.println("胖揍一顿");
} else if (80 <= a && a < 90) {
    System.out.println("变形金刚玩具一个");
} else if (90 <= a && a < 95) {
    System.out.println("游乐场玩一次");
} else if (95 <= a && a <= 100) {
    System.out.println("山地自行车一辆");
} else {
    System.out.println("输入的成绩不合法");
}
```

当前代码划分的范围如下：

| 分数范围 | 是否包含边界 | 输出结果 |
| --- | --- | --- |
| `0 <= a < 80` | 包含 `0`，不包含 `80` | 胖揍一顿 |
| `80 <= a < 90` | 包含 `80`，不包含 `90` | 变形金刚玩具一个 |
| `90 <= a < 95` | 包含 `90`，不包含 `95` | 游乐场玩一次 |
| `95 <= a <= 100` | 包含 `95` 和 `100` | 山地自行车一辆 |
| 小于 `0` 或大于 `100` | 非法范围 | 输入的成绩不合法 |

需要注意：我最初问的是 `0 < a < 80`，但代码写的是 `a >= 0 && a < 80`。两者区别在于当前代码会把 `0` 当作合法成绩。如果希望不包含 `0`，应该改为 `a > 0 && a < 80`。

为了让区间表达式更容易阅读，可以统一把变量写在左边：

```java
a >= 80 && a < 90
```

它与 `80 <= a && a < 90` 的结果相同，但更符合常见的 Java 代码习惯。

## 十一、新增练习：switch 分支

- 练习文件：`src/main/java/hl/sw.java`
- 学习问题：如何处理其他情况？为什么要写 `break`？

我使用 `switch` 把数字 `1` 到 `7` 转换成星期：

```java
switch (a) {
    case 1:
        System.out.println("星期一");
        break;
    case 2:
        System.out.println("星期二");
        break;
    // 省略 case 3 到 case 7
    default:
        System.out.println("情况不存在");
        break;
}
```

### default 的作用

`default` 相当于 `if...else` 中最后的 `else`。当输入值与所有 `case` 都不匹配时，就会执行 `default`。

在当前代码中，输入 `1` 到 `7` 会输出对应的星期；输入 `0`、`8` 等其他整数会输出“情况不存在”。

### break 的作用

传统 `switch` 在匹配一个 `case` 后，会从该位置继续向下执行后续代码，这种现象叫作 `case` 穿透。`break` 用于立即结束当前 `switch`，防止继续执行后面的 `case`。

例如输入 `1`，有 `break` 时只输出：

```text
星期一
```

如果删除所有 `break`，程序会继续执行 `case 2` 到 `default`，输出多个结果。

`break` 并不是任何时候都必须写。多个 `case` 需要共用一段逻辑时，可以故意利用穿透：

```java
switch (a) {
    case 1:
    case 2:
    case 3:
        System.out.println("输入的是 1、2、3 中的一个");
        break;
    default:
        System.out.println("其他情况");
}
```

### break 与 while 的关系

当前 `switch` 写在一个无限循环中：

```java
while (true) {
    int a = sc.nextInt();
    switch (a) {
        // case 分支
    }
}
```

`case` 中的 `break` 只会结束 `switch`，不会结束外层的 `while (true)`。因此每次输出星期后，程序都会继续等待下一次输入。若要结束整个循环，需要额外设计退出条件，或者在合适的位置使用针对循环的控制逻辑。

## 十二、本次代码检查与改进方向

1. `test.java` 已正确使用 `&&` 组合分数的上下限，`0` 到 `100` 的各个分段连续且没有重叠。
2. `sw.java` 的功能是输入星期编号，但提示文字目前是“请输入成绩”，可以改成“请输入 1 到 7 的星期编号”。
3. 两个程序都使用了 `while (true)`，目前没有主动退出方式，运行后会一直等待下一次输入。
4. `test` 和 `sw` 按 Java 命名规范可以改为 `Test` 和 `Sw`，类名通常使用大驼峰写法。
5. 当前项目使用 Java 8，所以 `switch` 应继续使用传统的 `case`、冒号和 `break` 写法。

## 十三、新增练习：Java 三种循环

- 练习文件：`src/main/java/hl/circle.java`
- 学习内容：`for`、`while`、`do...while`、累加求和和偶数判断。

### for 循环的结构

```java
for (初始化语句; 循环条件; 迭代语句) {
    循环体;
}
```

本次第一个循环为：

```java
int sum = 0;
for (int a = 1; a <= 10; a++) {
    System.out.println("hello world");
    sum += a;
}
System.out.println("sum=" + sum);
```

执行顺序如下：

1. 执行一次初始化语句 `int a = 1`。
2. 判断条件 `a <= 10`。
3. 条件为 `true` 时执行循环体。
4. 执行迭代语句 `a++`。
5. 回到第二步，直到条件为 `false`。

循环会输出 `10` 次 `hello world`。`sum += a` 等价于 `sum = sum + a`，它把 `1` 到 `10` 依次累加，最终结果为：

```text
sum=55
```

### 求 1 到 100 的偶数和

```java
int sum1 = 0;
for (int b = 1; b <= 100; b++) {
    if (b % 2 == 0) {
        sum1 += b;
    }
}
System.out.println("sum1=" + sum1);
```

`%` 是取模运算符：

- `b % 2 == 0` 表示 `b` 除以 `2` 的余数为 `0`，因此 `b` 是偶数。
- `b % 2 != 0` 表示余数不为 `0`，因此 `b` 是奇数。

该循环计算的是：

```text
2 + 4 + 6 + ... + 100 = 2550
```

因此最终输出：

```text
sum1=2550
```

如果只想遍历偶数，也可以把循环写成：

```java
for (int b = 2; b <= 100; b += 2) {
    sum1 += b;
}
```

### while 循环

```java
int sum2 = 0;
while (sum2 <= 10) {
    System.out.println("sum2=" + sum2);
    sum2++;
}
```

`while` 会先判断条件，再决定是否执行循环体。当前 `sum2` 从 `0` 开始，条件为 `sum2 <= 10`，所以会输出 `0` 到 `10`，总共执行 `11` 次。

循环结束时 `sum2` 的值为 `11`。因为 `sum2` 声明在循环外，所以循环结束后仍然可以使用。

### do...while 循环

```java
int sum3 = 1;
do {
    System.out.println("sum3=" + sum3);
    sum3++;
} while (sum3 <= 10);
```

`do...while` 会先执行循环体，再判断循环条件，所以循环体至少执行一次。当前代码会输出 `sum3=1` 到 `sum3=10`，总共执行 `10` 次。

注意，`do...while` 末尾必须有分号：

```java
} while (sum3 <= 10);
```

### 三种循环的区别

| 循环类型 | 判断条件的时机 | 最少执行次数 | 常见场景 |
| --- | --- | --- | --- |
| `for` | 执行循环体之前 | `0` 次 | 已知或容易确定循环次数 |
| `while` | 执行循环体之前 | `0` 次 | 循环次数不确定，只知道继续条件 |
| `do...while` | 执行循环体之后 | `1` 次 | 循环体必须至少执行一次 |

`for` 中声明的计数器通常只在循环内有效：

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

`while` 的计数器通常声明在循环外，因此循环结束后还能继续使用。这是变量声明位置造成的作用域区别，不是两种循环在功能上的强制区别。

### 无限循环

下面两种写法都表示无限循环：

```java
for (;;) {
    // 循环体
}
```

```java
while (true) {
    // 循环体
}
```

无限循环通常需要设置退出条件，并使用 `break` 结束循环，否则程序会一直运行。

### 本次实际运行结果

```text
hello world  // 共输出 10 次
sum=55
sum1=2550
sum2=0 到 sum2=10
sum3=1 到 sum3=10
```

本次代码已通过 Maven 编译，并实际运行验证以上结果。

## 十四、IntelliJ IDEA 中的 Maven 项目结构

### Maven 项目是什么

Maven 是 Java 项目的构建和依赖管理工具。它通过固定的目录约定和项目根目录下的 `pom.xml` 管理源码、测试、依赖、编译与打包过程。

当前 `day1` 项目的主要结构如下：

```text
day1/
├── .idea/                         IntelliJ IDEA 项目配置
├── .mvn/                          Maven Wrapper 相关配置目录
├── src/
│   ├── main/
│   │   ├── java/                  Java 正式源码
│   │   │   └── hl/                hl 包中的 Java 类
│   │   └── resources/             正式环境资源文件
│   └── test/
│       └── java/                  Java 测试源码
├── target/                        Maven 生成的编译和打包产物
├── .gitignore                     Git 忽略规则
├── pom.xml                        Maven 项目的核心配置
└── record.md                      当前学习笔记
```

### pom.xml

`pom.xml` 是 Maven 项目的核心文件，POM 的全称是 Project Object Model，即“项目对象模型”。当前项目中的主要配置为：

```xml
<groupId>day1</groupId>
<artifactId>day1</artifactId>
<version>1.0-SNAPSHOT</version>
```

这三个值组成项目坐标：

| 配置 | 作用 | 当前值 |
| --- | --- | --- |
| `groupId` | 项目所属组织或分组，实际项目通常使用反向域名 | `day1` |
| `artifactId` | 当前项目或模块的名称 | `day1` |
| `version` | 项目版本 | `1.0-SNAPSHOT` |

`SNAPSHOT` 表示这是仍在开发、可能继续变化的版本。

当前项目还配置了：

```xml
<maven.compiler.source>8</maven.compiler.source>
<maven.compiler.target>8</maven.compiler.target>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
```

- `maven.compiler.source`：允许使用的 Java 源代码语法版本为 Java 8。
- `maven.compiler.target`：生成兼容 Java 8 的字节码。
- `project.build.sourceEncoding`：项目构建时使用 UTF-8 编码。

以后使用第三方库时，通常要在 `pom.xml` 的 `<dependencies>` 中添加依赖。IDEA 重新加载 Maven 项目后，会自动下载并加入类路径。

### src/main/java

`src/main/java` 用于存放程序正式源码。当前 Java 文件都位于：

```text
src/main/java/hl/
```

文件开头写着：

```java
package hl;
```

因此它们放在 `hl` 目录中。包名和目录结构应该对应。例如：

```java
package com.example.demo;
```

对应目录通常是：

```text
src/main/java/com/example/demo/
```

IDEA 通常会把 `src/main/java` 标记为 Sources Root。创建包和 Java 类时，应在这个源码根目录下操作。

### src/main/resources

`src/main/resources` 用于存放程序运行时需要的非 Java 文件，例如：

- `.properties` 配置文件
- `.xml` 配置文件
- `.json` 数据文件
- SQL 脚本
- 模板和静态资源

Maven 构建时会把其中的资源复制到 `target/classes`，让程序能通过类路径读取。

当前 `postgresql-practice.sql` 放在 `src/main/java/hl` 中。它是学习记录文件时可以继续保留；如果程序运行时需要把它作为资源读取，更标准的位置是 `src/main/resources`。

### src/test/java 与 src/test/resources

`src/test/java` 用于存放测试代码，目录结构通常与正式源码对应：

```text
src/test/java/hl/CircleTest.java
```

测试类不会成为正式程序的一部分。执行 `mvn test` 时，Maven 会编译并运行这里的测试。

测试需要使用的配置或数据文件通常放在：

```text
src/test/resources/
```

当前项目还没有测试类，所以执行 `mvn test` 时会显示 `No tests to run`。

### target

`target` 是 Maven 自动生成的构建目录，不是手写源码目录。当前可以看到：

```text
target/
├── classes/                       编译后的 .class 文件和资源
├── generated-sources/             工具生成的源码
└── maven-status/                  Maven 编译状态信息
```

例如：

```text
src/main/java/hl/circle.java
```

编译后会生成：

```text
target/classes/hl/circle.class
```

`.java` 是源代码，`.class` 是 JVM 可以执行的字节码。`target` 可以通过 Maven 重新生成，所以通常会在 `.gitignore` 中忽略，不提交到 Git。

执行以下命令可以删除 `target`：

```powershell
mvn clean
```

### .idea

`.idea` 是 IntelliJ IDEA 生成的项目配置目录，其中可能保存：

- JDK 和编译器配置
- Maven 项目关联
- 运行配置
- Git 根目录映射
- 编辑器和工作区状态

它不是 Maven 标准目录。Maven 即使离开 IDEA，也可以根据 `pom.xml` 和标准源码目录构建项目。

`.idea` 中很多文件由 IDEA 自动维护，通常不需要手动修改。个人工作区状态也经常通过 `.gitignore` 排除。

### .mvn

`.mvn` 用于存放 Maven Wrapper 或 Maven 本身的项目级配置。完整的 Maven Wrapper 项目通常还会在根目录包含 `mvnw` 和 `mvnw.cmd`，使没有全局安装 Maven 的开发者也能使用项目指定版本进行构建。

当前项目根目录没有 `mvnw` 和 `mvnw.cmd`，因此现在使用的是系统中已经安装的 `mvn` 命令。

### 常用 Maven 命令

| 命令 | 作用 |
| --- | --- |
| `mvn clean` | 删除旧的 `target` 构建产物 |
| `mvn compile` | 编译 `src/main/java` 中的源码 |
| `mvn test` | 编译源码和测试，并运行测试 |
| `mvn package` | 编译、测试并打包，默认生成 JAR |
| `mvn clean package` | 清理旧产物后重新执行完整打包 |

Maven 生命周期具有顺序关系。例如执行 `mvn package` 时，前面的编译和测试阶段也会自动执行，不需要先分别输入 `mvn compile` 和 `mvn test`。

### IDEA 中的 Maven 操作

在 IDEA 中打开 Maven 工具窗口后，可以看到 Lifecycle。双击其中的 `clean`、`compile`、`test` 或 `package`，效果与在终端中执行相应 Maven 命令基本相同。

修改 `pom.xml` 后，如果 IDEA 没有自动更新，可以点击 Maven 工具窗口中的“重新加载所有 Maven 项目”按钮，让新增依赖和配置生效。

### 当前项目文件应该放在哪里

| 文件类型 | 推荐目录 |
| --- | --- |
| 正式 Java 类 | `src/main/java` |
| 正式配置、SQL、JSON 等资源 | `src/main/resources` |
| 测试 Java 类 | `src/test/java` |
| 测试数据和测试配置 | `src/test/resources` |
| Maven 配置 | 项目根目录的 `pom.xml` |
| 学习文档 | 项目根目录或专门的 `docs` 目录 |
| 编译产物 | 由 Maven 自动放入 `target` |

## 十五、新增代码：continue、嵌套循环与 Random

### continue 跳过本轮循环

`Cb.java` 中使用 `continue` 输出 1 到 10 之间的奇数：

```java
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;
    }
    System.out.println(i);
}
```

当 `i` 是偶数时执行 `continue`，立即跳过本轮后面的代码，进入下一轮循环。因此输出为：

```text
1
3
5
7
9
```

`break` 和 `continue` 的区别：

- `break`：结束整个循环。
- `continue`：只结束当前这一轮，循环还会继续。

### 嵌套循环

一个循环内部再写一个循环称为嵌套循环：

```java
for (int a = 0; a <= 24; a++) {
    for (int b = 0; b <= 60; b++) {
        System.out.println("一天有" + a + "小时" + b + "分钟");
    }
}
```

外层循环每执行一次，内层循环都会完整执行一遍。当前外层有 `25` 个值，内层有 `61` 个值，所以一共输出：

```text
25 * 61 = 1525 次
```

正常一天中的小时是 `0` 到 `23`，分钟是 `0` 到 `59`。若要模拟一天的每一分钟，边界应写为：

```java
for (int hour = 0; hour < 24; hour++) {
    for (int minute = 0; minute < 60; minute++) {
        System.out.println("当前时间：" + hour + "时" + minute + "分");
    }
}
```

这样总共执行 `24 * 60 = 1440` 次。

### Random 随机数

```java
Random r = new Random();

for (int c = 1; c <= 10; c++) {
    int an = r.nextInt(10) + 1;
    System.out.println(an);
}
```

`r.nextInt(10)` 产生 `0` 到 `9` 的随机整数，加 `1` 后范围变成 `1` 到 `10`。循环执行 10 次，因此会输出 10 个随机数，随机数之间允许重复。

通用范围公式为：

```java
random.nextInt(最大值 - 最小值 + 1) + 最小值
```

### 猜数字游戏

`caishuzi.java` 实现了猜数字游戏：

```java
int a = rand.nextInt(100) + 1;
```

程序生成 `1` 到 `100` 的随机整数，然后循环读取输入：

- 输入小于答案时，提示“输入的数据小了”。
- 输入大于答案时，提示“输入的数据大了”。
- 输入等于答案时，提示猜对并执行 `break`。

当前代码有两层 `while (true)`。猜对后的 `break` 只结束内层猜测循环，外层循环会立即生成新的答案并开始下一局，因此程序不会自动退出。

当前每次猜测都会重新创建 `Scanner`，每局也会重新创建 `Random`。更合适的方式是在循环外各创建一次并重复使用：

```java
Random random = new Random();
Scanner scanner = new Scanner(System.in);

while (true) {
    int answer = random.nextInt(100) + 1;
    // 读取和判断猜测
}
```

这两个新文件都位于 `src/main/java/hl`，因为它们是可运行的正式 Java 源码，并且声明了 `package hl;`。

## 十六、IntelliJ IDEA 实用代码快速生成

IntelliJ IDEA 中常见的快速生成代码功能主要分为两类：

1. Live Templates：先输入缩写，再按 `Tab`，例如 `psvm` 和 `sout`。
2. Postfix Completion：先写表达式，再输入点号和后缀，例如 `name.sout`。

如果忘记缩写，可以在当前代码位置按 `Ctrl+J`，IDEA 会显示此处可以使用的 Live Templates。

### Live Templates 的使用方法

在合适的 Java 代码位置输入缩写，然后按 `Tab`：

```text
缩写 + Tab
```

模板中有多个待填写位置时，可以继续按 `Tab` 跳到下一处，使用 `Shift+Tab` 可以回到上一处。

### main 或 psvm：生成主方法

输入 `main` 或 `psvm` 后按 `Tab`：

```java
public static void main(String[] args) {

}
```

我在 `psvm.java` 中已经实际使用了这个模板：

```java
public class psvm {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
```

类名通常应该表达类的功能并使用大驼峰命名，因此练习结束后可以把 `psvm` 改成类似 `TemplatePractice` 的名字。

### soutv：输出最近的变量名和值

假设前面有一个变量：

```java
int score = 95;
```

输入 `soutv` 后按 `Tab`，IDEA 会根据当前上下文生成类似代码：

```java
System.out.println("score = " + score);
```

它比普通 `sout` 更适合调试变量，因为输出中同时包含变量名和值。

### soutm：输出当前类名和方法名

在方法中输入 `soutm` 后按 `Tab`，会生成用于标记当前执行位置的输出语句，内容包含当前类名和方法名。

它适合初学阶段观察程序执行到了哪个方法。不过正式调试时，更推荐使用断点或日志，而不是保留大量临时输出。

### soutp：输出方法参数

例如有一个方法：

```java
public static void checkScore(int score, String name) {
    soutp
}
```

在方法体中把 `soutp` 展开后，IDEA 会生成包含参数名和参数值的输出语句。它适合检查调用方法时实际传入了哪些数据。

### fori：生成计数 for 循环

输入 `fori` 后按 `Tab`，会生成类似代码：

```java
for (int i = 0; i < length; i++) {

}
```

继续按 `Tab` 可以在索引变量、循环上限和循环体之间移动。它适合数组下标遍历或明确循环次数的场景。

### iter：生成增强 for 循环

当前作用域中已经有数组或集合时，输入 `iter` 后按 `Tab`，IDEA 会选择可遍历的变量并生成增强 `for` 循环。

例如：

```java
String[] names = {"张三", "李四"};
```

展开 `iter` 后可以得到类似代码：

```java
for (String name : names) {

}
```

增强 `for` 适合只关心每个元素、不需要数组下标的情况。

### itar：按下标遍历数组

当作用域中存在数组时，输入 `itar` 后按 `Tab`，IDEA 会生成基于下标的数组循环，例如：

```java
for (int i = 0; i < names.length; i++) {
    String name = names[i];
}
```

如果需要倒序遍历数组，可以尝试 `ritar`：

```java
for (int i = names.length - 1; i >= 0; i--) {
    String name = names[i];
}
```

### ifn：快速生成 null 判断

当前作用域存在引用类型变量时，输入 `ifn` 后按 `Tab`，可以生成空值判断：

```java
if (value == null) {

}
```

`null` 表示变量当前没有指向实际对象。基本类型，例如 `int`、`double` 和 `boolean`，不能与 `null` 比较。

### psfs：生成字符串常量

在类中输入 `psfs` 后按 `Tab`：

```java
public static final String NAME = "";
```

它适合定义不会变化、可以被类直接使用的字符串常量。Java 常量名通常使用全大写字母，多个单词用下划线连接。

### Postfix Completion 后缀补全

Postfix Completion 不只是插入固定代码，它会包装或转换已经写好的表达式。基本用法是：

```text
表达式.后缀 + Tab
```

### 表达式.sout：直接输出表达式

输入：

```java
score.sout
```

按 `Tab` 后变成：

```java
System.out.println(score);
```

也可以用于计算表达式：

```java
(a + b).sout
```

展开为：

```java
System.out.println(a + b);
```

### 表达式.var：接住表达式的结果

输入：

```java
new Random().var
```

按 `Tab` 后，IDEA 会推断类型并生成局部变量，例如：

```java
Random random = new Random();
```

这在创建 `Scanner`、`Random` 或接收方法返回值时非常实用：

```java
new Scanner(System.in).var
```

展开后类似：

```java
Scanner scanner = new Scanner(System.in);
```

需要的 `import` 通常也可以由 IDEA 自动补充。

### 条件.if：把表达式包装成 if

输入：

```java
score >= 60.if
```

按 `Tab` 后变成：

```java
if (score >= 60) {

}
```

使用后缀补全时可以一直向右输入，不需要先回到表达式左侧写 `if (`。

### 实用程度排序

现阶段建议优先记住：

| 缩写 | 用途 |
| --- | --- |
| `main` / `psvm` | 生成主方法 |
| `sout` | 生成普通输出语句 |
| `soutv` | 输出变量名和值 |
| `fori` | 生成普通计数循环 |
| `iter` | 遍历数组或集合 |
| `ifn` | 判断引用是否为 `null` |
| `.sout` | 输出已经写好的表达式 |
| `.var` | 用变量接住表达式结果 |
| `.if` | 把布尔表达式包装成 `if` |

### 查看和设置模板

打开设置：

```text
Ctrl+Alt+S -> Editor -> Live Templates
```

这里可以查看、启用、修改和新建 Live Templates。

Postfix Completion 的设置位置是：

```text
Ctrl+Alt+S -> Editor -> General -> Postfix Completion
```

不同 IDEA 版本、插件和代码位置能使用的模板可能不同。以设置页面和在当前代码位置按 `Ctrl+J` 显示的列表为准。

### psvm.java 代码检查

当前 `psvm.java` 已成功用快捷模板生成 `main` 和输出语句。文件中导入了 `Scanner`，但暂时没有使用：

```java
import java.util.Scanner;
```

IDEA 会把未使用的导入显示为灰色。可以删除它，或者在后续加入键盘输入代码时再保留。

## 十七、Java 花括号与代码层级

在 `psvm.java` 第 11 到 13 行中：

```java

    }
}
```

- 第 11 行是空行，只用于分隔代码，对程序运行没有影响。
- 第 12 行的 `}` 结束 `main` 方法。
- 第 13 行的 `}` 结束 `psvm` 类。

结合完整结构理解：

```java
public class psvm {                 // 打开类的代码块
    public static void main(String[] args) { // 打开 main 方法的代码块
        System.out.println("hello");
    }                               // 关闭 main 方法
}                                   // 关闭 psvm 类
```

Java 使用 `{` 打开一个代码块，使用 `}` 关闭这个代码块。花括号必须成对出现，并且按嵌套顺序从内向外关闭。

可以把结构看成：

```text
psvm 类
└── main 方法
    └── 方法中的执行语句
```

IDEA 会根据花括号自动缩进代码。把光标放到一个花括号旁边时，IDEA 还会高亮与它配对的另一个花括号，便于检查层级。

## 十八、遍历 main 方法的 args 数组

`psvm.java` 第 11 到 13 行是增强 `for` 循环：

```java
for (String arg : args) {

}
```

它遍历的是 `main` 方法中的 `args`：

```java
public static void main(String[] args)
```

`args` 的类型是 `String[]`，表示字符串数组，用于保存启动 Java 程序时传入的命令行参数。

增强 `for` 的结构是：

```java
for (元素类型 临时变量 : 要遍历的数组或集合) {
    // 使用当前元素
}
```

因此：

```java
for (String arg : args)
```

可以理解为：“从 `args` 中依次取出每一个字符串，并把当前字符串暂时命名为 `arg`”。

当前循环体是空的，所以程序虽然会依次取出参数，但不会进行输出或其他处理。可以增加：

```java
for (String arg : args) {
    System.out.println(arg);
}
```

例如在 IDEA 的运行配置中传入程序参数：

```text
Java 100 hello
```

那么 `args` 中的内容相当于：

```java
String[] args = {"Java", "100", "hello"};
```

循环会依次输出：

```text
Java
100
hello
```

如果运行程序时没有填写程序参数，`args` 是长度为 `0` 的空数组，循环一次也不会执行。`args` 通常不是 `null`。

下面由 `itar` 生成的代码也在遍历同一个 `args` 数组：

```java
for (int i = 0; i < args.length; i++) {
    String arg = args[i];
}
```

两种遍历方式的区别：

| 写法 | 是否有下标 `i` | 适用情况 |
| --- | --- | --- |
| `for (String arg : args)` | 没有 | 只需要读取每个参数 |
| `for (int i = 0; i < args.length; i++)` | 有 | 需要参数的位置或下标 |

当前文件中的两段循环功能重复，练习时可以保留用于比较；实际代码通常根据是否需要下标选择其中一种。

另外，直接执行：

```java
System.out.println("args = " + args);
```

通常会输出数组的类型和哈希信息，而不是数组内容。要查看参数内容，应使用：

```java
System.out.println("args = " + Arrays.toString(args));
```

## 十九、Maven POM 被 IDEA 标记为已忽略

### 现象

在 IntelliJ IDEA 中卸载或移除模块，再重新导入后，`pom.xml` 可能在 Maven 工具窗口或 Project 窗口中显示为灰色，并标记为“已忽略”。

这通常是 IDEA 的 Maven 导入状态，不代表 `pom.xml` 被删除或损坏，也不一定是 Git 忽略。

### 为什么会变成已忽略

IDEA 中有几个容易混淆的操作：

- Unload Module：暂时卸载模块，IDEA 不再分析和编译该模块。
- Ignore Project：Maven 项目仍显示在 Maven 窗口中，但 IDEA 停止导入它的模块、源码目录和 Maven 目标。
- Unlink Maven Project：解除 POM 与当前 IDEA 项目的关联。
- 从 Project Structure 中移除 Maven 子模块：IDEA 可能将该 Maven 项目设为忽略，以免重新同步时立即把它导入回来。

所以，卸载或移除模块之后重新导入，如果旧的忽略状态仍保存在 `.idea` 配置中，POM 就可能继续显示为已忽略。

### 方法一：在 Maven 工具窗口取消忽略

1. 打开 `View -> Tool Windows -> Maven`。
2. 打开 Maven 窗口的选项菜单，启用 `Show Ignored Projects`。
3. 找到显示为灰色的 Maven 项目。
4. 右键项目，选择 `Unignore Project`。
5. 点击 `Reload All Maven Projects` 重新加载。

### 方法二：从 Maven 设置中取消忽略

打开：

```text
Ctrl+Alt+S
-> Build, Execution, Deployment
-> Build Tools
-> Maven
-> Ignored Files
```

如果目标 `pom.xml` 前面的复选框被选中，将其取消，然后点击 `Apply` 和 `OK`。

同时检查 Path patterns 中是否存在范围过大的规则，例如：

```text
*
```

这种规则会忽略所有 POM。

### 方法三：POM 已经从 Maven 窗口消失

如果 Maven 工具窗口中完全看不到项目，说明它可能已经被解除关联：

1. 打开 Maven 工具窗口。
2. 点击 `Link Maven Projects` 或加号按钮。
3. 选择当前项目根目录下的 `pom.xml`。
4. 确认后点击重新加载按钮。

也可以在 Project 窗口中右键 `pom.xml`，根据当前 IDEA 版本选择 `Add as Maven Project` 或 `Load Maven Project`。

### 方法四：模块仍处于卸载状态

如果 POM 已经恢复，但源码仍然不可用：

1. 在 Project 窗口中右键模块。
2. 选择 `Load/Unload Modules`。
3. 将需要使用的模块移动到 Loaded Modules。
4. 点击 `OK`，再重新加载 Maven 项目。

### Maven 忽略与 Git 忽略的区别

| 类型 | 影响 |
| --- | --- |
| Maven Ignore | IDEA 不导入该 POM 对应的 Maven 项目 |
| Unload Module | IDEA 暂时不分析、不搜索或不编译该模块 |
| Git Ignore | Git 不跟踪匹配的未跟踪文件 |

可以用下面的命令检查 `pom.xml` 是否被 Git 忽略：

```powershell
git check-ignore -v JAVA/day1/pom.xml
```

如果没有输出，说明它没有被 Git 忽略。

### 当前项目检查结果

本次检查发现：

- `JAVA/day1/pom.xml` 已经被 Git 跟踪，没有被 Git 忽略。
- `day1/pom.xml` 已在 IDEA 的 Maven `originalFiles` 列表中。
- `day1/pom.xml` 不在 IDEA 的 Maven `ignoredFiles` 列表中。
- 当前被 IDEA Maven 配置忽略的是两个 `day2/pom.xml` 路径，不是 `day1/pom.xml`。

因此当前 `day1` Maven 项目在配置层面已经恢复，不需要重新创建 `pom.xml`。如果界面仍显示旧的灰色状态，可以执行 `Unignore Project` 和 `Reload All Maven Projects`，或者等待 IDEA 完成项目分析。

验证时 Maven 已经成功读取 `pom.xml` 并进入 Java 编译阶段，这也说明 POM 当前有效。此次构建失败来自 `psvm.java` 中新出现的内部包导入：

```java
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
```

当前项目的 JDK 中没有这个包，而且代码也没有使用它。这个错误与 POM 的忽略状态无关；删除该无效导入后即可继续验证编译。
