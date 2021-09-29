package scripts.data;

import lombok.Data;
import org.tribot.script.sdk.types.definitions.ItemDefinition;

import java.util.List;
@Data
public class MethodMonitor {
    private String name;
    private String monitorType;
    private List<MethodItem> inputItems;
    private List<MethodItem> outputItems;
    private int threshold;
    private int cooldown;
    private long lastPing;
    private int currentProfit;
    private String discordUrl;

    public MethodMonitor(String name, String monitorType, List<MethodItem> inputItems, List<MethodItem> outputItems, int threshold, int cooldown, String discordUrl) {
        this.name = name;
        this.monitorType = monitorType;
        this.inputItems = inputItems;
        this.outputItems = outputItems;
        this.threshold = threshold;
        this.cooldown = cooldown;
        this.discordUrl = discordUrl;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", monitorType=" + monitorType +
                ", inputItems=" + inputItems +
                ", outputItems=" + outputItems +
                ", threshold=" + threshold +
                ", cooldown=" + cooldown +
                ", discordUrl='" + discordUrl + '\'' +
                ']';
    }

    public void setLastPing() {
        this.lastPing = System.currentTimeMillis();
    }
}
