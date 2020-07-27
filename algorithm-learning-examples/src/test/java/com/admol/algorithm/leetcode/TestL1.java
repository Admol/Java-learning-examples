package com.admol.algorithm.leetcode;

import com.admol.algorithm.leetcode.simple.array.Lc001;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author : admol
 * @Date : 2020/6/2
 */
@Slf4j
public class TestL1{

    @Test
    public void test(){
        Lc001 lc001 = new Lc001();
        int[] nums = {1,2,7,11,19};
        int[] result = lc001.twoSum(nums,8);
        log.info(JSON.toJSONString(result));
        result = lc001.twoSum(nums,9);
        log.info(JSON.toJSONString(result));
        result = lc001.twoSum(nums,23);
        log.info(JSON.toJSONString(result));

    }
}
