# Java 学习记录

## 记录约定

- `day3` 中新建或修改的学习代码文件都需要记录。
- 每次针对代码提出的新问题、涉及的新知识点和解决方法，都追加到本文件。
- 记录时注明相关文件，并尽量保留简短、可运行的示例代码。
- 已经记录过的内容不重复堆砌；有补充时更新原有内容或追加新的小节。

## 2026-08-24

### 1. 方法的定义与调用

方法要先定义，再调用。定义方法本身不会让方法自动执行。

```java
public static int sum(int a, int b) {
    return a + b;
}
```

调用并打印返回值：

```java
System.out.println(sum(5, 5)); // 10
```

- `public`：其他类也可以访问该方法。
- `static`：方法属于类，可以在同为 `static` 的 `main` 方法中直接调用，不需要先创建对象。
- `int`：方法返回值的类型。
- `sum`：方法名。
- `a`、`b`：形式参数（形参）。
- `5`、`5`：调用方法时传入的实际参数（实参）。
- `return`：把计算结果返回到调用方法的位置；`return` 本身不会打印结果。
- `void`：方法没有返回值。

### 2. 方法重载

同一个类中，可以定义多个名称相同、参数列表不同的方法。Java 会根据传入参数的数量和类型选择对应的方法。

```java
sum(int a, int b)
sum(double a, double b)
sum(int a, int b, int c)
```

当前代码中的调用结果：

```java
sum(5, 5)                    // 10
sum((double) 5, (double) 5) // 10.0
sum(1, 2, 3)                // 6
```

注意：判断重载主要看方法名和参数列表，不能只靠返回值类型区分重载。

### 3. 方法的执行顺序

Java 会按照 `main` 方法中的调用顺序执行。调用一个普通方法后，需要等该方法完整执行并返回，才会继续执行下一行。

当前代码先调用：

```java
isEvenNumber();
```

等它结束后，才执行：

```java
System.out.println(getMax(9, 8)); // 9
```

因此 `9` 最后输出。控制台中的 `11` 是键盘输入的数字，不是 `println` 输出的内容。

### 4. 循环、奇偶判断与 `break`

```java
while (true) {
    int a = sc.nextInt();
    if (a % 2 == 0) {
        System.out.println("true");
    } else {
        System.out.println("false");
        break;
    }
}
```

- `while (true)`：无限循环。
- `a % 2 == 0`：余数为 0，说明是偶数。
- `break`：立即结束当前循环。

### 5. 基本数据类型与引用数据类型

Java 的 8 种基本数据类型：

```text
byte、short、int、long、float、double、char、boolean
```

基本数据类型的变量直接保存数据。赋值或传参时复制的是数据本身：

```java
int i = 100;
changeNumber(i);
System.out.println(i); // 仍然是 100
```

```java
public static void changeNumber(int a) {
    a = 200;
}
```

方法中的 `a` 是 `i` 的值副本，修改 `a` 不会影响外面的 `i`。

数组、类、`String`、`Scanner` 等属于引用数据类型。引用变量保存的是对象的引用。两个变量可能指向同一个对象，因此通过其中一个引用修改对象内容，另一个引用也能看到变化。

Java 的方法参数始终是值传递：

- 基本类型传递数据值的副本。
- 引用类型传递引用值的副本。

### 6. IDEA 常用快捷键

- `Ctrl + Alt + Shift + J`：选中所有相同内容，进行多光标编辑。
- `Alt + J`：选中下一个相同内容。
- `Alt + Shift + J`：取消最后一个选中项。
- `Shift + F6`：安全地重命名类、方法或变量。
- `Alt + Enter`：查看快速修复建议。
- `Ctrl + Alt + L`：格式化代码。
- `Ctrl + D`：复制当前行。
- `Ctrl + Y`：删除当前行。
- `Ctrl + Shift + Enter`：补全当前语句。

### 7. 今天遇到的问题

- `return` 是返回数据，不是打印数据，需要使用 `System.out.println()` 显示结果。
- 项目中的 `day2` 和 `day3` 都存在 `hw.fangfa` 类。运行时要确认 IDEA 使用的是 `day3` 模块，避免运行到旧代码。
- `getMax(9, 8)` 输出 `9`，但它排在 `isEvenNumber()` 后面，所以要等 `isEvenNumber()` 完整执行后才会打印。

### 8. IDEA 左侧的 `@` 图标

代码左侧区域叫作 gutter（编辑器装订区域）。方法旁边出现的 `@` 是 IDEA 的“推断注解”图标，不是代码报错，也不会影响编译和运行。

IDEA 会分析代码并推断 `@NotNull`、`@Nullable`、`@Contract` 等信息。例如方法中直接使用了 `arr.length` 和 `arr[i]`，数组参数需要是有效的数组引用；如果传入 `null`，程序会产生 `NullPointerException`。

- 把鼠标放到 `@` 图标上，可以查看 IDEA 推断出的具体信息。
- 单击图标，可以查看相关操作。
- 不想显示时，可以进入 `Settings -> Editor -> General -> Gutter Icons`，找到推断注解相关选项并关闭。

截图中的 `for` 循环还缺少一对小括号，正确格式为：

```java
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
```

### 9. `debug.java`：断点调试与基础练习

相关文件：`src/main/java/hw/debug.java`

Debug 是程序调试工具。可以在代码行左侧添加断点，然后使用 Debug 模式逐行观察程序的执行顺序以及变量值的变化。

文件中的第一个练习是计算 `0～10` 之间所有偶数的和：

```java
int sum = 0;
for (int i = 0; i <= 10; i++) {
    if (i % 2 == 0) {
        sum = sum + i;
    }
}
System.out.println(sum); // 30
```

执行过程中的 `sum` 依次累加 `0、2、4、6、8、10`，最终结果为 `30`。

第二个练习使用 `Scanner` 连续读取两个整数，再调用方法取得较大值：

```java
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int m = sc.nextInt();
System.out.println(getMax(n, m));
```

```java
public static int getMax(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}
```

例如输入 `3` 和 `5`，程序先输出偶数和 `30`，再输出最大值 `5`。

### 10. `pass7.java`：逢七过

相关文件：`src/main/java/hw/pass7.java`

程序遍历 `1～100`，找出能被 7 整除或者数字中含有 7 的整数：

```java
for (int i = 1; i <= 100; i++) {
    if (i % 7 == 0 || i % 10 == 7 || i / 10 % 10 == 7) {
        System.out.println(i);
        sum += i;
    }
}
```

三个条件的含义：

- `i % 7 == 0`：`i` 能被 7 整除。
- `i % 10 == 7`：`i` 的个位是 7。
- `i / 10 % 10 == 7`：`i` 的十位是 7。
- `||`：逻辑或，只要其中一个条件成立，整个条件就成立。
- `sum += i` 等价于 `sum = sum + i`。

运行验证后，符合条件的数字总和为：

```text
1769
```

### 11. `dafen.java`：去掉最高分和最低分后求平均分

相关文件：`src/main/java/hw/dafen.java`

程序使用长度为 6 的数组保存 6 位评委给出的分数：

```java
int[] arr = new int[6];
Scanner sc = new Scanner(System.in);
for (int i = 0; i < arr.length; i++) {
    arr[i] = sc.nextInt();
}
```

- `new int[6]`：创建一个能够保存 6 个 `int` 数据的数组。
- `arr[i]`：通过索引访问数组元素，索引从 `0` 开始。
- `arr.length`：取得数组长度。相比直接写 `6`，使用它更方便以后调整数组长度。
- 数组作为方法参数时，传入的是数组引用值的副本，方法可以读取同一个数组中的元素。

程序分别定义了三个方法：

- `getSum(arr)`：遍历数组并返回总分。
- `getMaxArr(arr)`：遍历数组并返回最高分。
- `getMinArr(arr)`：遍历数组并返回最低分。

计算公式：

```java
(getSum(arr) - getMaxArr(arr) - getMinArr(arr)) / (arr.length - 2)
```

含义是从总分中减去一个最高分和一个最低分，再除以剩余人数。输入：

```text
50 100 88 92 75 80
```

去掉 `100` 和 `50` 后，剩余总分为 `335`，因为当前使用的是 `int` 整数除法，所以 `335 / 4` 输出 `83`，小数部分会被舍去。

如果希望保留小数，可以让除数变成 `double`：

```java
double average = (getSum(arr) - getMaxArr(arr) - getMinArr(arr))
        / (double) (arr.length - 2);
System.out.println(average); // 83.75
```

当前程序要求必须输入 6 个整数；如果输入数量不足，`Scanner.nextInt()` 会继续等待，在输入流已经结束的测试环境中则会出现 `NoSuchElementException`。

### 12. Git：使用 `.gitignore` 忽略 IDEA 配置文件

仓库根目录的 `.gitignore` 中加入：

```gitignore
/.idea/
```

表示忽略仓库根目录下整个 `.idea` 文件夹。开头的 `/` 代表规则从仓库根目录开始匹配。

`.gitignore` 默认只会直接作用于尚未被 Git 跟踪的文件。如果 `.idea` 中的文件以前已经提交过或加入了 Git 索引，仅添加忽略规则还不够，需要执行一次：

```bash
git rm -r --cached .idea
```

该命令只从 Git 索引中取消跟踪 `.idea`，不会删除电脑上的本地文件。随后提交 `.gitignore` 以及 `.idea` 的删除记录，今后 `.idea` 中的文件就不会再出现在提交列表中。

如果 `.idea` 以前已经上传到 GitHub，执行 `git rm -r --cached .idea` 后，Git 状态中的 `D .idea/...` 表示这些文件将在下一次提交中从远程仓库的当前版本删除。完成提交并执行 `git push` 后，GitHub 上当前分支中的 `.idea` 就会消失；本地 `.idea` 仍然保留，并受 `.gitignore` 保护。

这只会从仓库当前版本中删除文件，历史提交中仍然可以看到旧文件。如果其中曾包含密码、令牌等敏感信息，需要立即作废并更换对应凭据，然后另行清理 Git 历史；普通 IDEA 项目配置通常不需要改写历史。

在 IDEA 的 Commit 面板中取消文件勾选，只能让文件不参加当前这一次提交，不能实现永久忽略。

### 13. Git：忽略特定后缀的文件

在 `.gitignore` 中使用 `*` 匹配任意文件名。例如：

```gitignore
*.class
*.log
*.tmp
```

含义分别是忽略所有 Java 编译生成的 `.class` 文件、日志文件和临时文件，不限于某个目录。

常见写法：

```gitignore
**/*.class       # 任意目录下的 .class 文件
build/           # 名为 build 的目录及其内容
/config.local    # 只忽略仓库根目录下的 config.local
test?.txt        # ? 匹配一个字符，例如 test1.txt
```

当前仓库的根目录 `.gitignore` 使用了：

```gitignore
**/.idea/
**/target/
```

因此任意层级目录下的 `.idea` 和 `target` 目录都会被忽略。

注意：忽略规则只对尚未被 Git 跟踪的文件立即生效。如果某种后缀的文件已经提交过，需要先从索引中移除，但保留本地文件：

```bash
git rm --cached path/to/file.class
```

要取消跟踪某个目录下所有已跟踪的该后缀文件，可以使用：

```bash
git rm --cached -r path/to/目录
```

然后提交 `.gitignore` 和删除记录，之后新生成的对应文件就不会再出现在 Commit 列表中。

补充：`**/.iml/` 表示匹配目录名正好为 `.iml` 的文件夹，而且末尾 `/` 明确表示目录；它不会匹配 `xxx.iml` 文件。

忽略 IntelliJ IDEA 的 `.iml` 文件应该写：

```gitignore
*.iml
```

或者写成：

```gitignore
**/*.iml
```

其中 `*.iml` 已经可以匹配任意目录下的 `.iml` 文件，通常更简洁。若 `.iml` 文件以前已经被跟踪，需要先执行 `git rm --cached 文件路径`，再提交忽略规则。

### 14. Git 忽略与 IDEA 排除的区别

IDEA 提示 `Some of the ignored directories are not excluded from analysis and search` 的意思是：某些目录已经被 Git 的 `.gitignore` 忽略，不会参与提交，但 IDEA 仍会对它们进行项目分析、索引和搜索。

两者作用不同：

```text
.gitignore       决定文件是否出现在 Git 提交中
IDEA Excluded    决定文件是否参与代码分析、索引和搜索
```

对于 Maven/Java 项目，`target` 是编译生成目录，通常建议在 IDEA 中排除：

1. 在左侧 Project 窗口找到 `target`。
2. 右键目录，选择 `Mark Directory As -> Excluded`。
3. 如果提示条中有 `Exclude ignored files from project`，也可以直接点击它，让 IDEA 自动排除被 Git 忽略的目录。

也可以通过 `File -> Project Structure -> Modules -> Sources` 选择目录并标记为 `Excluded`。排除后，目录仍保留在电脑上，不会被删除；只是不会参与 IDEA 的代码补全、检查、导航和搜索。

因此，`.gitignore` 中保留下面的规则即可：

```gitignore
**/.idea/
**/target/
*.iml
```

## 2026-08-31

### 15. 当前代码文件与学习进度

今天开始学习 Java 面向对象和类、对象的关系。`day3/src/main/java/hw` 下目前有这些练习文件：

```text
hw.java       最基础的 main 方法和控制台输出
hulue.java    最基础的 Hello World 输出
fangfa.java   方法、重载、参数传递、数组遍历
debug.java    Debug、循环、Scanner 输入、求最大值
pass7.java    逢七过练习
dafen.java    去掉最高分和最低分后求平均分
phone.java    手机类：成员变量和成员方法
student.java  学生类：成员变量和成员方法
classL.java   创建对象并调用对象的属性和行为
```

### 16. `fangfa.java` 的数组遍历

当前文件新增了 `viewArray` 方法，用于按照数组格式打印元素：

```java
public static void viewArray(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
        if (i == arr.length - 1) {
            System.out.print(arr[i]);
        } else {
            System.out.print(arr[i] + ", ");
        }
    }
    System.out.println("]");
}
```

`i == arr.length - 1` 用来判断当前元素是不是最后一个，避免最后一个元素后面多打印逗号。数组的最后一个索引永远是 `length - 1`。

`fangfa.java` 的 `main` 中还演示了：数组可以作为参数传给方法，方法能够读取数组中的元素；`isEvenNumber()` 使用 `while (true)` 持续读取输入，输入奇数后通过 `break` 退出循环。

### 17. 类和对象的基本概念

相关文件：`phone.java`、`student.java`、`classL.java`

- 类是对一类具有共同属性和行为的事物的抽象，也是对象的数据类型。
- 对象是类具体存在的实例。
- 属性在 Java 类中通常用成员变量表示。
- 行为在 Java 类中通常用成员方法表示。

`phone.java`：

```java
public class phone {
    String brand;
    int price;

    public void call() {
        System.out.println("打电话");
    }

    public void sendMessage() {
        System.out.println("发短信");
    }
}
```

这里 `brand` 和 `price` 是成员变量，`call()` 和 `sendMessage()` 是成员方法。

`student.java` 也使用同样的结构：`name`、`age` 表示学生属性，`study()`、`doHomework()` 表示学生行为。

### 18. 创建对象和调用成员

`classL.java` 中使用 `new` 创建对象：

```java
phone p = new phone();
p.brand = "huawei";
p.price = 10245;
p.sendMessage();
p.call();
```

- `phone p`：声明一个 `phone` 类型的引用变量 `p`。
- `new phone()`：创建一个 `phone` 对象。
- `p.brand`、`p.price`：访问对象的成员变量。
- `p.sendMessage()`、`p.call()`：调用对象的成员方法。

`new` 创建的对象通常位于堆内存，引用变量 `p` 位于栈帧中；变量 `p` 保存的是指向堆中对象的引用。

同一个类可以创建多个对象：

```java
student s = new student();
student g = new student();
```

`s` 和 `g` 是两个不同的对象，分别拥有自己的成员变量。直接打印对象（如 `System.out.println(s)`）默认会打印对象的类名和哈希值形式；如果想打印有意义的内容，可以重写 `toString()` 方法。

### 19. 当前阶段需要注意的代码规范

- Java 类名通常使用大写字母开头的 PascalCase，例如 `Phone`、`Student`、`ClassL`；当前练习中的小写类名可以运行，但不符合常用命名规范。
- 成员变量最好使用 `private` 修饰，再通过构造方法、Getter 和 Setter 控制访问；当前练习使用的是默认访问权限，适合入门演示。
- 创建对象后如果没有给成员变量赋值，数值类型默认是 `0`，引用类型默认是 `null`，`boolean` 默认是 `false`。
- 一个 `.java` 文件通常只放一个 `public` 类，且文件名必须和 `public` 类名完全一致。

### 20. 当前学习路线

```text
方法基础
  -> 方法重载与参数传递
  -> 数组和循环练习
  -> Scanner 输入与 Debug 调试
  -> 类、对象、成员变量、成员方法
  -> 下一步：封装、构造方法、this、private、Getter/Setter
```

### 21. `classL.java` 最新练习：引用指向同一个对象

`classL.java` 最近新增了成员变量备注，并补充了对象引用赋值：

```java
student s = new student();
s.name = "shide";

student g = s;
g.name = "genshi";

System.out.println(s.name); // genshi
```

`student g = s` 不会创建新的 `student` 对象，而是把 `s` 中保存的引用复制给 `g`。因此 `s` 和 `g` 指向堆中的同一个对象：

```text
s ──┐
    ├──> 同一个 student 对象
g ──┘
```

通过 `g.name` 修改对象后，从 `s.name` 读取到的也是修改后的值。这个例子进一步说明：引用类型赋值复制的是引用值，不是对象本身。

运行结果中的 `shide`、`genshi`、`genshi`，分别对应修改前通过 `g` 读取、修改后通过 `g` 读取、修改后通过 `s` 读取。

`System.out.println(s)` 和 `System.out.println(g)` 输出相同的 `hw.student@...`，这是因为两个变量指向同一个对象，而 `student` 当前没有重写 `toString()`。

### 22. 成员变量与局部变量

- 成员变量：定义在类中、方法外，例如 `student` 的 `name`、`age`，属于对象；没有显式赋值时会获得默认值，如 `int` 为 `0`，引用类型为 `null`。
- 局部变量：定义在方法、循环或代码块内部，例如 `main` 中的 `student s`、`student g`，只在对应作用域内有效；局部变量必须先赋值才能使用。

`phone p`、`student s` 是局部的引用变量，`brand`、`price`、`name`、`age` 是对象的成员变量。通过对象引用加点号访问成员，例如 `p.brand`、`s.name`。

### 23. 面向对象学习进度更新

```text
[已完成] 理解类是对象的抽象、对象是类的实例
[已完成] 定义成员变量和成员方法
[已完成] 使用 new 创建对象并调用成员
[已完成] 区分基本类型值传递和引用类型引用传递
[已完成] 理解两个引用可以指向同一个对象
[进行中] 封装、构造方法、this、private、Getter/Setter
```

### 24. Debug 调试经验：方法名写错导致逻辑未按预期执行

今天通过断点调试排查了一次代码问题。虽然自己检查后认为判断逻辑正确，并且引入了 `boolean` 变量辅助判断，但程序仍然没有得到预期结果。

使用 Debug 模式后，按照程序的实际执行过程逐步查看：

1. 在关键代码行设置断点。
2. 使用 Debug 模式启动程序。
3. 通过单步执行观察每一行是否执行，以及程序跳转到了哪个方法。
4. 查看变量值，确认 `boolean` 判断结果是否符合预期。
5. 最终发现问题不是判断逻辑，而是方法名写错，调用的不是自己以为的那个方法。

这次经验说明：

- 代码“看起来逻辑正确”不代表实际执行路径正确。
- Debug 不只是查看变量值，也要确认程序是否进入了正确的方法。
- 排查问题时应同时检查方法名、参数、返回值和调用顺序。
- 断点调试可以把“猜测错误原因”变成“观察实际执行过程”。

当前已经掌握的基础 Debug 流程：

```text
设置断点 -> Debug 启动 -> 单步执行 -> 查看变量 -> 检查调用方法 -> 定位错误
```

### 25. `private1.java` 与 `private1test.java`：封装、构造方法和 `this`

最近新增的代码已经进入面向对象三大特征中的封装阶段。

#### `private` 封装成员变量

```java
public class private1 {
    private int age;
    private String name;
}
```

`private` 表示成员变量只能在当前类内部直接访问，外部测试类不能直接写 `p.age` 或 `p.name`。这样可以避免外部代码随意修改对象数据，再通过公开的方法控制数据是否合法，这就是封装的基本思想。

#### `this` 关键字

```java
public private1(int age, String name) {
    this.age = age;
    this.name = name;
}
```

当成员变量和参数同名时，`this.age` 表示当前对象的成员变量，`age` 表示构造方法接收的参数。`this` 代表当前正在操作的对象。

#### 构造方法

当前类定义了无参和有参两个构造方法：

```java
public private1() {}

public private1(int age, String name) {
    this.age = age;
    this.name = name;
}
```

- 构造方法名必须和类名相同。
- 构造方法没有返回值类型，连 `void` 也不能写。
- `new private1()` 调用无参构造方法。
- `new private1(32, "yuanshen")` 调用有参构造方法，并初始化成员变量。
- 如果完全没有定义构造方法，Java 会自动提供无参构造方法。
- 只要自己定义了任意构造方法，系统就不会再自动提供无参构造方法；如果还需要 `new private1()`，就必须自己显式写出无参构造方法。

#### 使用方法控制数据

```java
public void setAge(int age) {
    if (age < 0 || age > 120) {
        t = false;
    } else {
        this.age = age;
    }
}
```

`setAge` 在赋值前检查年龄范围，体现了封装中“隐藏细节、控制访问”的思想。`setName` 负责修改姓名，`showName`、`showAge`、`show` 负责输出对象信息。

测试类中的调用：

```java
private1 p = new private1();
p.setAge(100);
p.getAge();          // 100
p.setName("cyr");
p.showName();        // name:cyr

private1 p2 = new private1(32, "yuanshen");
p2.show();           // yuanshen32
```

运行结果已验证为：

```text
100
name:cyr
yuanshen32
```

#### 当前学习进度更新

```text
[已完成] 类、对象、成员变量、成员方法
[已完成] 引用变量和同一对象
[已完成] private 封装成员变量
[已完成] 使用 this 区分成员变量和参数
[已完成] 无参构造方法和有参构造方法
[进行中] 完善 Setter 数据校验，学习 Getter、继承和多态
```

### 26. 代码同步检查记录

本次检查了 `day3/src/main/java` 下的全部 Java 文件。最近修改的 `classL.java`、`private1.java` 和 `private1test.java` 内容均已在前面的章节记录；本次检查没有发现尚未记录的新建或修改代码。
