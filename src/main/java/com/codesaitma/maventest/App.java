package com.codesaitma.maventest;

import com.codesaitma.maventest.functions.Marker;
import com.codesaitma.maventest.trainer.*;
import com.codesaitma.maventest.ciphers.*;

import java.util.Scanner;

public class App implements Marker {
    public static void main( String[] args ){
        try{ new Machine().callTensor();}catch(Exception ex){}

        int x = 1;
        System.out.println();
    }

    public int getAge(int age){
        return age + 10;
    }

}
