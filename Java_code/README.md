# 代码文件
## 1. 两数之和
twoSum.java
***
## 2. 两数相加
addTwoNumbers.java
>因为要用到链表结构所以定义了ListNode类 ListNode.java
***
## 3. 无重复字符的最长子串
lengthOfLongestSubstring.java
***
## 4. 寻找两个正序数组的中位数
findMedianSortedArrays.java
***
## 5. 最长回文子串
longestPalindrome.java
***
## 6. Z 字形变换
ZtypeConvert.java
***
## 7. 整数反转
reverseInt.java
>palseInt 是JavaScript的函数，用valueOf也可。
***
## 8. 字符串转换整数
myAtoi.java
>用了两种实现方式
***
## 9. 回文数
isPalindrome.java
***
## 10.正则表达式
regexp.java
***
## 11. 盛最多水的容器
maxArea.java
***
## 12.整数转罗马数字
intToRoman.java
> official_solution是官方题解，也是我最初的思路
***
## 13. 罗马数字转整数
RomantoInt.java
***
## 14. 最长公共前缀
longestCommonPrefix.java
> 从这里开始用quickprint.print来快速打印(quickprint.java)
***
## 15.三数之和
threeSum.java
***
## 16. 最接近的三数之和
threeSumClosest.java
> 两种方法，第二种双指针O(n^2)明显好于O(n^3)
***
## 17. 电话号码的字母组合
letterCombinations.java
> 两种方法，类似于树的深度优先遍历，可以用递归和非递归实现，非递归采用队列结构实现，递归算法效率较好（非常好）
***
## 18. 四数之和
fourSum.java
> 有三个版本，第一个直接O(n^4),加入了一些剪枝，第二个版本使用了排序+双循环，官方版本是在O(n^4)的前提下加入了  
> 更多的剪枝条件。
***
## 19. 删除链表的倒数第 N 个结点
removeNthFromEnd.java
> 实现了两种算法，栈以及快慢指针
***
## 20. 有效的括号
isValid.java
***
## 21. 合并两个有序链表
mergeTwoLists.java
> 两种方法，重新构造链表（merge），在原有基础上重组链接（pasteMerge）
***
## 22. 括号生成
generateParenthesis.java
***
## 23. 合并K个升序链表
mergeKLists.java
> 其中merge2Lists方法其实就是`21. 合并两个有序链表`中的merge方法，由于Leetcode平台无法检测到我的包，只能这么复制一手
## 24. 两两交换链表中的节点
swapPairs.java
***
## 25. K 个一组翻转链表
reverseKGroup.java
> 其中swap方法其实就是`24. 两两交换链表中的节点`中的swap方法，由于Leetcode平台无法检测到我的包，只能这么复制一手  
> 更新了ListNode中的printList方法，打印更整洁。
***
## 26. 删除有序数组中的重复项
removeDuplicates.java
> 实现了三种方法  
> 暴力双重循环 remove_vio
> hashmap    remove_hash
> 快慢指针    remove_2p
***
## 27. 移除元素
removeElement.java
***
## 28. 实现 strStr()
strStr.java
***
## 29. 两数相除
divide.java
***
## 438.找到字符串中所有字母异位词
findAnagrams.java
>为30题做铺垫
***