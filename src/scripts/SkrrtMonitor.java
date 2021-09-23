package scripts;

import lombok.Getter;
import lombok.Setter;
import org.tribot.api.General;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Arguments;
import org.tribot.script.interfaces.MessageListening07;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.sdk.Login;

import org.tribot.script.sdk.util.ScriptSettings;
import org.tribot.script.sdk.walking.GlobalWalking;
import org.tribot.script.sdk.walking.adapter.DaxWalkerAdapter;
import scripts.api.Loggable;
import scripts.api.Logger;
import scripts.data.Profile;
import scripts.gui.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

@ScriptManifest(name = "SkrrtMonitor", authors = {"SkrrtNick"}, category = "Quests")
public class SkrrtMonitor extends Script implements Painting, MessageListening07, Arguments {
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
    private double version = .03;

    @Setter
    @Getter
    private static int reactionModifier;

    @Override
    public void run() {
        try {
            fxml = new URL("https://raw.githubusercontent.com/SkrrtNick/SkrrtMonitor/master/src/scripts/gui/gui.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        gui = new GUI(fxml);
        gui.show();
        while (gui.isOpen()) {
            setStatus("Waiting on user input...");
            sleep(500);
        }

        logger.setHeader("Profile").setMessage(getRunningProfile().toString()).print();
        GlobalWalking.setEngine(daxWalkerAdapter);
        if (!Login.isLoggedIn()) {
            Login.login();
        }
    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    final Image paintBg = getImage("https://imgur.com/kMTEXwM.png");

    final Image logo = getImage("https://imgur.com/9wb94qw.png");

    final Image timeIcon = getImage("https://imgur.com/Op2TyPM.png");

    final Image lootIcon = getImage("https://imgur.com/l1GJVQe.png");

    final Image clockworkIcon = getImage("https://imgur.com/Xu6s0s5.png");

    private final RenderingHints aa = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

    Font myMainFont = new Font("Calibri", 1, 12);
    Font versionFont = new Font("Calibri", 1, 10);

    @Override
    public void onPaint(Graphics ui) {
//        Graphics2D gg = (Graphics2D) ui;
//        gg.setRenderingHints(aa);
//        ui.setFont(myMainFont);
//        ui.setColor(new Color(1, 1, 1, 0.4f));
//        ui.drawImage(paintBg, 275, 208, 240, 130, null);
//        ui.drawImage(logo, 345, 213, 99, 33, null);
//        ui.setColor(Color.white);
//        ui.drawString("Status: " + getStatus(), 284, 260);
//        ui.setColor(Color.LIGHT_GRAY);
//        ui.drawImage(timeIcon, 284, 268, 10, 10, null);
//        ui.drawString("Runtime: " + Numbers.getHumanisedRuntime(START_TIME), 298, 277);
//        ui.drawImage(clockworkIcon, 284, 285, 10, 10, null);
//        ui.drawString("Total Crafted: " + MakingClockworks.getClockworks() + Numbers.getHourly(START_TIME, MakingClockworks.getClockworks()), 298, 294);
//        ui.drawImage(lootIcon, 284, 302, 10, 10, null);
//        ui.drawString(Prices.getProfitEstimation(MakingClockworks.getClockworks()) + Numbers.getHourly(START_TIME, Prices.getProfitEstimation(MakingClockworks.getClockworks())), 298, 311);
//        ui.setColor(Color.red);
//        ui.setFont(versionFont);
//        ui.drawString("V.", 480, 205);
//        ui.setColor(Color.ORANGE);
//        ui.drawString(String.valueOf(version), 490, 205);
    }

    @Override
    public void passArguments(HashMap<String, String> hashMap) {
        String scriptSelect = hashMap.get("custom_input");
        String clientStarter = hashMap.get("autostart");
        String input = clientStarter != null ? clientStarter : scriptSelect;
        String[] settings = input.split(":");
        String profileName = "";
        if (settings.length > 0) {
            for (String s : settings) {
                if (s.contains("settings:")) {
                    profileName = s.split(":")[1] != null ? s.split(":")[1] : null;
                    logger.setMessage(profileName).print();
                }
            }
            var loadSettings = ScriptSettings.getDefault()
                    .load(profileName,Profile.class)
                    .isPresent();
            if(loadSettings){
                logger.setLoggable(Loggable.MESSAGE).setMessage("Successfully loaded " + profileName).print();
                gui.close();
            } else {
                logger.setLoggable(Loggable.ERROR).setMessage("There was a problem loading " + profileName).print();
            }
        }

    }
}
