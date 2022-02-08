# Leetcode
一些自己写的力扣，发上来做一下记录。说来惭愧，现在才开始明白代码的魅力，希望能够坚持下去

## 笔记
>这里是一些做题中间遇到的问题、小技巧，以及大概思路、代码结构
***
### 1.两数之和
比较简单，独立完成，初始版本为暴力遍历，效率及空间不太理想，待优化
***
### 2. 两数相加
这里使用了链表结构，故定义了ListNode类，并完成了initlist（初始化），printList（打印）功能，后续可能需要升级为泛型
该题本身是比较简单的，独立完成且完成情况较好，只需各遍历一遍，不足是代码风格较丑陋
***
### 3. 无重复字符的最长子串
本题参考题解，学到了许多，学到了滑动窗口的思路，以及HashMap<key,value>的理解、运用
***
### 4. 寻找两个正序数组的中位数
本题若没有O（log（m+n））的限制则非常简单，且有很多解法，但是限制以后必须考虑二分法，递归调用
代码实现不难，理解取k/2个数比较大小、删去前部分、更改k值的逻辑有难度
***
### 5. 最长回文子串
本题使用了简单的动态规划，可以看作第一个dp问题java实战，总体代码结构较简单就是自底向上进行遍历，主要需要注意边界条件（一个字符、两个字符）
***
### 6. Z 字形变换
本题独立完成，且思路较清晰，中间debug过程很快。总体代码结构比较优雅简洁，自我感觉良好。\
主要思路是按照s字符串顺序按Z字型遍历，并依次存入对应行字符串中\
设置flag指针用于指向当前行号，到底或顶时则偏转。
***
### 7. 整数反转
。。。没什么好说的给大家拜个早年吧
>唯一收获的可能是Integer.MAX_VALUE和try catch？
***
### 8. 字符串装换整数
这道题原本以为是一道非常简单非常基础的题目，但是实际写下来才发现其实边界条件比较复杂，我写的第一版（Atoi）函数就是简单的从头遍历，然后根据测试集的报错结果调试，再添加边界条件，最后代码非常屎山，不优雅。  
参考题解后学习到了运用有限状态机（FSM）的思想来解题，并强化了HashMap的理解和运用
>srds我写的FSM算法还没有屎山:cow: 
***
### 9. 回文数
很简单，没什么好说的，两种方法分别实现，好像涉及到字符串的确会慢一点
***
### 10. 正则表达式
太难了5555:sob:，本来前面的做出来了感觉在打怪升级，直到这题前前后后花了快4天（陆陆续续的做的）才在参考了题解的情况下做出来，唉，还是太菜了:triumph:。  
这题的难点在于找状态转移方程，dp数组的边界及下标也需要一些思考量，然后收获了一个教训：**动态规划题目不要找捷径，遍历整张表**，以免节外生枝。
***
### 11. 盛最多水的容器
这题有时间限制，所以最简单的O(n^2)的方案肯定不行，考虑双指针贪心算法，从头、尾两边分别往中间遍历，每次max后比较两边指针所在的数组值大小，小的往中间移动  
这里我是真不服，我的算法明明考虑了指针移动后比移动前更小的情况可以直接跳过的情况，应该会比题解给的代码少很多时间，但是竟然更久:angry:，我姐受不了:rage::rage::rage::rage::rage:
***
### 12. 整数转罗马数字
整体不算难，主要是轻敌了导致思维有些混乱，official_solution方法是官方题解，也是我一开始的想法，后来因为 ~~1900 = 900 + 900~~ 种种原因放弃了，改用HashMap键值对，然后遍历、分割int数  
然后可能是HashMap空间占用较大，空间时间的效率都不理想。还有转换以后组合这个思路感觉有点冗杂了。
***
### 13. 罗马数字转整数
这题主要要想到正常情况下字母按从大到小从左至右依次排列，若某个字符大于它右边的字符，则减去这个字符。这两题对HashMap熟练了一些。
***
### 14. 最长公共前缀
很简单，挨着遍历完事，然后各个字符串长度不一的情况try/catch就行了
> 从这里开始用quickprint.print来快速打印(quickprint.java)
***
### 15. 三数之和
想到通过排序来避免重复感觉很妙，然后第二三重循环用双指针来减少空间复杂度，还可以考虑到second和third相同的情况。
***


### 16. 最接近的三数之和
这题和15题很相似，几乎使用同样的排序+双指针，唯一不同是这题需要想出通过sum大小与target比较来决定移动哪一个指针。  
find方法是我一开始写的，本以为使用了双指针，但是发现和三重循环没什么不同，才认真看了看双指针的实现方法。
***
### 17. 电话号码的字母组合
这题是典型的树状结构遍历，初看可能会觉得n重循环可以实现，稍加思考就会发现循环次数不一定，所以需要递归。  
非递归的方法也有，使用队列结构即可，可疑的是非递归算法竟然比递归差。  
这题的递归算法超越了100%的java提交，很舒服，小骄傲一手。:yum::yum::yum::yum::yum::yum::yum::yum:
***
### 18. 四数之和
这题与前面的三数之和类似，思路也是排序+双指针，需要注意的是这里四数和通过双重循环确定前两个数后，双指针不能找到一个就跳出循环，必须完整遍历一遍，否则会有遗漏。  
题解中有人用DFS实现，感觉比较合适，暂未实验。
***
### 19. 删除链表的倒数第 N 个结点
这题用到了ListNode链表，比较简单，只需要注意边界条件，我一开始使用了栈来实现，代码较混乱且时间空间利用率不高  
题解中介绍了另外两种方法，大同小异，主要是dummy结点的使用（在head前面加一个结点，就可以将head结点也当做普通结点处理了），还有快慢指针的思想非常容易理解，且代码也很简洁。  
快慢指针的空间复杂度怎么会比栈还高捏:question::question::question::question:
***
### 20. 有效的括号
这道题:exclamation::exclamation::exclamation:  
:older_man:青回:exclamation::exclamation::exclamation:  
现在来看非常简单了，大一刚接触C语言时却觉得很难理解，利用栈这一数据结构即可。  
数据量较少，没有必要使用HashMap进行保存查询，直接if-else，switch.
***
### 21. 合并两个有序链表
比较简单，参照第二题`2. 两数相加`的思路，实现了两种，第一种（merge）是重新构造一个链表，第二种是在本来的基础上进行链接的重组。
时间复杂度都较好，空间复杂度都不好。
***
### 22. 括号生成
通过动态规划实现，状态转移方程比较巧妙，也不难想，官方题解的暴力算法太麻烦了，这题动态规划或者递归较简单，但是效率不太理想  
前85%都是些什么神仙啊啊啊啊:dizzy_face::dizzy_face::dizzy_face::dizzy_face:
*** 
### 23. 合并K个升序链表
用到了归并排序的思想，因为已经实现过`21. 合并两个有序链表`，所以想到通过分组-归并的思想实现。  
整体不难，力扣的难度题好像涉及到递归的就会标一个困难:sweat_smile::sweat_smile::sweat_smile:  
题解里面还有解法，比如
1. 暴力归并：每次合并两个，直到全部遍历完成
2. 优先队列：维护一个ListNode队列，存储了所有链表的还未检测的头一个结点，每次检测出最小的出队，并入结果链表。  
***
### 24. 两两交换链表中的节点
较简单，是谁大年初一还在写代码我不说:sob::sob::sob::sob:
***
### 25. K 个一组翻转链表
整体并不难，链表基操罢了，只是懒得思考k == 2 的情况了，就直接搬了`24. 两两交换链表中的节点`的函数。  
这里扩展的要求都达到了，时间复杂度很好，空间较差。  
算法思路：每次交换k个，利用数组buf将需要交换的存储，避免了next来遍历去的。
***
### 26. 删除有序数组中的重复项
很容易有思路,最不济双重循环总会吧(remove_vio),再次基础上使用HashMap记录(remove_hash)改进, 但是效率都一般.  
这题快慢指针法非常巧妙,fast指针用于遍历、检测,slow指针用于更新数组.时间复杂度非常好,空间复杂度为O(1),但是力扣平台提交显示空间复杂度不好,:eight:太懂  
***
### 27. 移除元素
简单题,暴力算法即可
***
### 28. 实现 strStr()
正经人谁造轮子啊:sweat_smile::sweat_smile::sweat_smile::sweat_smile:
***
### 29. 两数相除
连除法都要造轮子:horse::sweat_smile::sweat_smile::sweat_smile:  
感觉这题就是考虑特殊条件,然后最大最小值溢出问题
***
