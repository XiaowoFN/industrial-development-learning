# Java Day 2 学习记录

- 学习日期：2026-08-18
- 项目目录：`JAVA/day2`
- Java 版本：Java 8
- 构建工具：Maven

## 一、今日代码概览

今天在 `hw` 包中创建了三个 Java 类：

| 文件 | 类名 | 当前功能 |
| --- | --- | --- |
| `src/main/java/hw/hw.java` | `hw` | 输出一次 `Hello World` |
| `src/main/java/hw/gee.java` | `gee` | 输出一次 `Hello World` |
| `src/main/java/hw/goolenew.java` | `goolenew` | 连续输出两次 `Hello World` |

三个程序都包含可以独立运行的 `main` 方法。例如：

```java
package hw;

public class hw {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

## 二、包、类和 main 方法

`package hw;` 表示这些类属于 `hw` 包。源文件位于：

```text
src/main/java/hw/
```

目录名 `hw` 与包名 `hw` 保持一致。类的完整名称由“包名 + 类名”组成，例如：

```text
hw.hw
hw.gee
hw.goolenew
```

`public static void main(String[] args)` 是 Java 程序的入口。每个类都有自己的 `main` 方法，因此可以分别运行三个类。

## 三、使用 println 输出内容

下面的语句会向控制台输出一行文字，并在末尾自动换行：

```java
System.out.println("Hello World");
```

`goolenew.java` 连续调用了两次 `println`：

```java
System.out.println("Hello World");
System.out.println("Hello World");
```

所以运行结果是：

```text
Hello World
Hello World
```

这说明 Java 会按照代码从上到下的顺序执行方法中的语句。

## 四、Maven 项目配置

`pom.xml` 定义了当前 Maven 项目的基本信息：

```xml
<groupId>day2</groupId>
<artifactId>day2</artifactId>
<version>1.0-SNAPSHOT</version>
```

项目将源代码版本和目标字节码版本都设置为 Java 8，并使用 UTF-8 编码：

```xml
<maven.compiler.source>8</maven.compiler.source>
<maven.compiler.target>8</maven.compiler.target>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
```

这表示代码应使用 Java 8 支持的语法进行编写，Maven 编译时也会生成兼容 Java 8 的字节码。

## 五、源码与编译产物

Java 源码保存在 `src/main/java` 中，文件扩展名是 `.java`。Maven 编译后生成的字节码位于 `target/classes`，文件扩展名是 `.class`：

```text
src/main/java/hw/hw.java  -> target/classes/hw/hw.class
src/main/java/hw/gee.java -> target/classes/hw/gee.class
src/main/java/hw/goolenew.java -> target/classes/hw/goolenew.class
```

`.java` 文件供开发者阅读和修改，`.class` 文件由 JVM 执行。`target` 是构建生成目录，通常不直接修改其中的文件。

## 六、代码规范提示

当前代码可以正常表达练习内容，但 Java 类名通常使用大驼峰命名法。按照常见规范，可以将类名写成：

```text
hw       -> Hw
gee      -> Gee
goolenew -> GooleNew（如果它由两个单词组成）
```

公开类改名时，源文件名也必须同步修改，例如 `Gee` 类应保存在 `Gee.java` 中。

## 七、Gitee 2FA 与旧口令推送验证

今天完成了以下验证：

> 更换新的双因素认证（2FA）方式后，原有口令仍然可以用于向 Gitee 推送代码。

这次验证说明，更换账号的 2FA 验证方式不会自动让已经签发的 Git 推送凭据失效。2FA 主要保护账号登录过程，而 Git 命令行推送通常使用私人令牌或其他 Git 凭据进行认证；两者是不同的认证环节。

安全注意事项：

1. 不要把真实口令、私人令牌或验证码写进代码、笔记或 Git 提交。
2. 如果旧口令不应继续使用，需要到 Gitee 的账号安全设置中主动撤销或重新生成相应凭据。
3. 凭据一旦怀疑泄露，应立即撤销，不能只依靠更换 2FA 来使其失效。

## 八、今日总结

今天创建并编译了一个 Java 8 Maven 项目，练习了包声明、类、`main` 方法和 `System.out.println()`，并观察了源码与 `.class` 编译产物之间的对应关系。同时验证了 Gitee 的 2FA 与 Git 推送凭据是两个不同的认证环节：更换 2FA 后，原有推送口令仍可能保持有效。

后续学习时，将先读取 `JAVA/day2` 下的现有代码，再把新增问题、代码变化、原理说明和验证结果继续补充到本文件中。

## 九、栈中的引用与堆中的对象

图片中的代码是：

```java
Person person = new Person();
```

可以把这条语句分成两部分理解：

```text
person              new Person()
栈中的局部变量  ->  堆中的 Person 对象
```

- `Person person` 声明了一个 `Person` 类型的引用变量 `person`。当它是方法中的局部变量时，可以用初学阶段的模型理解为存放在当前方法的栈帧中。
- `new Person()` 在堆中创建一个 `Person` 对象。
- `=` 把新对象的引用赋给 `person`，所以可以通过 `person` 找到并操作这个对象。
- `person` 保存的是对象的引用，不是对象本身，也不应简单理解为可以直接查看和使用的内存地址。

### 与当前数组代码的对应关系

`shuzu.java` 中的代码遵循相同的模型：

```java
int[] arr = new int[5];
```

它可以拆分为：

```text
int[] arr           new int[5]
栈中的局部变量  ->  堆中的 int 数组对象
```

`arr` 是局部引用变量，指向由 `new int[5]` 创建的数组对象。数组的五个元素属于数组对象，因此存放在堆中的数组内部。Java 会为新建的 `int` 数组填充默认值 `0`，所以赋值前：

```java
System.out.println(arr[0]); // 0
System.out.println(arr[1]); // 0
System.out.println(arr[2]); // 0
```

执行下面的代码后，修改的是堆中数组对象对应下标位置的值：

```java
arr[1] = 1;
arr[2] = 2;
arr[3] = 5;
```

此时数组内容相当于：

```text
[0, 1, 2, 5, 0]
```

### 直接输出数组引用

当前代码包含：

```java
System.out.println(arr);
```

这种写法通常会输出类似 `[I@1b6d3586` 的内容，而不是数组中的五个元素：

- `[I` 表示这是一个 `int[]` 类型的对象。
- `@` 后面是对象哈希值的十六进制形式。
- 这段内容不是可以当作真实内存地址使用的值。

要查看数组内容，可以使用：

```java
import java.util.Arrays;

System.out.println(Arrays.toString(arr));
```

输出为：

```text
[0, 1, 2, 5, 0]
```

### 多个引用可以指向同一个对象

```java
Person person1 = new Person();
Person person2 = person1;
```

这里没有创建第二个 `Person` 对象。`person1` 和 `person2` 保存了同一个对象的引用，通过任意一个引用修改对象，另一个引用都能观察到修改结果。

如果执行：

```java
person1 = null;
```

只是让 `person1` 不再指向该对象；只要 `person2` 仍然指向它，该对象就仍然可以使用。只有当对象不再能被任何有效引用访问时，它才具备被垃圾回收器回收的条件。

### 需要注意的边界

“局部变量在栈中、`new` 出来的对象在堆中”是理解 Java 引用关系的常用入门模型。实际运行时，JVM 可能通过逃逸分析等技术进行优化，但这不会改变 Java 代码中“引用指向对象”的语义。

## 十、数组引用赋值、空指针与遍历

### arr2 与 arr 指向同一个数组

`shuzu.java` 新增了下面的代码：

```java
int[] arr2 = arr;
arr2[0] = 199;
arr2[1] = 299;
```

`arr2 = arr` 复制的是数组引用，不是数组中的五个元素，也没有创建新数组。赋值完成后，`arr` 和 `arr2` 指向堆中的同一个数组对象：

```text
arr  ──┐
       ├──> [199, 299, 2, 5, 0]
arr2 ──┘
```

因此，通过 `arr2` 修改元素后，再通过 `arr` 读取，也会得到修改后的值：

```java
System.out.println(arr2[0]); // 199
System.out.println(arr2[1]); // 299
System.out.println(arr[0]);  // 199
System.out.println(arr[1]);  // 299
```

更准确的说法是“两个引用指向同一个数组对象”，而不是程序员能够直接操作某个真实内存地址。

### arr3 是一个新的独立数组

```java
int[] arr3 = new int[5];
```

这次使用了 `new`，所以会创建另一个独立的数组对象。`arr3` 与 `arr`、`arr2` 的关系是：

```text
arr  ──┐
       ├──> [199, 299, 2, 5, 0]
arr2 ──┘

arr3 ─────> [0, 0, 0, 0, 0]
```

修改 `arr3` 不会影响 `arr`，修改 `arr` 也不会影响 `arr3`。当前代码在声明 `arr3` 后执行的是：

```java
System.out.println(arr[0]);
```

所以这里输出的仍然是旧数组中的 `199`，并没有读取 `arr3`。如果要验证新数组的默认值，应写成：

```java
System.out.println(arr3[0]); // 0
```

### null 与 NullPointerException

当前代码用注释保留了下面的练习：

```java
arr3 = null;
System.out.println(arr3[0]);
```

`arr3 = null` 表示 `arr3` 不再指向任何数组对象。`null` 不是数组，也不能访问元素，因此执行 `arr3[0]` 会抛出：

```text
java.lang.NullPointerException
```

需要区分两种常见异常：

| 情况 | 示例 | 异常 |
| --- | --- | --- |
| 引用为 `null` | `arr3[0]` | `NullPointerException` |
| 下标超出范围 | `arr[5]` | `ArrayIndexOutOfBoundsException` |

长度为 `5` 的数组，有效下标是 `0` 到 `4`。

### 使用 length 遍历数组

代码使用普通 `for` 循环遍历数组：

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

执行过程如下：

1. `i` 从 `0` 开始，对应数组的第一个下标。
2. `i < arr.length` 保证下标不会到达数组长度，从而避免越界。
3. 每轮使用 `arr[i]` 读取一个元素，然后执行 `i++`。
4. 当前数组长度为 `5`，循环会依次访问下标 `0、1、2、3、4`。

经过前面的赋值后，这次循环依次输出：

```text
199
299
2
5
0
```

数组的 `length` 是固定长度属性，写法是 `arr.length`，后面没有小括号。

### fangfa.java 当前状态

今天还创建了一个用于后续方法练习的类：

```java
package hw;

public class fangfa {
}
```

这个类目前没有字段、方法或 `main` 入口，可以通过编译，但不能作为普通 Java 程序直接运行。后续可以在其中练习方法的定义、参数、返回值和调用。
