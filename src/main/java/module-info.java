module org.example.my_ind {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.example.my_ind to javafx.fxml;
    exports org.example.my_ind;
}