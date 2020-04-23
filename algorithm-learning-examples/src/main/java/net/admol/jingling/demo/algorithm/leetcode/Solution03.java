package net.admol.jingling.demo.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : jingling
 * @Date : 2018/8/30
 */
@Slf4j
public class Solution03{
    public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0, i = 0; j < n; j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    int cc = map.get(c);
                    i = Math.max(cc, i);
                }
                int m = j - i + 1;
                ans = Math.max(ans,m);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
    }
    @Test
    public void test(){
        log.info("result:{}",lengthOfLongestSubstring("asdafagarg"));
    }

}
