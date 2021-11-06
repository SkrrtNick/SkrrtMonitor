package scripts.gui.main;

import com.allatori.annotations.DoNotRename;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import org.tribot.script.sdk.*;
import org.tribot.script.sdk.types.Widget;
import org.tribot.script.sdk.util.ScriptSettings;
import scripts.SkrrtMonitor;
import scripts.api.Loggable;
import scripts.api.Logger;
import scripts.data.MethodItem;
import scripts.data.MethodMonitor;
import scripts.data.MonitorTypes;
import scripts.data.Profile;
import scripts.data.presets.Preset;
import scripts.data.presets.Quests;
import scripts.data.presets.SkillRequirement;
import scripts.gui.AbstractGUIController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@DoNotRename
public class GUIController extends AbstractGUIController {
    private Alert alert = new Alert(Alert.AlertType.ERROR);
    private Logger logger = new Logger().setHeader("GUI");
    private List<MethodMonitor> methods = new ArrayList<>();
    @DoNotRename
    @FXML
    private Button btnAddMonitor;
    @DoNotRename
    @FXML
    private Button btnLoad;
    @DoNotRename
    @FXML
    private Button btnSave;

    @DoNotRename
    @FXML
    void btnLoadPressed(ActionEvent event) {
        String profileName = cmbProfile.getEditor().getText();
        if (profileName == null || profileName.isBlank()) {
            logger
                    .setLoggable(Loggable.ERROR)
                    .setMessage("Please enter a profile name")
                    .print();
        } else {
            load(profileName);
        }
    }

    @DoNotRename
    @FXML
    void btnSavePressed(ActionEvent event) {
        save(cmbProfile.getEditor().getText());
    }

    @DoNotRename
    @FXML
    private Button btnStart;
    @DoNotRename
    @FXML
    private ComboBox<String> cmbProfile;
    @DoNotRename
    @FXML
    private ComboBox<String> cmbType;
    @DoNotRename
    @FXML
    private ListView<MethodMonitor> listMonitors;
    @DoNotRename
    @FXML
    private TextField txtInput;
    @DoNotRename
    @FXML
    private Button btnPreset;
    @DoNotRename
    @Getter
    @FXML
    private TextField txtName;
    @DoNotRename
    @Getter
    @FXML
    private TextField txtOutput;
    @DoNotRename
    @FXML
    private TextField txtThreshold;
    @DoNotRename
    @FXML
    private TextField txtUrl;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinCooldown;
    private List<String> questRequirements = new ArrayList<>();
    @DoNotRename
    @FXML
    private ListView<Preset> listPresets;
    @DoNotRename
    @FXML
    private ListView<String> listQuests;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinAgility;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinAttack;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinConstruction;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinCooking;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinCrafting;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinDefence;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinFarming;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinFiremaking;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinFishing;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinFletching;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinHerblore;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinHitpoints;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinMagic;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinMining;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinPrayer;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinRanged;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinRunecrafting;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinSlayer;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinSmithing;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinStrength;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinThieving;
    @DoNotRename
    @FXML
    private Spinner<Integer> spinWoodcutting;
    @DoNotRename
    @FXML
    private Button btnPresets;
    @DoNotRename
    @FXML
    private Button btnHiscore;
    @DoNotRename
    @FXML
    private Button btnRefresh;
    @DoNotRename
    @FXML
    private Button btnIngame;
    @DoNotRename
    @FXML
    private MenuItem menuAddPreset;
    @DoNotRename
    @FXML
    private TextField txtUsername;

    @DoNotRename
    @FXML
    private ListView<String> listEnabledQuests;
    List<String> quests = Quests.getQuests();

    @DoNotRename
    @FXML
    void btnHiscoresPressed(ActionEvent event) {
        String username = txtUsername.getText();
        if (txtUsername.getText().isBlank()) {
            logger.setLoggable(Loggable.ERROR).setMessage("Please enter a username").print();
            return;
        } else {
            var player = Hiscores.lookup(username);
            if (player.isEmpty()) {
                logger.setMessage("Unable to find " + username + " on the hiscores, please try again.").setLoggable(Loggable.ERROR).print();
            } else {
                setHiscoreValue(player.get(), spinAgility, Hiscores.Skill.AGILITY);
                setHiscoreValue(player.get(), spinAttack, Hiscores.Skill.ATTACK);
                setHiscoreValue(player.get(), spinStrength, Hiscores.Skill.STRENGTH);
                setHiscoreValue(player.get(), spinRanged, Hiscores.Skill.RANGED);
                setHiscoreValue(player.get(), spinPrayer, Hiscores.Skill.PRAYER);
                setHiscoreValue(player.get(), spinMagic, Hiscores.Skill.MAGIC);
                setHiscoreValue(player.get(), spinRunecrafting, Hiscores.Skill.RUNECRAFT);
                setHiscoreValue(player.get(), spinHitpoints, Hiscores.Skill.HITPOINTS);
                setHiscoreValue(player.get(), spinCrafting, Hiscores.Skill.CRAFTING);
                setHiscoreValue(player.get(), spinMining, Hiscores.Skill.MINING);
                setHiscoreValue(player.get(), spinSmithing, Hiscores.Skill.SMITHING);
                setHiscoreValue(player.get(), spinFishing, Hiscores.Skill.FISHING);
                setHiscoreValue(player.get(), spinCooking, Hiscores.Skill.COOKING);
                setHiscoreValue(player.get(), spinFiremaking, Hiscores.Skill.FIREMAKING);
                setHiscoreValue(player.get(), spinHerblore, Hiscores.Skill.HERBLORE);
                setHiscoreValue(player.get(), spinFletching, Hiscores.Skill.FLETCHING);
                setHiscoreValue(player.get(), spinSlayer, Hiscores.Skill.SLAYER);
                setHiscoreValue(player.get(), spinFarming, Hiscores.Skill.FARMING);
                setHiscoreValue(player.get(), spinConstruction, Hiscores.Skill.CONSTRUCTION);
                listPresets.setItems(FXCollections.observableList(Preset.getViablePresets(questRequirements, getSpinnerSkills())));
            }
        }

    }

    @DoNotRename
    @FXML
    void addPresetClicked(ActionEvent event) {
        Preset selectedPreset = listPresets.getSelectionModel().getSelectedItem();
        if (selectedPreset != null) {
            txtName.setText(selectedPreset.getName());
            txtInput.setText(parseMethodList(selectedPreset.getInputItems()));
            txtOutput.setText(parseMethodList(selectedPreset.getOutputItems()));
        }
    }

    @DoNotRename
    @FXML
    void btnShowPresetsClicked(ActionEvent event) {
        listPresets.setItems(FXCollections.observableList(Preset.getAllPresets()));
    }

    @DoNotRename
    @FXML
    void btnIngamePressed(ActionEvent event) {
        final int CHILD_F2P_QUEST = 6;
        final int CHILD_P2P_QUEST = 7;
        if (Login.login()) {
            if (Waiting.waitUntil(10000, Login::isLoggedIn)) {
                setIngameValue(spinAgility, Skill.AGILITY);
                setIngameValue(spinAttack, Skill.ATTACK);
                setIngameValue(spinStrength, Skill.STRENGTH);
                setIngameValue(spinRanged, Skill.RANGED);
                setIngameValue(spinPrayer, Skill.PRAYER);
                setIngameValue(spinMagic, Skill.MAGIC);
                setIngameValue(spinRunecrafting, Skill.RUNECRAFT);
                setIngameValue(spinHitpoints, Skill.HITPOINTS);
                setIngameValue(spinCrafting, Skill.CRAFTING);
                setIngameValue(spinMining, Skill.MINING);
                setIngameValue(spinSmithing, Skill.SMITHING);
                setIngameValue(spinFishing, Skill.FISHING);
                setIngameValue(spinCooking, Skill.COOKING);
                setIngameValue(spinFiremaking, Skill.FIREMAKING);
                setIngameValue(spinHerblore, Skill.HERBLORE);
                setIngameValue(spinFletching, Skill.FLETCHING);
                setIngameValue(spinSlayer, Skill.SLAYER);
//            setIngameValue(spinFarming, Skill.FARMING);
                setIngameValue(spinConstruction, Skill.CONSTRUCTION);
            }
            if (!GameTab.QUESTS.isOpen()) {
                if (GameTab.QUESTS.open()) {
                    Waiting.waitUntil(GameTab.QUESTS::isOpen);
                }
            }
            var f2pQuests = getCompletedQuests(CHILD_F2P_QUEST);
            var p2pQuests = getCompletedQuests(CHILD_P2P_QUEST);
            List<String> ingameQuests = new ArrayList<>();
            f2pQuests.forEach(i -> i.ifPresent(ingameQuests::add));
            p2pQuests.forEach(i -> i.ifPresent(ingameQuests::add));
            questRequirements.addAll(ingameQuests);
            quests.removeAll(ingameQuests);
            listQuests.refresh();
            listEnabledQuests.setItems(FXCollections.observableList(questRequirements));
            listEnabledQuests.refresh();
            listPresets.setItems(FXCollections.observableList(Preset.getViablePresets(questRequirements, getSpinnerSkills())));
        }
    }

    void setHiscoreValue(Hiscores.Player player, Spinner<Integer> spinner, Hiscores.Skill skill) {
        String name = txtUsername.getText();
        if (name.isBlank()) {
            logger.setLoggable(Loggable.ERROR).setMessage("Please enter a username").print();
            return;
        }
        player.getSkill(skill)
                .map(Hiscores.SkillRanking::getLevel)
                .ifPresent(x -> spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, x)));
    }

    void setIngameValue(Spinner<Integer> spinner, Skill skill) {
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, skill.getActualLevel()));
    }

    List<Optional<String>> getCompletedQuests(int widget) {
        final int ROOT_QUEST = 399;
        var widgets = Widgets.get(ROOT_QUEST, widget).stream()
                .flatMap(w -> w.getChildren().stream())
                .filter(i -> i.getTextColor() == 901389)
                .map(Widget::getText)
                .collect(Collectors.toList());
        if (widgets.isEmpty()) {
            return List.of();
        } else {
            return widgets;
        }
    }

    @DoNotRename
    @FXML
    void btnRefreshClicked(ActionEvent event) {
        listPresets.setItems(FXCollections.observableList(Preset.getViablePresets(questRequirements, getSpinnerSkills())));
    }


    @DoNotRename
    @FXML
    void profileClicked(ActionEvent event) throws IOException, URISyntaxException {
        getGUI().openBrowser("https://community.tribot.org/profile/300380-gigiwest123/");
    }

    @DoNotRename
    @FXML
    void threadClicked(ActionEvent event) throws IOException, URISyntaxException {
        getGUI().openBrowser("https://community.tribot.org/topic/83999-skrrtmonitor");
    }

    @DoNotRename
    @FXML
    void addMonitorPressed(ActionEvent event) {
        List<String> fields = List.of(txtName.getText(), txtUrl.getText(), txtOutput.getText());
        for (String f : fields) {
            if (f.isBlank()) {
                alert.setTitle("Warning!");
                alert.setHeaderText("Warning!");
                alert.setContentText("Please ensure you populate the name, url and output fields");
                alert.show();
                return;
            }
        }
        List<MethodItem> inputItems = new ArrayList<>();
        String[] inputs = txtInput.getText().split(",");
        if (inputs.length > 0) {
            for (String i : inputs) {
                if (!i.contains(":")) {
                    logger.setMessage("Please ensure you separate the item id and quantity with a colon : ").setLoggable(Loggable.ERROR).print();
                    break;
                }
                int id = Integer.parseInt(i.split(":")[0]);
                double quantity = Double.parseDouble(i.split(":")[1]);
                inputItems.add(new MethodItem(id, quantity));
            }
        }
        List<MethodItem> outputItems = new ArrayList<>();
        String[] outputs = txtOutput.getText().split(",");
        if (outputs.length > 0) {
            for (String o : outputs) {
                if (!o.contains(":")) {
                    logger.setMessage("Please ensure you separate the item id and quantity with a colon : ").setLoggable(Loggable.ERROR).print();
                    break;
                }
                int id = Integer.parseInt(o.split(":")[0]);
                double quantity = Double.parseDouble(o.split(":")[1]);
                outputItems.add(new MethodItem(id, quantity));
            }
        }
        MethodMonitor currentSelected = listMonitors.getSelectionModel().getSelectedItem();
        if (currentSelected == null) {
            methods.add(new MethodMonitor(txtName.getText(), cmbType.getValue(), inputItems, outputItems, Integer.parseInt(txtThreshold.getText()), spinCooldown.getValue(), txtUrl.getText()));
        } else {
            methods.remove(currentSelected);
            methods.add(new MethodMonitor(txtName.getText(), cmbType.getValue(), inputItems, outputItems, Integer.parseInt(txtThreshold.getText()), spinCooldown.getValue(), txtUrl.getText()));
        }
        logger.setMessage(inputItems.toString()).print();
        listMonitors.setItems(FXCollections.observableList(methods));
    }

    @DoNotRename
    @FXML
    void startPressed(ActionEvent event) {
        SkrrtMonitor.getRunningProfile().setMethodMonitors(methods);
        save("last");
        SkrrtMonitor.setRunning(true);
        getGUI().close();
    }

    @DoNotRename
    @FXML
    void editClicked(ActionEvent event) {
        MethodMonitor methodMonitor = listMonitors.getSelectionModel().getSelectedItem();
        if (methodMonitor != null) {
            txtName.setText(methodMonitor.getName());
            txtUrl.setText(methodMonitor.getDiscordUrl());
            txtInput.setText(parseMethodList(methodMonitor.getInputItems()));
            txtOutput.setText(parseMethodList(methodMonitor.getOutputItems()));
            cmbType.getSelectionModel().select(methodMonitor.getMonitorType());
            txtThreshold.setText(String.valueOf(methodMonitor.getThreshold()));
            spinCooldown.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 1440, methodMonitor.getCooldown()));
        }
    }

    @DoNotRename
    @FXML
    void deleteClicked(ActionEvent event) {
        listMonitors.getItems().remove(listMonitors.getSelectionModel().getSelectedItem());
    }

    @DoNotRename
    @FXML
    void duplicateClicked(ActionEvent event) {
        MethodMonitor methodMonitor = listMonitors.getSelectionModel().getSelectedItem();
        if (methodMonitor != null) {
            listMonitors.getItems().add(methodMonitor);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbType.setItems(FXCollections.observableList(MonitorTypes.getTypes()));
        spinCooldown.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 1440, 5));
        load("last");
        updateSaveNames();
        List<Spinner<Integer>> spinners = List.of(
                spinAgility
                , spinAttack
                , spinConstruction
                , spinCooking
                , spinCrafting
                , spinDefence
                , spinFarming
                , spinFiremaking
                , spinFishing
                , spinFletching
                , spinHerblore
                , spinHitpoints
                , spinMagic
                , spinMining
                , spinPrayer
                , spinRanged
                , spinRunecrafting
                , spinSlayer
                , spinSmithing
                , spinStrength
                , spinThieving
                , spinWoodcutting);
        for (Spinner<Integer> s : spinners) {
            s.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99));
        }
        quests = Quests.getQuests();
        listQuests.setItems(FXCollections.observableList(quests));
        listPresets.setItems(FXCollections.observableList(Preset.getAllPresets()));
        listQuests.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    String questReq = listQuests.getSelectionModel().getSelectedItem();
                    if (questReq != null) {
                        questRequirements.add(questReq);
                        quests.remove(questReq);
                        listQuests.refresh();
                        listEnabledQuests.setItems(FXCollections.observableList(questRequirements));
                        listEnabledQuests.refresh();
                    }
                }
            }
        });
        listEnabledQuests.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    String questReq = listEnabledQuests.getSelectionModel().getSelectedItem();
                    if (questReq != null) {
                        questRequirements.remove(questReq);
                        quests.add(questReq);
                        listQuests.refresh();
                        listEnabledQuests.refresh();
                    }
                }
            }
        });

    }

    void save(String name) {
        ScriptSettings settings = ScriptSettings.getDefault();
        Profile profile = new Profile();
        profile.setMethodMonitors(methods);
        settings.save(name, profile);
        updateSaveNames();
    }

    void load(String name) {
        ScriptSettings settings = ScriptSettings.getDefault();
        settings.load(name, Profile.class).ifPresent(
                s -> {
                    if (s.getMethodMonitors() != null) {
                        methods.addAll(s.getMethodMonitors());
                    }
                });
        listMonitors.setItems(FXCollections.observableList(methods));
    }

    void updateSaveNames() {
        ScriptSettings loadableProfiles = ScriptSettings.getDefault();
        List<String> profiles = loadableProfiles.getSaveNames();
        if (!profiles.isEmpty()) cmbProfile.setItems(FXCollections.observableList(profiles));
    }

    String parseMethodList(List<MethodItem> methodItemList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (MethodItem m : methodItemList) {
            if (stringBuilder.toString().equals("")) {
                stringBuilder = new StringBuilder(String.join(":", String.valueOf(m.getItemID()), String.valueOf(m.getQuantity())));
            } else {
                stringBuilder.append(",").append(String.join(":", String.valueOf(m.getItemID()), String.valueOf(m.getQuantity())));
            }
        }
        return stringBuilder.toString();
    }

    private List<SkillRequirement> getSpinnerSkills() {
        return List.of(
                new SkillRequirement(Skill.AGILITY, spinAgility.getValue()),
                new SkillRequirement(Skill.ATTACK, spinAttack.getValue()),
                new SkillRequirement(Skill.CONSTRUCTION, spinConstruction.getValue()),
                new SkillRequirement(Skill.COOKING, spinCooking.getValue()),
                new SkillRequirement(Skill.CRAFTING, spinCrafting.getValue()),
                new SkillRequirement(Skill.DEFENCE, spinDefence.getValue()),
//                new SkillRequirement(Skill.FARMING,spinFarming.getValue()),
                new SkillRequirement(Skill.FIREMAKING, spinFiremaking.getValue()),
                new SkillRequirement(Skill.FISHING, spinFishing.getValue()),
                new SkillRequirement(Skill.FLETCHING, spinFletching.getValue()),
                new SkillRequirement(Skill.HERBLORE, spinHerblore.getValue()),
                new SkillRequirement(Skill.HITPOINTS, spinHitpoints.getValue()),
                new SkillRequirement(Skill.MAGIC, spinMagic.getValue()),
                new SkillRequirement(Skill.MINING, spinMining.getValue()),
                new SkillRequirement(Skill.PRAYER, spinPrayer.getValue()),
                new SkillRequirement(Skill.RANGED, spinRanged.getValue()),
                new SkillRequirement(Skill.RUNECRAFT, spinRunecrafting.getValue()),
                new SkillRequirement(Skill.SLAYER, spinSlayer.getValue()),
                new SkillRequirement(Skill.SMITHING, spinSmithing.getValue()),
                new SkillRequirement(Skill.STRENGTH, spinStrength.getValue()),
                new SkillRequirement(Skill.THIEVING, spinThieving.getValue()),
                new SkillRequirement(Skill.WOODCUTTING, spinWoodcutting.getValue()));
    }

}
