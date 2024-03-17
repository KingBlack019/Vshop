module com.example.vshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.example.vshop.Servidor to javafx.fxml;
    exports com.example.vshop.Servidor;
    exports com.example.vshop.Cliente;
    opens com.example.vshop.Cliente to javafx.fxml;
    exports com.example.vshop.Cliente.Intefaz;
    opens com.example.vshop.Cliente.Intefaz to javafx.fxml;
}