package net.admol.jingling.demo.zuoye;

/**
 * 有 1、2、3 个数字，能组成多少个互不相同且无重复数字的两位数。编写程序输出所有符
 * 合条件的两位数
 * @author : admol
 * @Date : 2020/5/24
 */
public class Test02{
    public static void main(String[] args) {
        int count = 0;
        for(int x=1; x < 4; x++) {
            for(int y=1; y < 4; y++) {
                if(x != y ) {
                    count ++;
                    System.out.println(x*10 + y );
                }
            }
        }
        System.out.println("一共有"+count+"个两位数");
    }
}
