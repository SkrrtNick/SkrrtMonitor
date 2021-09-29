package scripts.data;

import lombok.Data;
import org.tribot.script.sdk.types.definitions.ItemDefinition;
@Data
public class MethodItem {
    int itemID;
    double quantity;
    String name;

    public MethodItem(int itemID, double quantity) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.name = ItemDefinition.get(itemID).map(ItemDefinition::getName).orElse("Unable to get Item Name");
    }
    public MethodItem(int itemID, int quantity) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.name = ItemDefinition.get(itemID).map(ItemDefinition::getName).orElse("Unable to get Item Name");
    }

    @Override
    public String toString() {
        return "{" + quantity +
                "x '" + name +
                '}';
    }
}
