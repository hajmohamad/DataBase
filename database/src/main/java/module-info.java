module view.database {
    requires javafx.controls;
    requires javafx.fxml;


    opens view.database to javafx.fxml;
    exports view.database;
}