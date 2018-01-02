package jackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by chenxu on 2017/12/28.
 */
public class Tuple2Test {
    public static void main(String[] args) throws IOException {
        Tuple2<Long, Long> t1 = new Tuple2<>(1l, 2l);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(t1);
        System.out.println(json);
        Tuple2 tuple2 = mapper.readValue(json, new TypeReference<Tuple2<Long, Long>>(){});
        System.out.println(tuple2);
        SortedMap<Long, Tuple2<Long, Long>> map = new TreeMap<>();
        map.put(10l, t1);
        String j2 = mapper.writeValueAsString(map);
        SortedMap<Long, Tuple2<Long, Long>> map2 = mapper.readValue(j2, new TypeReference<TreeMap<Long, Tuple2<Long, Long>>>(){});
        System.out.println(map2);
    }
}
