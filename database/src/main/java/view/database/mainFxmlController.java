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
    void addCapital(){
        {
            Label deleteEditCapital=new Label(" edit / remove ");
            deleteEditCapital.setStyle("-fx-background-color: #8b8bd1;-fx-background-radius: 15px;  -fx-font-size: 20px;");
            HBox.setMargin(deleteEditCapital,new javafx.geometry.Insets(20,10,10,10));
            hbox_capital.getChildren().add(deleteEditCapital);
            for(String capital:dBController.getCapital()){
                Label lbl=new Label();
                lbl.setText(" "+capital+" ");
                if(dBController.keyBase().equals(capital)){
                    lbl.setStyle("-fx-background-color: #d724ab;-fx-background-radius: 15px; -fx-font-size: 20px;  ");
                }else{
                    lbl.setStyle("-fx-background-color: #8b8bd1;-fx-background-radius: 15px; -fx-font-size: 20px;  ");

                }
                lbl.setOnMouseClicked(e->{
                    dBController.changeBase(capital);
                    reloadScreen();
                });
                HBox.setMargin(lbl,new javafx.geometry.Insets(20,10,10,10));
                hbox_capital.getChildren().add(lbl);
            }}
    }
    void addTable(){
        for(String tableName:dBController.getTables()){
            Label lbl=new Label();
            lbl.setStyle("-fx-background-color: #8b8bd1;-fx-background-radius: 15px; -fx-font-size: 20px; ");
            VBox.setMargin(lbl,new javafx.geometry.Insets(20,10,10,19));
            lbl.setText(tableName);
            lbl.setOnMouseClicked(e->{
                dBController.choseTable(tableName);
                reloadScreen();
            });
            vbox_tables.getChildren().add(lbl);
        }
    }
    void addDataInTable(){
        int i = 0;

        for(String key:dBController.getAllKey()){
            HBox dataValues=new HBox();
            ImageView edit=new ImageView(new Image("I:\\ramezon\\data structures\\btree-hajmohamad\\database\\src\\main\\resources\\view\\database\\edit.png"));
            edit.setFitHeight(20);
            edit.setFitWidth(20);
            HBox.setMargin(edit,new javafx.geometry.Insets(15,5,5,5));

            ImageView delete = new ImageView(new Image("I:\\ramezon\\data structures\\btree-hajmohamad\\database\\src\\main\\resources\\view\\database\\rec.png"));
            delete.setFitHeight(20);
            delete.setFitWidth(20);
            HBox.setMargin(delete,new javafx.geometry.Insets(15,5,5,5));
            edit.setStyle(" -fx-max-height:4px; -fx-max-width:4px; -fx-margin: 3px 0 0 4px;");
            delete.setStyle(" -fx-max-height:4px; -fx-max-width:4px; -fx-margin: 3px 0 0 4px;");
            dataValues.getChildren().add(edit);
            dataValues.getChildren().add(delete);
            //do it like zebra

                if(i%2==0) {
                    i++;
                    dataValues.setStyle("-fx-background-color: #d9d9ec;-fx-background-radius: 15px; -fx-font-size: 14px;  -fx-margin: 3px 0 0 4px;");
                }else {
                    i++;
                    dataValues.setStyle("-fx-background-color: #7a7a97;-fx-background-radius: 15px; -fx-font-size: 14px;  -fx-margin: 3px 0 0 4px;");
                }

            ArrayList<TextField> textFields = new ArrayList<>();
            for(String value:dBController.searchRow(key)){
                TextField valueField = new TextField(value);
                textFields.add(valueField);
                valueField.setStyle(" -fx-font-size: 14px;  -fx-margin: 5px 0 0 4px;");
                dataValues.getChildren().add(valueField);
                HBox.setMargin(valueField,new javafx.geometry.Insets(15,5,5,5));

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
            System.out.println(textFields.get(0).getPrefWidth());
            dataValues.prefWidth(textFields.get(0).getPrefWidth()*textFields.size());
            vbox_tableData.getChildren().add(dataValues);
        }

    }
    void addNewRow(){
        HBox newRow = new HBox();
        Image addI=new Image("I:\\ramezon\\data structures\\btree-hajmohamad\\database\\src\\main\\resources\\view\\database\\add.png");
        ImageView add=new ImageView(addI);
        add.setFitHeight(25);
        add.setFitWidth(25);
        HBox.setMargin(add,new javafx.geometry.Insets(20,10,10,10));
        newRow.getChildren().add(add);
        ArrayList<TextField> textFields = new ArrayList<TextField>();
        for(String key :dBController.getCapital()){
            TextField valueField = new TextField();
            textFields.add(valueField);
            valueField.minHeight(key.length()*10);
            valueField.setStyle(" -fx-font-size: 14px;  -fx-margin: 5px 0 0 4px;");
            HBox.setMargin(valueField,new javafx.geometry.Insets(20,10,10,10));
            newRow.getChildren().add(valueField);
        }
        textFields.get(textFields.size()-1).setOnAction(e->{
            String newData="";
            for(int j=0;j<textFields.size();j++){
                newData+=textFields.get(j).getText()+" ";
            }
            dBController.addRow(newData);
            reloadScreen();
        });

        add.setOnMouseClicked(e->{
            String newData="";
            for(int j=0;j<textFields.size();j++){
                newData+=textFields.get(j).getText()+" ";
            }
            dBController.addRow(newData);
            reloadScreen();
        });


        vbox_tableData.getChildren().add(newRow);
        newRow.setStyle("-fx-background-color: #5b5b7f ;-fx-background-radius: 15px;");
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
        //addTable
        addTable();
        if(dBController.tableExists()){
            //write capital in table
           addCapital();
            //write data in table
            addDataInTable();
            addNewRow();



        }



    }
}
