# Harmony
<p align="center">
<img src = "https://user-images.githubusercontent.com/39553613/145566584-494920e6-bdac-4c23-985d-9d00187c90e1.jpg">
</p>

<h4 align="center">为什么不写一个可以整合许多相同功能的插件呢 ?</h4>

<p align="center">
<img alt="CodeFactor Grade" src="https://img.shields.io/codefactor/grade/github/Caishangqi/Harmony">
<img alt="Lines of code" src="https://img.shields.io/tokei/lines/github/Caishangqi/Harmony">
<img alt="Lines of code" src="https://img.shields.io/badge/paper-1.17.1-green">
<img alt="GitHub branch checks state" src="https://img.shields.io/github/checks-status/Caishangqi/Harmony/master?label=build">
<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/Caishangqi/Harmony">
</p>




### 模块：协调饰品 Harmony Slot
**介绍**: 该模块以物品栏 9,10,11,12 作为饰品栏，只有指定类型的物品才能放入。四种类型的饰品分别为: `RingSlot` 戒指栏，`CuriosSlot` 珍品栏，`BraceletSlot` 手镯栏 以及 `AmuletsSlot` 项链栏。

**Demo类型**：该版本配置了 _粘液球_ 和 _金粒_ 作为`RingSlot`类型的物品，左键装备该物品，右键卸除装备，该版本下的插件默认不会掉落饰品。

![插件demo](https://user-images.githubusercontent.com/39553613/147332281-07ccc95b-0032-486d-b210-5a430d7767ff.gif)

**未来计划**: 重新将重复代码整合到单独类中，在这两个监听器建立时就创建一次slot栏位，不再重新创建。将配置文件完善，可以添加任意材料作为饰品，同时兼容 MMOItems 。依据开发者是否给出遍历部分物品的前提条件来写物品属性加载器，以多线程方式实现。