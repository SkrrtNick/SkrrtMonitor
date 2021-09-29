package scripts;

import lombok.Getter;
import lombok.Setter;
import org.tribot.api.General;
import org.tribot.script.ScriptManifest;
import org.tribot.script.sdk.painting.Painting;
import org.tribot.script.sdk.script.ScriptConfig;
import org.tribot.script.sdk.script.TribotScript;
import org.tribot.script.sdk.util.ScriptSettings;
import org.tribot.script.sdk.walking.adapter.DaxWalkerAdapter;
import scripts.api.*;
import scripts.api.fluffee.FluffeesPaint;
import scripts.api.fluffee.PaintInfo;
import scripts.data.MethodMonitor;
import scripts.data.Profile;
import scripts.gui.GUI;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

@ScriptManifest(name = "SkrrtMonitor", authors = {"SkrrtNick"}, category = "Tools")
public class SkrrtMonitor implements TribotScript, PaintInfo {
    Logger logger = new Logger().setHeader("SkrrtScripts");
    DaxWalkerAdapter daxWalkerAdapter = new DaxWalkerAdapter("sub_JmRkbIB2XRYqmf", "7227dd88-8182-4cd9-a3d9-00b8fa6ff56e");
    @Setter
    @Getter
    private static String status;
    @Setter
    @Getter
    private static Profile runningProfile = new Profile();
    @Setter
    @Getter
    private static boolean isRunning = true;
    @Getter
    private static final long START_TIME = System.currentTimeMillis();
    private URL fxml;
    private GUI gui;
    @Setter
    @Getter
    private String mostProfitable;
    @Setter
    @Getter
    private int mostProfit = 0, combinedProfit = 0;
    Timer timer = new Timer(0);
    private double version = .01;

    @Override
    public String[] getPaintInfo() {
        if(getRunningProfile().getMethodMonitors()==null){
            return new String[]{"SkrrtMonitor v" + version, "Time ran: " + SkrrtPaint.getRuntimeString(), "Status: " + getStatus()};
        }
        return new String[]{"SkrrtMonitor v" + version, "Time ran: " + SkrrtPaint.getRuntimeString(), "Status: " + getStatus(), "Most Profitable Method: " + getMostProfitable(), "Total Value of Monitored Methods: " + getCombinedProfit(getRunningProfile().getMethodMonitors())};
    }

    private final FluffeesPaint SkrrtPaint = new FluffeesPaint(this, FluffeesPaint.PaintLocations.BOTTOM_LEFT_PLAY_SCREEN, new Color[]{new Color(255, 251, 255)}, "Trebuchet MS", new Color[]{new Color(0, 0, 0, 124)},
            new Color[]{new Color(179, 0, 0)}, 1, false, 5, 3, 0);

    @Override
    public void configure(ScriptConfig config) {
        config.setRandomsAndLoginHandlerEnabled(false);
    }

    @Override
    public void execute(String args) {
        Painting.setPaint(SkrrtPaint::paint);
        if (!args.isBlank()) {
            ScriptSettings settings = ScriptSettings.getDefault();
            settings.load(args, Profile.class).ifPresent(SkrrtMonitor::setRunningProfile);
        }
        if (getRunningProfile().getMethodMonitors()==null) {
            try {
                fxml = new URL("https://raw.githubusercontent.com/SkrrtNick/SkrrtMonitor/master/src/scripts/gui/main/gui.fxml");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            gui = new GUI(fxml);
            gui.show();
            while (gui.isOpen()) {
                setStatus("Waiting on user input...");
                General.sleep(500);
            }
        }
        logger.setHeader("Profile").setMessage(getRunningProfile().toString()).print();

        while (isRunning()) {
            for (MethodMonitor m : getRunningProfile().getMethodMonitors()) {
                m.setCurrentProfit(Prices.getProfit(m.getInputItems(), m.getOutputItems()));
                if (getMostProfit() < m.getCurrentProfit()) {
                    setMostProfitable(m.getName());
                    setMostProfit(m.getCurrentProfit());
                }
                if (System.currentTimeMillis() - m.getLastPing() > (m.getCooldown() * 60000L)) {
                    setStatus("Monitoring methods");
                    switch (m.getMonitorType()) {
                        case "Above gp/hr threshold":
                            if (m.getCurrentProfit() > m.getThreshold()) {
                                logger.setLoggable(Loggable.MESSAGE).setMessage(m.getName() + " is currently exceeding the threshold of " + m.getThreshold() + "gp per hour and is at " + m.getCurrentProfit()).print();
                                DiscordWebhook.sendWebhook(m.getDiscordUrl(), m.getName() + " is currently profiting " + m.getCurrentProfit() + "gp per hour");
                            }
                            break;
                        case "Below gp/hr threshold":
                            if (m.getCurrentProfit() < m.getThreshold()) {
                                logger.setLoggable(Loggable.MESSAGE).setMessage(m.getName() + " is currently below the threshold of " + m.getThreshold() + "gp per hour and is at " + m.getCurrentProfit()).print();
                                DiscordWebhook.sendWebhook(m.getDiscordUrl(), m.getName() + " is currently under " + m.getCurrentProfit() + "gp per hour");
                            }
                            break;
                        case "Once every 24 hours":
                            if (timer.timedOut() || timer.getStartTime() == 0) {
                                timer.setTimeOut(86400000);
                                logger.setLoggable(Loggable.MESSAGE).setMessage(m.getName() + " is currently at " + m.getCurrentProfit() + "gp per hour").print();
                                DiscordWebhook.sendWebhook(m.getDiscordUrl(), m.getName() + " is currently " + m.getCurrentProfit() + "gp per hour");
                                timer.start();
                            }
                            break;
                        case "Once every hour":
                            if (timer.timedOut() || timer.getStartTime() == 0) {
                                timer.setTimeOut(3600000);
                                logger.setLoggable(Loggable.MESSAGE).setMessage(m.getName() + " is currently at " + m.getCurrentProfit() + "gp per hour").print();
                                DiscordWebhook.sendWebhook(m.getDiscordUrl(), m.getName() + " is currently " + m.getCurrentProfit() + "gp per hour");
                                timer.start();
                            }
                            break;
                    }
                    m.setLastPing();
                } else {
                    setStatus("Waiting for cooldown to finish");
                }
            }
            General.sleep(5000);
        }
    }

    private int getCombinedProfit(java.util.List<MethodMonitor> methodMonitors) {
        int profit = 0;
        for (MethodMonitor m : methodMonitors) {
            profit += m.getCurrentProfit();
        }
        return profit;
    }

}
