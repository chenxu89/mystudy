package deepcopy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenxu on 2017/12/17.
 */
public class DeepCopy {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(200);

        HashMap<String,Object> map = new HashMap<String,Object>();
        //放基本类型数据
        map.put("basic", 100);
        //放对象
        map.put("list", list);

        HashMap<String,Object> mapNew = new HashMap<String,Object>();
        HashMap<String,Object> mapNew2 = new HashMap<String,Object>();
        mapNew.putAll(map);
        mapNew2.putAll(map);

        System.out.println("----数据展示-----");
        System.out.println(map);
        System.out.println(mapNew);

        System.out.println("----更改基本类型数据-----");
        map.put("basic", 200);
        System.out.println(map);
        System.out.println(mapNew);

        System.out.println("----更改引用类型数据-----");
        list.add(300);
        System.out.println(map);
        System.out.println(mapNew);


        System.out.println("----使用序列化进行深拷贝-----");
        mapNew = CloneUtils.clone(map);
        list.add(400);
        System.out.println(map);
        System.out.println(mapNew);

        // 也不是深拷贝
        System.out.println("----使用构造函数进行拷贝-----");
        mapNew = new HashMap<>(map);
        list.add(400);
        System.out.println(map);
        System.out.println(mapNew);

        System.out.println("----mapNew2-----");
        list.add(500);
        map.remove("list");
        System.out.println(map);
        System.out.println(mapNew);
        System.out.println(mapNew2);

    }
}
