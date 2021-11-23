/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.bean.User;
import model.dao.GenericDAO;

/**
 *
 * @author MARTA
 */
public class Controller {

    public static void main(String args[]) {
        ArrayList<Object> exportBus = new ArrayList<Object>();

        exportBus.add("carlos");
        exportBus.add("carlos22");
        exportBus.add("123");
        exportBus.add("carlosss");
        exportBus.add("123-456");
        
        GenericDAO dao = new GenericDAO();
        dao.create(exportBus);

    }
}
