module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires okhttp;
    requires json.simple;

    opens com.example.demo1 to javafx.fxml;
    opens com.licenta.dao to javafx.base;

    exports com.example.demo1;
}