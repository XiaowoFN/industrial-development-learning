# Java 学习记录：day6

## 记录约定

- 每次说“记录”时，先检查 `day6/src/main/java` 下最近新增或修改的代码。
- 记录代码功能、关键语法、运行结果、问题和当前学习进度。

## 2026-09-03

### 1. day6 当前内容：继承

当前代码使用 `fu` 作为父类、`zi` 作为子类：

```java
public class zi extends fu {
}
```

子类可以使用父类中继承来的可访问成员。例如 `zi` 中没有定义 `show()`，但创建 `zi` 对象后可以调用：

```java
zi z = new zi();
z.show();
```

继承可以复用共同代码，但也会增强类之间的耦合。一般只有符合“子类是父类的一种”的关系时才使用继承。

### 2. 为什么方法中的 `age` 不能使用 `public`

`fu.java` 当前写法：

```java
public void show() {
    public int age;
}
```

`age` 定义在方法内部，所以是**局部变量**。局部变量不能使用 `public`、`private`、`protected` 等访问权限修饰符。

原因是局部变量只在当前方法或代码块中存在，方法外部无法通过对象访问它，因此没有必要声明“谁可以访问”。局部变量的可见范围已经由它所在的大括号决定。

如果只想在 `show()` 内使用：

```java
public void show() {
    int age = 18;
    System.out.println(age);
}
```

如果想让 `age` 成为父类的成员变量，应放到方法外、类里面：

```java
public class fu {
    public int age;

    public void show() {
        System.out.println(age);
    }
}
```

这样 `public int age` 在语法上是允许的，子类对象也可以访问：

```java
zi z = new zi();
z.age = 18;
```

不过实际开发中通常使用 `private` 保护成员变量，再提供 Getter 和 Setter；如果专门希望子类直接访问，也可以学习 `protected`。

```text
类中、方法外定义 -> 成员变量，可以使用访问修饰符
方法或代码块内部 -> 局部变量，不能使用 public/private/protected
```

### 3. day6 学习进度

```text
[已完成] 使用 extends 建立继承关系
[已完成] 子类对象调用父类方法
[已完成] 区分成员变量和局部变量
[进行中] 继承中的变量访问、this、super 和方法重写
```

### 4. 本次新增代码文件

本次检查到以下新增或修改文件：

```text
hw/fu.java                    父类成员变量
hw/zi.java                    子类成员变量、this 和 super
hw/jicheng.java               继承访问规则和构造方法测试
hw/fu1.java                   父类无参/有参构造方法
hw/zi1.java                   子类构造方法调用父类构造方法
override/fangfachongxie.java      方法重写概念说明
```

### 5. 继承中的变量访问：同名变量的优先级

`fu.java` 定义父类成员变量：

```java
public class fu {
    public int age = 40;
}
```

`zi.java` 又定义了同名的成员变量，并在 `show()` 中定义了局部变量：

```java
public class zi extends fu {
    public int height = 175;
    public int age = 20;

    public void show() {
        int age = 30;
        System.out.println(age);
        System.out.println(height);
        System.out.println(this.age);
        System.out.println(super.age);
    }
}
```

输出顺序为：

```text
30
175
20
40
```

变量查找规则：

```text
直接写 age       -> 优先找当前方法中的局部变量
写 this.age      -> 访问当前子类对象的成员变量
写 super.age     -> 访问父类中的成员变量
```

子类定义与父类同名的成员变量叫变量隐藏（或变量遮蔽），它不会覆盖父类变量；父类和子类对象部分各自保留一个 `age`。访问时用 `this` 和 `super` 明确指定来源。

### 6. 继承中的构造方法调用

`fu1.java` 有无参和有参构造方法：

```java
public fu1() {}

public fu1(int age) {
    System.out.println("fu中带参构造方法被调用");
}
```

`zi1.java` 的两个构造方法中没有写 `super(...)` 时，Java 会在第一行隐式调用父类无参构造方法：

```java
public zi1(int age) {
    // 隐式执行 super()
    System.out.println("zi中带参构造方法被调用");
}
```

所以：

```java
new zi1();       // 先调用 fu1()，再执行 zi1()
new zi1(20);     // 仍先调用 fu1()，再执行 zi1(int)
```

如果希望子类有参构造方法调用父类有参构造方法，必须显式写 `super(参数)`，且必须放在子类构造方法第一行：

```java
public zi1(int age) {
    super(age);
    System.out.println("zi中带参构造方法被调用");
}
```

只有当父类存在可访问的无参构造方法时，子类构造方法中省略 `super()` 才能正常编译。如果父类没有无参构造方法，子类必须显式选择一个有参构造方法。

### 7. 方法重写预习

`重写/fangfachongxie.java` 开始记录方法重写：当子类出现与父类**方法声明相同**的方法时，子类可以重新提供方法体，保留父类方法的基本约定，同时实现子类自己的行为。

```text
继承：子类获得父类可继承的成员
override：子类重新实现父类已有的方法
```

后续需要继续学习重写的参数列表、返回值、访问权限、`@Override` 注解以及重写和重载的区别。

### 8. day6 学习进度更新

```text
[已完成] 使用 extends 建立父子类关系
[已完成] 子类调用父类继承来的方法
[已完成] 成员变量、局部变量和同名变量访问
[已完成] 使用 this 访问子类当前对象成员
[已完成] 使用 super 访问父类成员
[已完成] 理解子类构造方法默认调用父类无参构造方法
[进行中] 方法重写、@Override、继承中的多态
```

### 9. CSS 是什么

CSS 是 Cascading Style Sheets（层叠样式表）的缩写，用于控制网页的外观和布局，例如颜色、字体、大小、边距、位置和动画。

```text
HTML        网页有什么内容、结构是什么
CSS         网页看起来是什么样子
JavaScript  网页如何响应用户操作
```

示例：

```html
<p class="title">你好</p>
```

```css
.title {
    color: red;
    font-size: 24px;
}
```

这段 CSS 会把 `class="title"` 的文字设置为红色、字号设置为 24 像素。若依等前后端项目中，Java/Spring Boot 通常负责后端业务和接口，HTML、CSS、JavaScript/Vue 通常负责前端页面。

### 10. CSS 是否需要单独学习

如果学习目标以 Java 后端为主，现在不需要打断 Java 课程深入学习 CSS。先完成 Java 基础、数据库、Maven、Spring Boot 和若依后端，再根据工作需要补前端。

后端开发至少应具备基础前端阅读能力：

```text
HTML 基础标签和表单
CSS 选择器、盒模型、常见布局
JavaScript 基础语法、事件、异步请求
HTTP、JSON 和前后端接口调用
```

如果以后需要独立修改若依前端页面，再系统学习：

```text
HTML -> CSS -> JavaScript -> Vue -> 若依前端项目结构
```

学习阶段不建议同时深入 Java 后端和前端全部内容，否则容易分散精力。当前以 Java 为主，遇到页面代码时先学够解决当前问题的知识；完成后端基础后，再安排一段独立时间补前端。

### 11. JavaScript 是做什么的

JavaScript 是一门主要用于网页交互和逻辑处理的编程语言。HTML 定义页面结构，CSS 设置外观，JavaScript 处理行为。

JavaScript 常见用途：

- 响应按钮点击、键盘输入等用户操作。
- 校验表单，例如判断用户名是否为空。
- 调用 Java/Spring Boot 提供的后端接口。
- 接收和处理 JSON 数据。
- 在不刷新整个页面的情况下更新页面内容。
- 使用 Vue、React 等框架开发复杂前端应用。

示例：

```javascript
const button = document.querySelector("button");
button.addEventListener("click", function () {
    alert("按钮被点击了");
});
```

JavaScript 和 Java 名字相似，但它们是两门不同的语言：

```text
Java        常用于后端、Android 和企业应用，运行在 JVM 上
JavaScript  常用于浏览器前端，也可以通过 Node.js 在服务端运行
```

若依前后端分离项目中，Java/Spring Boot 负责数据库、业务逻辑和接口；JavaScript/TypeScript、Vue 负责页面、交互和调用后端接口。

### 12. 网页动画由什么实现，HTML 是否还有必要学习

现代网页动画通常由多种技术配合完成：

```text
CSS Transition / Animation  简单过渡、移动、旋转、淡入淡出
JavaScript / Web Animations API  根据点击、滚动和数据动态控制动画
Canvas / WebGL             游戏、粒子、3D 和复杂高性能画面
```

简单界面动画优先使用 CSS，例如 `transition`、`transform` 和 `@keyframes`；需要暂停、重播、根据业务状态或用户操作动态控制时，使用 JavaScript。Web Animations API 允许 JavaScript 直接控制浏览器动画引擎。[MDN CSS 动画](https://developer.mozilla.org/en-US/docs/Web/CSS/Guides/Animations) [MDN Web Animations API](https://developer.mozilla.org/en-US/docs/Web/API/Web_Animations_API)

HTML 没有被淘汰。它仍是 Web 的基础构建模块，负责描述页面内容的含义和结构；CSS 负责呈现，JavaScript 负责行为。[MDN HTML](https://developer.mozilla.org/en-US/docs/Web/HTML)

Vue、React 等框架没有取代 HTML。开发者可能写模板或组件，但框架最终仍会让浏览器得到并渲染 HTML/DOM。不会 HTML，就难以正确使用表单、按钮、表格、语义标签和页面结构，也难以排查前端问题。

Java 后端学习者不必一开始深入前端动画，但应掌握这些 HTML 基础：

```text
页面基本结构
div、span、标题、段落、列表
链接和图片
form、input、button、select
table
class、id 和常用属性
语义化标签与 DOM 层级
```

建议顺序仍然是：

```text
HTML 基础 -> CSS 基础 -> JavaScript 基础 -> Vue -> 动画与复杂视觉
```

先学结构，再学样式和行为；不建议从动画库直接开始。

可以用一句话区分：`CSS` 主要调整网页外观，`JavaScript` 主要让网页能够进行交互。CSS 也可以实现悬停效果和简单动画，但读取数据、处理按钮逻辑、提交表单、调用后端接口等程序行为通常由 JavaScript 完成。
