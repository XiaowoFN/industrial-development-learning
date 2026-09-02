# Java 学习记录：day5

## 记录约定

- 每次说“记录”时，先检查 `day5/src/main/java` 下最近新增或修改的代码。
- 记录代码功能、关键语法、运行结果、问题和当前学习进度。

## 2026-09-01

### 1. `arraylistbasic.java`：从数组过渡到集合

当前文件开始学习集合基础。提出的问题是：既然数组长度固定，遇到考试缺席等情况不方便，为什么不所有场景都直接使用集合？

### 2. 数组和集合的选择

数组和集合都可以保存多个数据，但设计目标不同。

| 对比项 | 数组 | 集合（如 `ArrayList`） |
|---|---|---|
| 长度 | 创建后固定 | 通常可以动态增加或删除 |
| 存储类型 | 可以直接保存基本数据类型 | 主要保存对象，基本类型需要使用包装类型，如 `Integer` |
| 操作 | 通过索引访问，语法简单 | 提供 `add`、`remove`、`contains` 等丰富方法 |
| 性能和内存 | 结构简单、开销小、访问快 | 功能更多，但有对象和扩容等额外开销 |
| 适用场景 | 数据数量已知且不会变化 | 数据数量不确定，或者经常增删 |

数组有局限性，但不是没有意义。

### 3. 数组存在的意义

如果数据数量固定，数组能直接表达“固定数量的数据”：

```java
int[] monthSales = new int[12];
int[] point = new int[2];
```

数组还可以直接保存 `int`、`double`、`boolean` 等基本类型：

```java
int[] scores = {90, 85, 96};
```

数组结构简单、按索引访问速度快，适合大量数值计算、二维表格、图像数据和底层算法。很多 Java API 也直接要求或返回数组。

### 4. 什么时候使用集合

以下情况更适合 `ArrayList`：数据数量事先不知道、数据会不断添加或删除、需要方便查找或批量操作。

考试中只记录实际到场学生时，人数不确定，使用集合更自然：

```java
ArrayList<Integer> scores = new ArrayList<>();
scores.add(90);
scores.add(85);
```

有人缺席时不添加成绩即可，不需要留下空位置。`ArrayList<Integer>` 保存的是 `Integer` 对象，传入 `int` 时会自动装箱。

### 5. 缺席学生时数组也不是完全不能用

数组可以预留容量，再用 `count` 记录有效数据数量：

```java
int[] scores = new int[100];
int count = 0;
scores[count++] = 90;
scores[count++] = 85;
```

如果数组不够，还可以创建新数组并复制旧数据。不过这相当于手动实现集合的动态扩容，代码更麻烦，所以实际开发中通常使用集合。

用特殊值表示缺席也可能产生歧义，例如 `0` 既可能表示缺席，也可能是合法成绩。

### 6. 数组和集合的判断标准

```text
数量固定、只按索引访问、追求简单和性能 -> 数组
数量不确定、需要增删和丰富操作       -> 集合
```

集合底层通常仍然需要数组等结构来保存数据；集合只是把扩容、移动元素等工作交给类库处理，并不代表数组没有用。

### 7. day5 学习进度

```text
[已完成] 认识集合要解决的问题
[已完成] 理解数组长度固定的特点
[已完成] 能根据固定/动态数据选择数组或集合
[已完成] 了解 ArrayList 保存对象以及基本类型自动装箱
[进行中] ArrayList 的创建、add、remove、get、size 和遍历
```

### 8. IDEA 项目配置：Name、SDK、Language level、Compiler output

截图中的配置通常位于 IDEA 的 Project Structure 或模块设置中。

#### Name

```text
industrial-development-learning
```

表示当前项目或模块的名称，主要用于 IDEA 中识别和显示项目。本身不会决定 Java 代码如何运行。

#### SDK

```text
dragonwell-11 Alibaba Dragonwell 11.0.31
```

SDK 是项目使用的 Java 开发工具包（JDK）。它包含编译器 `javac`、运行工具和 Java 类库。这里选择的是阿里 Dragonwell JDK 11.0.31，说明项目使用 Java 11 的 JDK 进行编译和运行。

`SDK` 和 `Language level` 不是一回事：SDK 是实际使用的 JDK，Language level 是允许代码使用的语法级别。

#### Language level

```text
11 - Local variable syntax for lambda parameters
```

表示项目按照 Java 11 级别检查语法。Java 11 支持在 Lambda 参数中使用 `var`，例如：

```java
var list = new ArrayList<String>();
list.forEach((var item) -> System.out.println(item));
```

学习基础语法时，使用与 JDK 一致的语言级别即可。若语言级别高于实际 JDK，可能出现代码能编辑但无法编译的问题。

#### Compiler output

```text
E:\study\industrial-development-learning\out
```

表示 IDEA 直接编译项目时，把生成的 `.class` 字节码文件放到这个目录，而不是放在源代码目录中。源代码仍在 `src` 下，`.class` 是给 JVM 执行的编译结果。

Maven 项目通常还会使用自己的输出目录，例如 `target/classes`；实际以当前构建工具和运行配置为准。编译生成的目录一般不应提交到 Git，可以在 `.gitignore` 中忽略：

```gitignore
**/target/
**/out/
```

### 9. 配置选择的简单判断

```text
Name             项目/模块叫什么
SDK              用哪个 JDK 编译和运行
Language level   代码允许使用哪些 Java 语法
Compiler output  编译后的 .class 文件放哪里
```

### 10. JDK 8 和 Language level 26 的区别

不能把“JDK 8”简单理解成“打开 Language level 26 就拥有 Java 26”。两者负责的事情不同：

```text
JDK/SDK       真正提供编译器、运行环境和 Java 类库
Language level IDEA 编辑器允许书写和检查的语法级别
API           编译时和运行时可以调用的类、方法和字段
字节码版本    编译后 .class 文件要求什么版本的 JVM 执行
```

如果 SDK 是 JDK 8，但 Language level 选择 26：

- IDEA 可能允许编辑器暂时显示或检查较新的语法。
- 真正编译时，JDK 8 的 `javac` 不认识 Java 9 以后新增的语法，使用这些语法通常会编译失败。
- JDK 8 没有 Java 26 新增的 API，即使语法能通过，调用新 API 也会找不到类或方法。
- JDK 8 生成的编译结果也不能凭设置变成 Java 26 的运行环境。
- Maven 的 `pom.xml`、实际编译器和运行配置还可能覆盖 IDEA 页面中的设置。

因此，下面这种组合不是真正的 Java 26 开发环境：

```text
SDK: JDK 8
Language level: 26
```

想使用 Java 26 的语法和 API，应安装并选择 JDK 26，同时把 Language level 设置为 26：

```text
SDK: JDK 26
Language level: 26
```

反过来，如果目标是让程序运行在 JDK 8 上，可以使用较新的 JDK 编译器，但要把项目的语言级别和发布目标设为 8，并且只使用 Java 8 API。例如使用 `javac --release 8` 可以同时约束语法、字节码目标和可使用的标准 API。

```text
较新 JDK 编译器 + --release 8 -> 生成可在 JDK 8 上运行的程序
JDK 8 编译器 + Language level 26 -> 不能获得 Java 26 能力
```

在 IDEA 中，最终还应检查 `Settings -> Build, Execution, Deployment -> Compiler -> Java Compiler` 和 Maven `pom.xml` 中的 `source`、`target` 或 `release` 配置，避免页面设置和实际构建设置不一致。

### 11. 学习 Java 和后端框架的版本选择

课程使用 JDK 11 时，学习阶段建议先完全跟随课程：

```text
Project SDK: JDK 11
Language level: 11
Maven release/source/target: 11（如果 pom.xml 有配置）
```

这样可以避免因为 JDK、语法级别、依赖版本不一致而出现额外错误。学习 Java 基础语法不需要为了追新版本频繁切换。

选择后端框架时，先看课程使用的 Spring Boot 版本：

- Spring Boot 2.x 的老课程常见 JDK 8 或 JDK 11，课程用 11 就使用 11。
- Spring Framework 6 及基于它的 Spring Boot 3.x 需要 Java 17 或更高版本。
- 当前 Spring Boot 4.x 的最低要求也是 Java 17，支持到 Java 26；新项目可以使用 JDK 21 或 JDK 25，但要确认课程依赖和插件兼容。

当前较稳妥的学习路线：

```text
跟课程学习基础和 Spring Boot 2.x -> JDK 11 + Language level 11
学习 Spring Boot 3.x            -> JDK 17 或 JDK 21 + 对应语言级别
新建现代后端项目                -> 优先考虑 JDK 21 LTS；确认生态支持后再考虑 JDK 25
```

JDK 25 是当前 Java 的最新 LTS，JDK 21 是前一个 LTS；JDK 26 是普通发布版本。学习和生产项目通常优先选择 LTS，除非课程或项目明确要求其他版本。

最重要的原则是：

```text
语法学习阶段：版本和课程保持一致
框架学习阶段：版本服从框架最低要求和课程依赖
实际项目阶段：优先选择团队统一的 LTS 版本
```

Spring Framework 6 的官方要求是 Java 17+；Spring Boot 4.1.1 的官方系统要求是至少 Java 17。[Spring Framework 要求](https://docs.spring.io/spring-framework/reference/overview.html) [Spring Boot 系统要求](https://docs.spring.io/spring-boot/system-requirements.html) Oracle 当前将 Java 25 列为最新 LTS、Java 21 列为前一个 LTS。[Oracle Java 下载页](https://www.oracle.com/java/technologies/downloads/)

### 12. 若依项目的 JDK 版本判断

“若依”有多个版本和分支，不能只根据项目名称决定 JDK：

```text
RuoYi Spring Boot 2.x -> JDK 8+
RuoYi Spring Boot 3.x -> JDK 17+
RuoYi Spring Boot 4.x -> JDK 17+
```

官方若依文档列出了并行维护的 Spring Boot 2.x、3.x、4.x 分支，其中 Spring Boot 2.x 分支支持 JDK 8+，Spring Boot 3.x 和 4.x 分支要求 JDK 17+。[若依官方仓库说明](https://github.com/yangzongzhuan/RuoYi) [若依官方文档](https://doc.ruoyi.vip/ruoyi/)

公司项目应以项目本身的配置为准，检查以下位置：

1. `pom.xml` 中的 `<java.version>`、`<maven.compiler.source>`、`<maven.compiler.target>` 或 `<maven.compiler.release>`。
2. `pom.xml` 中的 Spring Boot 版本。
3. 项目的 README、启动脚本、Dockerfile 或部署文档。
4. IDEA 的 Project SDK、Maven Runner JDK，以及服务器上的 `java -version`。

若依老项目常见组合是 JDK 8/11 + Spring Boot 2.x；若依升级到 Spring Boot 3.x 或使用较新的 RuoYi-Vue-Plus，通常需要 JDK 17 或 21。不能用 JDK 11 强行运行要求 JDK 17 的项目。

对当前学习的建议：

```text
day5 跟课程学习 Java 和集合 -> 继续 JDK 11 + Language level 11
公司若依项目             -> 打开它的 pom.xml，按项目要求单独配置
不要为了公司项目修改课程项目的 JDK
```

电脑上可以同时安装多个 JDK，IDEA 为不同项目选择不同 SDK；项目之间不会因为分别使用 JDK 11、17 或 21 而互相影响。

### 13. 公司项目：JDK 1.8，但 Language level 显示 11

如果公司项目显示：

```text
SDK: JDK 1.8
Language level: 11
```

需要区分“IDEA 的语法提示设置”和“真正执行编译的 JDK”。JDK 8 的编译器不能编译 Java 11 的新语法，例如 Java 11 的 Lambda 参数 `var` 写法；如果项目确实用 JDK 8 编译，使用这些语法通常会失败。

可能的情况有三种：

1. Language level 只是 IDEA 设置，实际项目代码仍然只使用 Java 8 语法。
2. IDEA 使用 JDK 8，但 Maven 编译器实际使用了 JDK 11；需要检查 Maven Runner 和 `mvn -version`。
3. 项目配置不一致，页面显示 11，但 `pom.xml`、编译器或服务器运行环境仍按 Java 8 工作。

排查时分别执行：

```bash
java -version
mvn -version
```

并查看 `pom.xml` 中的：

```xml
<java.version>...</java.version>
<maven.compiler.source>...</maven.compiler.source>
<maven.compiler.target>...</maven.compiler.target>
<maven.compiler.release>...</maven.compiler.release>
```

如果线上运行环境必须是 JDK 8，稳妥配置通常是：

```text
编译 JDK：JDK 8 或使用较新 JDK 编译并 --release 8
Language level：8
目标字节码：8
只能使用 Java 8 API
```

如果公司确实要求使用 Java 11 语法，那么编译环境至少要使用 JDK 11；同时线上运行环境也应升级到 JDK 11，不能由 JDK 8 运行 Java 11 特性编译出的程序。

### 14. 根据公司项目确定学习版本

公司项目运行在 JDK 8 时，建议把 **Java 8 作为兼容基线**：先熟练掌握 Java 8 的基础语法、面向对象、集合、异常、IO、线程和常用 API。课程使用 JDK 11 不必因此停下来，Java 8 和 Java 11 的绝大多数基础写法相同；跟课时可以使用 JDK 11，但要知道哪些语法是 Java 11 新增的。

建议在电脑上同时保留两个环境：

```text
day5 课程练习       JDK 11 + Language level 11
公司项目兼容练习    JDK 8 + Language level 8
```

这样既不会破坏课程环境，也能练习公司项目要求的 Java 8 兼容性。写给公司项目的代码，尽量只使用 Java 8 语法和 Java 8 API；必要时使用 `mvn --version`、`java -version` 检查实际运行环境。

### 15. 学会一个版本后，升级是否容易

Java 语言本身的升级通常是渐进式的。基础知识掌握后，从 Java 8 了解 Java 11、17、21 的新特性不会从头开始，主要是增加新的语法和 API，例如：

```text
Java 8  -> Lambda、Stream、接口默认方法
Java 10 -> 局部变量类型推断 var
Java 11 -> Lambda 参数中的 var 语法
Java 14/15 -> switch 表达式、文本块
Java 16/17 -> record、sealed class、instanceof 模式匹配
Java 21 -> record pattern、switch 模式匹配
```

但“版本升级容易”主要针对 Java 语言基础，不代表所有后端项目升级都简单。还要注意：

- Spring Boot 2.x 到 3.x 通常需要 JDK 17+。
- `javax.*` 迁移到 `jakarta.*` 会带来代码和依赖修改。
- Spring Security、MyBatis、数据库驱动、Maven 插件等依赖也可能有不兼容变更。
- 字节码版本、容器镜像和服务器 JDK 必须与编译目标匹配。

因此当前路线是：

```text
先以 Java 8 为兼容基线学通基础
-> 按课程使用 JDK 11 学习集合和后端入门
-> 再集中了解 Java 17/21 的新特性
-> 框架升级时单独学习版本迁移点
```

### 16. Spring Boot 不同版本的学习难度

Spring Boot 不同版本的核心思想没有完全改变，主要概念都能迁移：

```text
IoC / DI -> 自动配置 -> Starter 依赖 -> MVC 接口 -> 配置文件 -> 数据库和事务
```

真正变化较多的地方通常是：

- 最低 JDK 版本。
- Spring Boot、Spring Framework 和第三方依赖版本。
- `javax.*` 改为 `jakarta.*`。
- Spring Security 配置方式。
- 配置项名称、默认行为和构建插件。

大致可以这样理解：

```text
Spring Boot 2.x -> 常见 JDK 8/11，老若依项目较多
Spring Boot 3.x -> JDK 17+，使用 Jakarta 命名空间
Spring Boot 4.x -> JDK 17+，依赖生态继续升级
```

所以 Spring Boot 的难点主要不是“每个版本都要重新学”，而是第一次要理解较多后端概念。学会一个版本后，其他版本通常是查迁移文档、调整依赖和修改少量配置。

推荐学习方式：

1. 先完整学通课程使用的版本，不要同时对比多个版本。
2. 掌握 IoC、DI、自动配置、MVC、配置文件、MyBatis、事务和异常处理等核心概念。
3. 再学习从 Spring Boot 2.x 升级到 3.x 的差异。
4. 进入公司若依项目时，以项目 `pom.xml` 和部署 JDK 为准，不要自行升级框架版本。

对你目前的情况，若公司若依确实运行在 JDK 8，优先掌握 Spring Boot 2.x 的项目结构和开发流程；课程使用 JDK 11 也可以继续跟，重点关注课程的 Spring Boot 版本是否与公司项目一致。Spring Framework 6 要求 Java 17+，因此基于 Spring Boot 3.x 的项目不能用 JDK 8 运行。[Spring Framework 官方要求](https://docs.spring.io/spring-framework/reference/overview.html)

### 17. Spring Boot 2.x 使用 JDK 11

Spring Boot 2.x 使用 JDK 11 是可以的。以 Spring Boot 2.7.18 为例，官方要求至少 Java 8，并兼容到 Java 21，因此 JDK 11 在支持范围内。[Spring Boot 2.7 官方要求](https://docs.spring.io/spring-boot/docs/2.7.18/reference/html/getting-started.html)

需要注意的是，具体项目仍要以小版本和依赖为准：

```text
Spring Boot 2.x + JDK 11 -> 常见且正常
Spring Boot 2.x + JDK 8  -> 也可能正常
Spring Boot 3.x + JDK 11 -> 不满足最低要求
```

所以公司若依如果是 Spring Boot 2.x，JDK 11 通常没有问题；如果项目明确运行在 JDK 8，则仍要遵守项目的 Java 8 兼容要求。

### 18. `arraylisttest.java`：为什么 `inSert` 需要 `static`

`main` 方法的声明是：

```java
public static void main(String[] args)
```

`main` 是静态方法，JVM 启动它时还没有创建 `arraylisttest` 对象，因此静态方法内部没有当前对象 `this`。直接调用：

```java
inSert(array);
```

相当于想在 `main` 中调用当前对象的方法；如果 `inSert` 没有 `static`，就会出现“不能从静态上下文引用非静态方法”的错误。

加上 `static` 后：

```java
public static void inSert(ArrayList<student> array) {
    // ...
}
```

`inSert` 也属于类，可以直接从 `main` 调用。

不加 `static` 也可以，但要先创建对象，再通过对象调用：

```java
arraylisttest test = new arraylisttest();
test.inSert(array);
```

之前其他类中的方法如果是通过对象调用，例如 `s.study()`，就不需要 `static`；如果方法本身声明了 `static`，也可以直接调用。是否加 `static` 取决于调用方式，不是所有方法都必须加。

### 19. `arraylisttest.java` 中的另外两个编译注意点

集合类型必须和方法参数的泛型一致：

```java
ArrayList<student> array = new ArrayList<>();
public static void inSert(ArrayList<student> array) { }
```

读取学生信息时，Getter 是方法，必须加括号：

```java
System.out.println(array.get(i).getName() + array.get(i).getAge());
```

`getName`、`getAge` 不加 `()` 不是方法调用的正确写法。当前文件第 52 行如果写成 `array.get(i). + ...` 或 `getAge`，会继续编译报错，与 `static` 是两个独立问题。

另外，`Scanner.nextInt()` 读取数字后不会自动吃掉行尾换行符；下一次调用 `nextLine()` 可能读到空字符串。混合使用时要额外调用一次 `sc.nextLine()`，或者全部使用 `nextLine()` 后再用 `Integer.parseInt()` 转换。

### 21. `StudentManage.Management`：菜单选择后自动进入下一个功能

相关文件：`src/main/java/StudentManage/Management.java`、`Student.java`

当前菜单使用 `while (true)` 和 `switch`：

```java
switch (i) {
    case 1:
        insertStudent(studentArray);
    case 2:
        deleteStudent(studentArray);
    case 3:
        viewStudent(studentArray);
    case 4:
        break;
}
```

选择 `1` 后会自动继续执行 `case 2` 和 `case 3`，原因是每个 `case` 后都没有 `break`。这种行为叫 `switch` 的 case 穿透（fall-through）。`break` 会结束当前 `switch`，然后回到外层 `while`，重新显示菜单。

菜单功能应在每个分支末尾结束当前 `switch`：

```java
switch (i) {
    case 1:
        insertStudent(studentArray);
        break;
    case 2:
        deleteStudent(studentArray);
        break;
    case 3:
        viewStudent(studentArray);
        break;
    case 4:
        return; // 直接结束 main，退出系统
    default:
        System.out.println("没有这个选项");
}
```

注意：`case 4` 里的普通 `break` 只会跳出 `switch`，不会跳出 `while (true)`；如果想退出整个菜单循环，可以使用 `return`，或者使用一个布尔变量控制循环。

### 22. 学生管理菜单的结构问题

`studentArray` 和 `Scanner input` 当前定义在 `while` 循环内部：

```java
while (true) {
    ArrayList<Student> studentArray = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    // ...
}
```

这样每次重新显示菜单都会创建一个新的空集合，之前添加的学生会丢失；反复创建多个 Scanner 读取同一个 `System.in` 也可能造成输入缓冲问题。更合理的结构是把它们放到循环外，只创建一次：

```java
Scanner input = new Scanner(System.in);
ArrayList<Student> studentArray = new ArrayList<>();

while (true) {
    int choice = input.nextInt();
    // 根据 choice 调用功能
}
```

另外，`Student.id` 定义为 `String`，删除方法却用 `int id = sc.nextInt()` 并执行 `array.remove(id + 1)`，这实际上是按索引删除，不是按学生 id 删除。后续应改为读取字符串 id，再根据 `Student.getId()` 查找匹配对象。

### 23. `Management.java` 修正后的菜单判断

当前代码已经为 `case 1`、`case 2`、`case 3` 添加了 `break`，并将 `case 4` 改为 `return`：

```java
case 1:
    insertStudent(studentArray);
    break;
case 2:
    deleteStudent(studentArray);
    break;
case 3:
    viewStudent(studentArray);
    break;
case 4:
    return;
```

这样选择一个功能后会结束当前 `switch`，回到 `while` 顶部重新显示菜单；选择 4 则直接结束 `main`。

但当前 `studentArray` 和 `Scanner input` 仍定义在 `while` 内：

```java
while (true) {
    ArrayList<Student> studentArray = new ArrayList<>();
    Scanner input = new Scanner(System.in);
}
```

这会让每次循环都创建空集合，之前添加的学生信息无法保留。后续应把集合和 Scanner 移到 `while` 外，只创建一次。

### 18. `ArrayList.remove`：为什么两个 `javaee` 只删除一个

在 `arraylistbasic.java` 中：

```java
list.add(3, "javaee");
list.add(5, "javaee");
list.remove("javaee");
```

`remove("javaee")` 调用的是 `remove(Object o)`。它的含义是删除指定元素的**第一次出现**，不是删除所有相同元素。因此列表中有两个 `javaee` 时，只会删除索引较小的那个，另一个仍然保留。[Java 11 ArrayList API](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)

当前添加完成后的列表是：

```text
[hello, javaase, world, javaee, java, javaee]
```

执行一次 `remove("javaee")` 后：

```text
[hello, javaase, world, java, javaee]
```

`remove` 有两个常见重载：

```java
remove(int index) // 按索引删除
remove(Object o)  // 删除第一次出现的指定元素
```

例如：

```java
list.remove(3);          // 删除索引 3 的元素
list.remove("javaee");  // 删除第一个内容为 javaee 的元素
```

如果要删除所有 `javaee`，可以使用：

```java
list.removeIf("javaee"::equals);
```

或者：

```java
list.removeAll(Collections.singleton("javaee"));
```

使用第二种写法时需要导入：

```java
import java.util.Collections;
```

对于 `ArrayList<Integer>` 还要特别注意：`list.remove(1)` 默认按索引删除，不是删除数值 `1`；如果要按数值删除，应写 `list.remove(Integer.valueOf(1))`。

### 19. `removeIf` 和方法引用 `::`

删除列表中所有内容为 `javaee` 的元素：

```java
list.removeIf("javaee"::equals);
```

`removeIf` 接收一个 `Predicate` 判断条件，会遍历列表：条件返回 `true` 的元素被删除，返回 `false` 的元素保留。

这句代码中的 `::` 叫作**方法引用**，用于把已有方法直接当作 Lambda 条件传递。它等价于：

```java
list.removeIf(element -> "javaee".equals(element));
```

这里的执行过程是：

```text
element 依次取列表中的每个元素
"javaee".equals(element) 判断内容是否相等
结果为 true 的元素被 removeIf 删除
```

`"javaee"::equals` 可以理解为“固定使用字符串 `javaee` 的 `equals` 方法”，列表元素会作为这个方法的参数传入。把确定不为 `null` 的字符串放在左边，也能避免调用空引用的 `equals` 导致异常。

常见方法引用形式：

```java
对象::实例方法       // "javaee"::equals
类名::静态方法       // Math::abs
类名::实例方法       // String::toUpperCase
类名::new             // StringBuilder::new
```

例如：

```java
list.forEach(System.out::println);
```

等价于：

```java
list.forEach(item -> System.out.println(item));
```

方法引用不是一种新的方法，而是 Lambda 表达式在“只调用一个已有方法”时的简写形式。它的参数和返回值必须能与目标函数式接口匹配。

### 20. IDEA 同时修改所有相同内容

在编辑器中先双击选中一个单词，然后按：

```text
Ctrl + Alt + Shift + J
```

即可选中当前文件中所有相同内容，直接输入新内容就会一次性修改全部。

相关快捷键：

```text
Alt + J          逐个选中下一个相同内容
Alt + Shift + J  取消最后一次选中
Esc              退出多光标编辑
```

如果快捷键无效，可以按 `Ctrl + Shift + A` 搜索 `Select All Occurrences`，或者到 `Settings -> Keymap` 查看当前快捷键配置。

### 24. `Management.java` 复查：当前剩余问题

本次复查确认：`studentArray` 和主 `input` 已经移到 `while` 外，`case 1/2/3` 的 `break` 以及 `case 4` 的 `return` 也已经修正，代码可以通过编译。

仍需注意以下问题：

1. `insertStudent` 和 `deleteStudent` 内部又分别创建了新的 `Scanner`。多个 Scanner 同时读取同一个 `System.in`，容易产生输入缓冲问题；而且主菜单使用 `nextInt()` 后，行尾换行符仍留在输入流中，添加学生时第一次 `nextLine()` 可能读到空字符串。推荐只创建一个 Scanner，并把它作为参数传入各个方法；或者统一使用 `nextLine()` 再转换数字。
2. `deleteStudent` 中的 `array.remove(id - 1)` 删除的是索引为 `id - 1` 的元素，不是 `Student.id` 等于输入值的学生。输入不存在的 ID 时还可能抛出 `IndexOutOfBoundsException`。
3. 集合为空时选择删除，也会发生索引越界；删除前应先判断集合是否为空以及是否找到匹配 ID。
4. `switch` 没有 `default` 分支，无效菜单输入时没有提示；`nextInt()` 遇到非数字还可能抛出 `InputMismatchException`。
5. `main` 中的 `Student student = new Student();` 没有被使用，可以删除；菜单代码外层单独的大括号也没有必要。
6. `Student.age` 当前是 `String`。如果年龄需要比较、排序或计算，建议改成 `int`；如果只做原样保存，使用 `String` 也能运行。
7. `viewStudent` 拼接字段时没有分隔符，例如会输出 `001张三18北京`，建议用空格或标签分隔。

### 25. `Management.java`：按学生 ID 删除的实现

已将菜单和方法改为共用一个 `Scanner`，菜单使用 `Integer.parseInt(input.nextLine())`，避免 `nextInt()` 留下换行符。

删除方法现在读取字符串 ID，然后遍历集合比较每个学生的 ID：

```java
public static void deleteStudent(ArrayList<Student> array, Scanner sc) {
    System.out.println("请输入想要删除学生的id");
    String id = sc.nextLine();

    for (int i = 0; i < array.size(); i++) {
        if (id.equals(array.get(i).getId())) {
            array.remove(i);
            System.out.println("删除成功");
            return;
        }
    }

    System.out.println("未找到该学生");
}
```

这里的 `i` 是集合索引，`array.get(i).getId()` 才是学生的业务 ID。找到匹配学生后使用 `array.remove(i)` 删除该索引位置的对象；找不到时不删除并提示用户。

调用时把主方法中的同一个 Scanner 传入：

```java
deleteStudent(studentArray, input);
```

不能再写 `array.remove(id - 1)`，因为那是把用户输入的学生 ID 当成集合索引，只有在 ID 恰好从 1 连续编号时才可能碰巧正确。

本次已用“添加一个学生 -> 查看 -> 输入该学生 ID 删除 -> 再查看”的流程验证，删除成功且不会自动删除其他学生。

### 26. `Integer.parseInt(input.nextLine())` 的含义

菜单第 19 行：

```java
int i = Integer.parseInt(input.nextLine());
```

执行顺序从括号最里面开始：

1. `input.nextLine()` 读取用户输入的一整行，结果是 `String`，例如输入 `1` 得到字符串 `"1"`。
2. `Integer.parseInt("1")` 把字符串数字转换为基本类型 `int`，得到数字 `1`。
3. 将数字保存到变量 `i`，供 `switch (i)` 判断菜单选项。

拆开写完全等价：

```java
String text = input.nextLine();
int i = Integer.parseInt(text);
```

这里使用 `nextLine()` 而不是 `nextInt()`，是为了让整个程序统一按行读取输入，避免 `nextInt()` 不读取行尾换行符，导致后面的 `nextLine()` 读到空字符串。

如果用户输入的不是整数，例如 `abc`，`Integer.parseInt()` 会抛出 `NumberFormatException`；后续可以使用异常处理或输入校验给出友好提示。

### 27. 阶段评估：学生管理系统体现的掌握程度

`Student.java` 和 `Management.java` 基本由自己完成，并且能够通过编译。这两个文件已经证明对以下知识具备基础应用能力：

- 能把学生抽象为 `Student` 类，并定义 `id`、`name`、`age`、`address` 成员变量。
- 能使用 `private`、Getter、Setter 和构造方法完成基础封装。
- 能使用 `new Student()` 创建对象并为对象赋值。
- 能用 `ArrayList<Student>` 保存多个对象，理解泛型约束集合元素类型。
- 能把集合和 Scanner 作为参数传给方法。
- 能把添加、删除、修改、查看拆成不同方法，体现了方法复用和职责划分。
- 能遍历集合，并通过 `getId()` 找到具体学生。
- 能根据业务 ID 删除对象，而不是错误地把 ID 当作集合索引。
- 能用 `while + switch` 实现持续运行的菜单程序。

因此当前水平可以表述为：

```text
类和对象：基本掌握
方法定义、参数和调用：基本掌握
封装、Getter、Setter：基本掌握
ArrayList 存储和遍历对象：基本掌握
简单增删改查业务：能够独立实现
异常和边界处理：仍需加强
```

当前代码中仍能看到需要继续练习的细节：

1. 菜单第 4 项文字仍写成“查看所有学生信息”，实际功能是修改学生信息。
2. 查看学生时地址前多拼接了字符 `2`。
3. 修改学生成功后没有提示；找不到 ID 时也没有提示。
4. 添加学生时没有检查 ID 是否重复。
5. 菜单缺少 `default`，非数字输入也没有异常处理。
6. `age` 使用 `String`，还没有做年龄范围和数字校验。
7. 代码中的额外大括号和重复的 `array.get(i)` 可以继续整理。

这些问题不代表没有掌握类、方法、对象和集合，而是说明已经进入下一阶段：从“功能能够运行”提升到“代码能处理无效输入、重复数据和异常情况”。

下一步可以独立完成以下改进，用来检验是否真正熟练：

```text
添加时拒绝重复 ID
修改/删除时正确提示找不到学生
空集合查看时给出提示
错误菜单输入后不崩溃
将按 ID 查找学生的重复循环提取成公共方法
```

### 28. 当前 Java 基础阶段的学习判断

Java 语法和标准库还有较多内容需要继续学习，例如异常、IO、泛型、继承、多态、接口、抽象类、集合体系、Lambda、Stream、日期时间、线程和网络等。不过已经掌握的类、方法、对象、封装和 `ArrayList` 是后续内容的重要基础。

类、方法和对象部分接下来确实需要提高熟练度，但不能只是重复照着已有代码抄写。更有效的练习方式是：

```text
关掉示例独立重写
-> 改变需求，不照搬原题
-> 自己调试错误
-> 增加边界处理
-> 写完后解释每个类和方法的职责
```

适合当前阶段的练习：

1. 完善学生管理系统：重复 ID 校验、修改和删除提示、输入异常处理。
2. 独立编写图书管理系统：图书编号、名称、价格、借出状态和增删改查。
3. 独立编写商品管理系统：商品编号、名称、库存、价格和库存修改。
4. 把重复的按 ID 查找逻辑提取成一个方法。
5. 尝试使用有参构造方法直接创建对象，比较它和 Setter 赋值的区别。

判断是否真正熟练，不看敲了多少遍，而看能否做到：

```text
不看答案完成一个类似但不同的需求
能解释为什么这样设计类和方法
出现错误时能用 Debug 自己定位
能处理空集合、重复数据和错误输入
```

当前路线建议：先继续推进课程，同时每学完一个章节做一个小程序巩固；不必等某个知识点“百分之百熟练”后才学习下一章。
