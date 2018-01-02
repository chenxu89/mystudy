package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxu on 2017/12/21.
 */
public class HeapOOM {
    static class OOMObject{
        public static void main(String[] args) {
            List<OOMObject> list = new ArrayList<>();
            while (true) {
                list.add(new OOMObject());
            }
        }
    }

}
