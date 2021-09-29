package scripts.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.tribot.script.sdk.Waiting;
import scripts.api.Loggable;
import scripts.api.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Laniax
 */
public class GUI extends Application {
    private Logger guiLogger = new Logger();
    private final URL fxml;
    private final URL stylesheet;
    private Stage stage;
    private Scene scene;
    private scripts.gui.AbstractGUIController controller;
    private boolean decorated = true;

    private boolean isOpen = false;

    public GUI(URL fxml) {
        this(fxml, null);
    }


    public GUI(URL fxml, boolean decorated) {
        this(fxml, null, decorated);
    }

    public GUI(URL fxml, URL stylesheet) {
        this(fxml, stylesheet, true);
    }



    public GUI(URL fxml, URL stylesheet, boolean decorated) {

        this.fxml = fxml;
        this.stylesheet = stylesheet;
        this.decorated = decorated;

        // We have to start the JFX thread from the EDT otherwise tribot will end it.
        SwingUtilities.invokeLater(() -> {

            new JFXPanel(); // we have to init the toolkit

            Platform.runLater(() -> {
                try {
                    final Stage stage = new Stage();

                    if (!this.decorated) {
                        stage.initStyle(StageStyle.TRANSPARENT);
                    }

                    start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        waitForInit();
    }

    public Scene getScene() {
        return this.scene;
    }

    public Stage getStage() {
        return this.stage;
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set. The primary stage will be embedded in
     *              the browser if the application was launched as an applet.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage stage) throws Exception {
        guiLogger.setHeader("GUI");
        if (fxml == null) {
            guiLogger.setLoggable(Loggable.ERROR).setMessage("fxml is null. aborting").print();
            return;
        }

        this.stage = stage;

        Platform.setImplicitExit(false);

        FXMLLoader loader = new FXMLLoader(fxml);

        // By default FXMLLoader uses a different classloader, this caused issues with upcasting
        loader.setClassLoader(this.getClass().getClassLoader());

        Parent box = loader.load();

        controller = loader.getController();

        if (controller == null) {
            guiLogger.setLoggable(Loggable.ERROR).setMessage("Please add a controller to your fxml!").print();
            return;
        }
        controller.setGUI(this);

        scene = new Scene(box);

        if (!this.decorated) {
            scene.setFill(Color.TRANSPARENT);
        }

        if (this.stylesheet != null)
            scene.getStylesheets().add(this.stylesheet.toExternalForm());

        stage.setScene(scene);
        stage.setTitle("SkrrtMonitor");
    }

    public <T extends AbstractGUIController> T getController() {

        return (T) this.controller;

    }

    public void show() {

        if (stage == null)
            return;

        isOpen = true;

        Platform.runLater(() -> stage.show());
    }

    public void close() {

        if (stage == null)
            return;

        isOpen = false;

        Platform.runLater(() -> stage.close());
    }

    public boolean isOpen() {
        return isOpen;
    }

    private void waitForInit() {
        Waiting.waitUntil(5000, () -> stage != null);
    }

    public void openBrowser(String url) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URI(url));
    }

}
