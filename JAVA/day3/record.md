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
