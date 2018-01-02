package jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tuple2<T1,T2> {
    public final T1 o1;
    public final T2 o2;

    @JsonCreator
    public Tuple2(@JsonProperty("o1") T1 o1, @JsonProperty("o2") T2 o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    @JsonIgnore
    public T1 getFirst() {
        return this.o1;
    }
    @JsonIgnore
    public T2 getSecond() {
        return this.o2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Tuple2 tuple2 = (Tuple2) o;

        if (o1 != null ? !o1.equals(tuple2.o1) : tuple2.o1 != null) return false;
        if (o2 != null ? !o2.equals(tuple2.o2) : tuple2.o2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = o1 != null ? o1.hashCode() : 0;
        result = 31 * result + (o2 != null ? o2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", o1, o2);
    }
}
