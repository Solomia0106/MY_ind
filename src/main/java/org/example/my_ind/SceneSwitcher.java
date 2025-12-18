package org.example.my_ind;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneSwitcher {

    public static void switchScene(Stage stage, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(fxml));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}
