package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String last_name;
    @Value("${student.group}")
    private String group;

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGroup() {
        return group;
    }
}
