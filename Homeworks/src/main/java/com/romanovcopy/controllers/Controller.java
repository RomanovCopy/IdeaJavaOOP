package com.romanovcopy.controllers;

import com.romanovcopy.models.base.Person;
import com.romanovcopy.views.ViewToConsole;

public class Controller {

    private ViewToConsole<Person>view;
    private Data<Person>data;

    public Controller() {
        data=new Data<>();
        view=new ViewToConsole<>();
        var mode=view.selectMode();
        while (mode!=Modes.EXIT){
            selectMode(mode);
            mode=view.selectMode();
        }
    }

    public void selectMode(Modes mode){

        if(mode!=null){
            if(mode==Modes.ALL){
                executeAll();
            } else if (mode==Modes.EDIT) {
                executeEdit();
            } else if (mode==Modes.NEW) {
                executeNew();
            } else if (mode==Modes.SEARCH) {
                executeSearch();
            } else if (mode==Modes.VIEW) {
                executeView();
            } else if (mode==Modes.IMPORT) {
                executeImport();
            } else if (mode==Modes.EXPORT) {
                executeExport();
            } else if (mode==Modes.EXIT) {

            }
        }
    }

    private void executeAll(){

    }

    private void executeEdit(){

    }

    private void executeNew(){

    }

    private void executeSearch(){

    }

    private void executeView(){

    }

    private void executeImport(){

    }

    private void executeExport(){

    }

    private void executeExit(){

    }



}
