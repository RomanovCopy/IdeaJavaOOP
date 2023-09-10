package com.romanovcopy.controllers;

import com.romanovcopy.models.interfaces.ModeInfo;

public enum Modes implements ModeInfo {

    SEARCH{
        @Override
        public void getInfo() {
            System.out.println("*** 1 SEARCH ");
        }
    },
    VIEW{
        @Override
        public void getInfo() {
            System.out.println("*** 2 VIEW ");
        }
    },
    ALL{
        @Override
        public void getInfo() {
            System.out.println("*** 3 ALL ");
        }
    },
    EDIT{
        @Override
        public void getInfo() {
            System.out.println("*** 4 EDIT ");
        }
    },
    NEW{
        @Override
        public void getInfo() {
            System.out.println("*** 5 NEW ");
        }
    },
    IMPORT{
        @Override
        public void getInfo() {
            System.out.println("*** 6 IMPORT ");
        }
    },
    EXPORT{
        @Override
        public void getInfo() {
            System.out.println("*** 7 EXPORT ");
        }
    },
    EXIT{
        @Override
        public void getInfo() {
            System.out.println("*** 8 EXIT ");
        }
    }
}
