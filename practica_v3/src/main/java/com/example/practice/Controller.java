package com.example.practice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import java.io.File;


public class Controller {
    @FXML
    public TextField folderLocation;
    @FXML
    public TextField timeField;
    @FXML
    public ListView<String> listViyw;

    @FXML
    Location a = new Location();
    CheckFiles b = new CheckFiles();
    public void setItems(ActionEvent event) {
        ObservableList<File> ol =a.getLoc(folderLocation.getText());
        listViyw.setItems(FXCollections.observableArrayList(b.check(ol, timeField.getText())));
        }

    public void showSize(ActionEvent event){
        Location l = new Location();
        ObservableList<File> ol =l.getLoc(folderLocation.getText());

        if (ol == null || ol.size() == 0) {

        }else{
            long sum = 0;
            for (int i = 0; i< ol.size();i++) {
                File file = new File(ol.get(i).getName());
                long len =file.length();

                sum+=len;

                System.out.println(file.getName()+" Len "+len);
            }
            System.out.println(sum);
            filesSizeField.setText(sum+" Byte");
        }
    }

    public Label filesAmountField;
    @FXML
    public Label filesSizeField;
    @FXML
    public void showAmount(ActionEvent event) {
        Location a = new Location();
        ObservableList<File> l =a.getLoc(folderLocation.getText());
        int count=0;
        if (l != null || l.size() != 0) {
            for (File s : l) {
                count++;
            }
        }
        filesAmountField.setText(String.valueOf(count));
    }
            public void deleteFromList(ActionEvent event) {
                Location l = new Location();
                final int selectedIdx = listViyw.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                    String itemToRemove = listViyw.getSelectionModel().getSelectedItem();

                    final int newSelectedIdx =
                            (selectedIdx == listViyw.getItems().size() - 1)
                                    ? selectedIdx - 1
                                    : selectedIdx;
                    l.getFele(selectedIdx, folderLocation.getText()).delete();
                    listViyw.getItems().remove(selectedIdx);
                    listViyw.getSelectionModel().select(newSelectedIdx);
                    System.out.println("selectIdx: " + selectedIdx);
                    System.out.println("item: " + itemToRemove);
        }
    }
    public void setItemsEnter(KeyEvent e)
    {
        if(e.getCode().toString().equals("ENTER"))
        {
            ObservableList<File> ol =a.getLoc(folderLocation.getText());
            listViyw.setItems(FXCollections.observableArrayList(b.check(ol, timeField.getText())));
        }
        }
}