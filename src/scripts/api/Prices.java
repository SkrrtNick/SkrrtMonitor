package scripts.api;

import org.tribot.script.sdk.pricing.Pricing;
import scripts.data.MethodItem;

import java.util.List;
import java.util.Optional;

public class Prices {
    private static Logger logger = new Logger().setHeader("Pricing");

    private static int getInputCost(List<MethodItem> methodItemList) {
        int total = 0;
        for (MethodItem m : methodItemList) {
            if(m.getItemID()==995){
                total+=m.getQuantity();
                continue;
            }
            Optional<Integer> price = Pricing.lookupPrice(m.getItemID());
            if (price.isEmpty()) {
                logger.setMessage("We were unable to get the price for " + m.getName()).print();
                return -1;
            } else {
                total += price.get() * m.getQuantity();
            }
        } return total;
    }

    private static int getOutputGains(List<MethodItem> methodItemList) {
        int total = 0;
        for (MethodItem m : methodItemList) {
            if(m.getItemID()==995){
                total+=m.getQuantity();
                continue;
            }
            Optional<Integer> price = Pricing.lookupPrice(m.getItemID());
            if (price.isEmpty()) {
                logger.setMessage("We were unable to get the price for " + m.getName()).print();
                return -1;
            } else {
                total += price.get() * m.getQuantity();
            }
        } return total;
    }

    public static int getProfit(List<MethodItem> inputItems, List<MethodItem> outputItems){
        return getOutputGains(outputItems) - getInputCost(inputItems);
    }
}
