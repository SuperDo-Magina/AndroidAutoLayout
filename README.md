#  一、概述

能够快速适配各种机型的工具，详细效果说明： https://www.jianshu.com/p/9de3fbdf6d3a

#  二、用法说明
### 1、集成框架
1、 添加 JitPack 仓库
在更目录下的 build.gradle 添加以下代码
~~~~
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
~~~~
2、添加依赖
~~~~
dependencies {
	compile 'com.github.SuperDo-Magina:AndroidAutoLayout:1.x.x'
}
~~~~

### 2、初始化
宽高值取决与美工给你的ui设计图（如720*1280即width=720，height=1280），在使用时控件的大小即可以直接设置为ui标注大小（特殊说明:height>width）
    
    AutoLayout.init(this, width, height);

设置布局方向（可选，默认为竖向，可在设置不同方向布局前修改）

~~~~ 

AutoLayout.setScreenOrientation(AutoLayout.ScreenOrientation.LANDSCAPE／AutoLayout.ScreenOrientation.PORTRAIT);

~~~~

可用父布局：AutoFrameLayout、AutoLinearLayout、AutoRelativeLayout
（使用这几个布局只会影响布局的宽高和边距，其余使用与FrameLayout、LinearLayout、RelativeLayout相同）
### 属性说明
| 名称 | 数据类型 | 说明 | 备注 |
| :-: | :-: | :-: | :-: |
| （子布局属性） |
| auto_width | integer | 宽度 | 当该属性设置时会使layout_width属性失效 |
| auto_height | integer | 高度 | 当该属性设置时会使layout_height属性失效 |
| auto_width_extra | float | 额外的宽度 |  |
| auto_height_extra | float | 额外的高度 |  |
| auto_margin_left | integer | 左边距 |  |
| auto_margin_top | integer | 上边距 |  |
| auto_margin_right | integer | 右边距 |  |
| auto_margin_bottom | integer | 下边距 |  |
| auto_margin_left_extra | float | 额外的左边距 |  |
| auto_margin_top_extra | float | 额外的上边距 |  |
| auto_margin_right_extra | float | 额外的右边距 |  |
| auto_margin_bottom_extra | float | 额外的下边距 |  |
| auto_width_height_ratio | float | 宽高比 | 默认设置为‘相对宽’ |
| auto_ratio_refer_to | refer_to_width／refer_to_height | 相对于宽／高 | 当设置为‘相对宽’时，高度的值将取决于宽和宽高比 |
| 父布局属性 |
| auto_padding_left | integer | 左边距 |  |
| auto_padding_top | integer | 上边距 |  |
| auto_padding_right | integer | 右边距 |  |
| auto_padding_bottom | integer | 下边距 |  |
| auto_padding_left_extra | float | 额外的左边距 |  |
| auto_padding_top_extra | float | 额外的上边距 |  |
| auto_padding_right_extra | float | 额外的右边距 |  |
| auto_padding_bottom_extra | float | 额外的下边距 |  |

### 3、其它
为了应对更加复杂的情况，我们提供了一套工具能够在运行时修改布局的样式,同样你也可以通过该工具获取手机尺寸参数

#  三、已知问题

1.在使用xml布局时无法预览
2.在使用xml布局时无法智能提示能够使用的属性（declare-styleable 的命名无法与自定义控件统一）

#  四、联系方式
624996437@qq.com
在使用上遇到任何问题或者有什么好的建议都可以通过上诉邮箱与我联系
