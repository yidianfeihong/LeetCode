package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 *
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 *
 * 输入：nums = [0,1]
 * 输出：[1,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution260 {
    public static void main(String[] args) {


    }

    public int[] singleNumber(int[] nums) {
        int res = 0;
        for(int num:nums){
            res^=num;
        }
        int temp = 1;
        while((temp&res) != temp){
            temp <<= 1;
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for(int num:nums){
            if((temp&num) == temp){
                leftList.add(num);
            }else{
                rightList.add(num);
            }
        }
        int a = 0;
        int b = 0;
        for(int num:leftList){
            a^=num;
        }

        for(int num:rightList){
            b^=num;
        }
        return new int[]{a,b};
    }


}
