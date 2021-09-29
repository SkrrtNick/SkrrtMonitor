package scripts.data;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Getter
public enum MonitorTypes {


    MONITOR_ABOVE_THRESHOLD("Above gp/hr threshold"),
    MONITOR_BELOW_THRESHOLD("Below gp/hr threshold"),
    MONITOR_DAILY("Once every 24 hours"),
    MONITOR_HOURLY("Once every hour");

    private String name;

    MonitorTypes(String name) {
        this.name = name;
    }

    public static List<String> getTypes(){
        return Stream.of(MonitorTypes.values())
                .map(MonitorTypes::getName).collect(Collectors.toList());
    }

}
