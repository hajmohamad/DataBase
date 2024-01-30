package view.database;

import Controller.dataBaseController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static view.database.mainFxml.reloadScreen;

public class mainFxmlController  implements Initializable {
    static dataBaseController dBController;

    @FXML
    private HBox hbox_capital;

    @FXML
    private ImageView imageView_addTable;

    @FXML
    private Label lbl_tableName;

    @FXML
    private TextField txtf_newCapital;

    @FXML
    private TextField txtf_newName;

    @FXML
    private TextField txtf_sortBase;

    @FXML
    private VBox vbox_tableData;

    @FXML
    private VBox vbox_tables;

    @FXML
    private AnchorPane ap_addTable;


    @FXML
    void addNewTable(MouseEvent event) {
        dBController.addTable(txtf_newName.getText(),txtf_newCapital.getText(),txtf_sortBase.getText());
        reloadScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dBController=dataBaseController.getDBController();
        imageView_addTable.setOnMouseClicked(e->{
            ap_addTable.setVisible(!ap_addTable.isVisible());
        });
        if(dBController.tableExists()){
            lbl_tableName.setText(dBController.getTableName());
        }
        for(String tableName:dBController.getTables()){
            Label lbl=new Label();
            lbl.setStyle("-fx-background-color: #8b8bd1;-fx-background-radius: 15px; -fx-font-size: 14px;  -fx-margin: 3px 0px 0px 4px;");
            lbl.setText(tableName);
            lbl.setOnMouseClicked(e->{
                dBController.choseTable(tableName);
                reloadScreen();
            });
            vbox_tables.getChildren().add(lbl);
        }
        if(dBController.tableExists()){
            //write capital in table
            {
            Label deleteEditCapital=new Label("edit / remove");
            deleteEditCapital.setStyle("-fx-background-color: #8b8bd1;-fx-background-radius: 15px;  -fx-font-size: 20px;");
                HBox.setMargin(deleteEditCapital,new javafx.geometry.Insets(20,10,10,10));
                hbox_capital.getChildren().add(deleteEditCapital);
            for(String capital:dBController.getCapital()){
                Label lbl=new Label();
                lbl.setText(capital);
                lbl.setStyle("-fx-background-color: #8b8bd1;-fx-background-radius: 15px; -fx-font-size: 20px;  ");
                lbl.setOnMouseClicked(e->{
                    dBController.changeBase(capital);
                    reloadScreen();
                });
                HBox.setMargin(lbl,new javafx.geometry.Insets(20,10,10,10));
                hbox_capital.getChildren().add(lbl);
            }}
            //write data in table
            int i=0;
            for(String key:dBController.getAllKey()){
                HBox dataValues=new HBox();
                ImageView edit=new ImageView(new Image("I:\\ramezon\\data structures\\btree-hajmohamad\\database\\src\\main\\resources\\view\\database\\edit.png"));
                ImageView delete = new ImageView(new Image("I:\\ramezon\\data\\structures\\btree-hajmohamad\\database\\src\\main\\resources\\view\\database\\rec.png"));
                edit.setStyle(" -fx-max-height:4px; -fx-max-width:4px; -fx-margin: 3px 0 0 4px;");
                delete.setStyle(" -fx-max-height:4px; -fx-max-width:4px; -fx-margin: 3px 0 0 4px;");
                dataValues.getChildren().add(edit);
                dataValues.getChildren().add(delete);
                //do it like zebra
                {
                if(i%2==0) {
                    i++;
                    dataValues.setStyle("-fx-background-color: #d9d9ec;-fx-background-radius: 15px; -fx-font-size: 14px;  -fx-margin: 3px 0 0 4px;");
                }else {
                    i++;
                    dataValues.setStyle("-fx-background-color: #7a7a97;-fx-background-radius: 15px; -fx-font-size: 14px;  -fx-margin: 3px 0 0 4px;");
                }
                }
                ArrayList<TextField> textFields = new ArrayList<>();
                for(String value:dBController.searchRow(key)){
                    TextField valueField = new TextField(value);
                    textFields.add(valueField);
                    valueField.setStyle(" -fx-font-size: 14px;  -fx-margin: 5px 0 0 4px;");
                    dataValues.getChildren().add(valueField);
                }
                edit.setOnMouseClicked(e->{
                    String[] newData=new String[textFields.size()];
                    for(int j=0;j<textFields.size();j++){
                        newData[j]=textFields.get(j).getText();
                    }
                    dBController.editRow(key,newData);
                    reloadScreen();

                });
                delete.setOnMouseClicked(e->{
                    dBController.deleteRow(key);
                    reloadScreen();

                });
                vbox_tableData.getChildren().add(dataValues);
            }








        }



    }
}
