package org.example.my_ind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.util.Duration; // <--- імпорт Duration

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Slider volume;
    @FXML
    private Button resetButton; // кнопка Reset
    @FXML
    private Button pauseButton;
    @FXML
    private Button playButton;
    @FXML
    private Label welcomeText;
    @FXML
    private MediaView mediaView;

    private Media media;
    private MediaPlayer mediaPlayer;
    private File file;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void openSchedule(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneSwitcher.switchScene(stage, "win_2.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Вказати шлях до вашого відео
        file = new File("src/main/resources/org/example/MY_ind/video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaView.setMediaPlayer(mediaPlayer);

        // ---------- Регулювання гучності ----------
        volume.setValue(50); // Початкове значення гучності 50%
        mediaPlayer.setVolume(volume.getValue() * 0.01);
        volume.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(newVal.doubleValue() * 0.01);
            }
        });
    }

    @FXML
    private void playButton_method(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    @FXML
    private void pauseButton_method(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    // ----------- Додаємо Reset -----------
    @FXML
    private void resetButton_method(ActionEvent event) {
        if (mediaPlayer != null && mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0)); // повертаємо на початок
            mediaPlayer.play(); // відтворюємо
        }
    }
}
