package com.romanovcopy.views;

import com.romanovcopy.controllers.Modes;
import com.romanovcopy.models.base.Person;

import java.util.List;

public class ViewToConsole<T extends Person> {

    public ViewToConsole(){

    }

    public Modes selectMode(){
        return null;
    }

    public void printContact(T contact){

    }

    public void printListContacts(List<T> contacts){

    }

    public void printModes(){
        int count = 1;
        for(var mode:Modes.values()){
            System.out.printf("*** %d %s ",count,mode);
        }
    }


}
