module hi.verkefni.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens hi.verkefni.vidmot to javafx.fxml, javafx.media;
    opens hi.verkefni.vinnsla to org.junit.jupiter.api;

    exports hi.verkefni.vidmot;
}