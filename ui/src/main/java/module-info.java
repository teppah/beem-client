module ui {
    requires javafx.fxml;
    requires javafx.controls;

    exports com.yfy.beem.client;
    exports com.yfy.beem.client.controller;

    opens com.yfy.beem.client.controller;
    opens com.yfy.beem.client;
}