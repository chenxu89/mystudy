package jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenxu on 2017/12/28.
 */
public class JacksonIgnore {

    public static class Release {
        public final String version;

        public Release(String version) {
            this.version = version;
        }
    }

    public static class Project {
        public final String name;

        public Project(String name) {
            this.name = name;
        }

        @JsonIgnore
        public List<Release> getAllReleases() {
            return Arrays.asList(new Release("r1"), new Release("r2"));
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Project("test")));
    }
}
