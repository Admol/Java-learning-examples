package net.admol.jingling.demo.concurrent;


import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jingling
 * @Date : 2021/2/9
 */
public class ConcurrentHashMapTest{


    private String jinglingwang;

    public String domain(String jinglingwang){
        if(StringUtils.isEmpty(jinglingwang)){

        }
        output();
        return jinglingwang;
    }





    private void output(){
        System.out.println("http://jinglingwang.cn  1");
        System.out.println("http://jinglingwang.cn  2");
        System.out.println("http://jinglingwang.cn  3");
        System.out.println("http://jinglingwang.cn  4");
    }


    //
//    public static void main(String[] args){
//        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap(10,0.75f,2);
//        // 1.新增元素
//        map.put("1",0);
//        map.put("2",4);
//        map.put("3",6);
//        map.put("4",8);
////        System.out.println(map.putIfAbsent(1,1));
////        System.out.println(map.putIfAbsent(2,1));
//        // 2.删除元素
////        map.remove(1);
////        map.remove(2,2);
//
//        // 3.替换元素
////        map.replace(1,3);
////        map.replace(1,2,4);
////        map.replaceAll((key,value)->value << 1);
//
//        // 根据自定义函数查找key value，
//        Integer v = map.search(5,(key,value)->{
//            System.out.println(key + "  " + value);
//            return (value & 1) == 0 ? value : null;
//        });
//        System.out.println(v);
//        // 根据自定义函数查找key
//        String k = map.searchKeys(5,(key)->{
//            return "jinglingwang".equals(key) ? key : null;
//        });
//        System.out.println(k);
//        // 根据自定义函数查找value
//        Integer v2 = map.searchValues(5,(value)->{
//            return value == 2 ? 520 : null;
//        });
//        System.out.println(v2);
//
//        Integer a = map.searchEntries(5,(entry)->{
//            System.out.println("entry:"+entry.getKey() + "   " + entry.getValue());
//            return "jinglingwang.cn".equals(entry.getKey()) ? 1 : null;
//        });
//        System.out.println(a);
//
//        System.out.println(map.contains(4));
//
//        System.out.println(map.keys());
//        System.out.println(map.keySet());
//        System.out.println(map.keySet(100));
//        System.out.println(map.elements());
//
//        System.out.println("==========entrySet.forEach==============");
//        map.entrySet().forEach((entry)->{
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });
//        System.out.println("==========forEach==============");
//        map.forEach((key,value)->{
//            System.out.println(key+ " " + value);
//        });
//        System.out.println("==========forEach2==============");
//        map.forEach(5,(key,value)->{
//            System.out.println(key+ " " + value);
//            return (value & 1) == 0 ? "jinglingwang.cn" : null;
//        },aa->{
//            System.out.println(aa);
//        });
//
//        System.out.println("==========forEachEntry==============");
//        map.forEachEntry(5,(entry)->{
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });
//        System.out.println("==========forEachEntry2==============");
//        map.forEachEntry(5,(entry)->{
//            System.out.println(entry.getKey() + " " + entry.getValue());
//            return (entry.getValue() & 1) == 0 ? "jinglingwang.cn" : null;
//        },aa->{
//            System.out.println(aa);
//        });
//
//        System.out.println("==========forEachKey==============");
//        map.forEachKey(5,key->{
//            System.out.println("key: " + key);
//        });
//        System.out.println("==========forEachKey==============");
//        map.forEachKey(5,key->{
//            System.out.println("key: " + key);
//            return !key.equals("jinglingwang") ? "jinglingwang.cn" : null;
//        },kk ->{
//            System.out.println(kk);
//        });
//        System.out.println("==========forEachValue==============");
//        map.forEachValue(5,value->{
//            System.out.println("value: " + value);
//        });
//        System.out.println("==========forEachValue==============");
//        map.forEachValue(5,value->{
//            System.out.println("value: " + value);
//            return (value & 1) == 0 ? "jinglingwang.cn" : null;
//        },vv ->{
//            System.out.println(vv);
//        });
//
//        System.out.println("==========map.reduce()==============");
//        String res =  map.reduce(5,(key,value)->{
//            System.out.println("transformer key:"+key+" value:"+value);
//            return value+"";
//        },(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return key+value+"";
//        });
//        System.out.println("res:"+res);
//
//        System.out.println("==========map.reduceEntries()==============");
//        Map.Entry reduceEntries =  map.reduceEntries(5,entry->{
//            System.out.println("transformer key:"+entry.getKey()+" value:"+entry.getValue());
//            return entry;
//        },(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return value;
//        });
//        System.out.println("reduceEntries:"+reduceEntries);
//
//
//        System.out.println("==========map.reduceEntries2()==============");
//        String reduceEntries2 =  map.reduceEntries(5,(entry)->{
//            System.out.println("transformer key:"+entry.getKey()+" value:"+entry.getValue());
//            return entry.getValue()+"";
//        },(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return key+value+"";
//        });
//        System.out.println("reduceEntries2:"+reduceEntries2);
//
//        System.out.println("==========map.reduceEntriesToDouble()==============");
//        Double reduceEntriesToDouble = map.reduceEntriesToDouble(5,entry->{
//            System.out.println("transformer key:"+entry.getKey()+" value:"+entry.getValue());
//            return Double.valueOf(entry.getValue());
//        },100,(l,r)->{
//            System.out.println("reducer key:"+l+" value:"+r);
//            return l+r;
//        });
//        System.out.println("reduceEntriesToDouble:"+reduceEntriesToDouble);
//
//        System.out.println("==========map.reduceKeys()==============");
//        String newKey = map.reduceKeys(5,(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return key+value;
//        });
//        System.out.println("newKey:"+newKey);
//
//        System.out.println("==========map.reduceKeys()==============");
//        String newValue = map.reduceKeys(5,(key)->{
//            System.out.println("transformer key:"+key);
//            return key;
//        },(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return key+value;
//        });
//        System.out.println("newValue:"+newValue);
//
//        System.out.println("==========map.reduceKeysToDouble()==============");
//        double reduceKeysToDouble = map.reduceKeysToDouble(5,(key)->{
//            System.out.println("transformer key:"+key);
//            return Double.parseDouble(key);
//        },100,(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return key+value;
//        });
//        System.out.println("reduceKeysToDouble:"+reduceKeysToDouble);
//
//        System.out.println("==========map.reduceToDouble()==============");
//        double reduceToDouble = map.reduceToDouble(5,(key,value)->{
//            System.out.println("transformer key:"+key+" value:"+value);
//            return value;
//        },100,(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return key+value;
//        });
//        System.out.println("reduceToDouble:"+reduceToDouble);
//
//        System.out.println("==========map.reduceValues()==============");
//        double reduceValues = map.reduceValues(5,(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return key+value;
//        });
//        System.out.println("reduceValues:"+reduceValues);
//        System.out.println("==========map.reduceValues()==============");
//        double reduceValues2 = map.reduceValues(5,(value)->{
//            System.out.println("transformer value:"+value);
//            return Double.valueOf(value);
//        },(l,r)->{
//            System.out.println("reducer key:"+l+" value:"+r);
//            return l+r;
//        });
//        System.out.println("reduceValues2:"+reduceValues2);
//
//        System.out.println("==========map.reduceValuesToDouble()==============");
//        double reduceValuesToDouble = map.reduceValuesToDouble(5,(value)->{
//            System.out.println("transformer value:"+value);
//            return Double.valueOf(value);
//        },100,(l,r)->{
//            System.out.println("reducer key:"+l+" value:"+r);
//            return l+r;
//        });
//        System.out.println("reduceValuesToDouble:"+reduceValuesToDouble);
//
//        // 输出map
//        System.out.println("==========map.toString()==============");
//        System.out.println("输出map:"+ map.toString());
//
//
//
//        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
//        for(int i = 1; i <= 10; i++) {
//            concurrentHashMap.put(i, i);
//        }
//        System.out.println("now concurrentHashMap: " + concurrentHashMap);
//        Double reduceToDouble2222 = concurrentHashMap.reduceToDouble(0,
//                (key, value) -> {  return value; },
//                10,
//                (obj1, obj2) -> { return obj1 + obj2;}
//        );
//        System.out.println("reduceToDouble2222:"+reduceToDouble2222);
//        System.out.println("");
//
//        double reduceToDouble33333 = concurrentHashMap.reduceToDouble(1,(key,value)->{
//            System.out.println("transformer key:"+key+" value:"+value);
//            return value;
//        },10,(key,value)->{
//            System.out.println("reducer key:"+key+" value:"+value);
//            return value;
//        });
//        System.out.println("reduceToDouble33333:"+reduceToDouble33333);
//
//
//
//    }



}
