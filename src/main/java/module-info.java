module org.ctrlengine.ctrlengine_rpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.slf4j;
    requires java.desktop;
    requires javafx.media;

    opens org.ctrlengine.ctrlengine_rpg to javafx.fxml;
    exports org.ctrlengine.ctrlengine_rpg;
}