module view.databaseusingbtree {
    requires javafx.controls;
    requires javafx.fxml;


    opens view.databaseusingbtree to javafx.fxml;
    exports view.databaseusingbtree;
}