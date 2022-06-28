package com.example.practice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.io.File;


public class Location {

    @FXML
    public ObservableList<File> getLoc(String folderLocation){
    File ada = new File(folderLocation);
    File[] listt = ada.listFiles();
    ObservableList<File> c = FXCollections.observableArrayList(listt);
        if (listt == null || listt.length == 0) {
        System.out.println("Папка пуста");
    }
        return c;
    }
    @FXML
    public File getFele(Integer indx,String folderLocation){
        File fele = new File(getLoc(folderLocation).get(indx).getName());
        return fele;
    }
}
