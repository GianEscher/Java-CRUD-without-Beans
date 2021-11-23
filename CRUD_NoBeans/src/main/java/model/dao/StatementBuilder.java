package model.dao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class StatementBuilder {

    ArrayList exportBus = new ArrayList<Object>();

    public void receiver(Object g) {
        exportBus.add(g);
    }

    public Object sender(int index) {
        return exportBus.get(index);
    }

    public String stmtCreate(ArrayList exportBus) {

        //Vou precisar mais tarde ->
        //ArrayList<Object> exportBus = new ArrayList<Object>();
        String body = "INSERT INTO usuarios VALUES (?,";

        for (int i = 0; i < exportBus.size(); i++) {
            if (i != (exportBus.size()) - 1) {
                body = body + "?,";
            } else {
                body = body + "?)";
            }
        }
        System.out.println(body);

        return body;
    }

    public ArrayList stmtDelete() {

        Collections.sort(exportBus);
        ArrayList<Integer> deleteRange = new ArrayList<Integer>();
        deleteRange.add(0,Integer.valueOf(exportBus.get(0).toString()));
        deleteRange.add(1,Integer.valueOf(exportBus.get(exportBus.size()).toString()));
        
        return deleteRange;
    }

    public String stmtUpdate() {
        ArrayList<Object> exportBus = new ArrayList<Object>();
        String body = "INSERT INTO usuarios (";

        for (int i = 0; i < exportBus.size(); i++) {
            if (i != (exportBus.size()) - 1) {
                body = body + "?,";
            } else {
                body = body + "?)";
            }
        }
        System.out.println(body);

        return body;
    }

    public String stmtLoad() {
        ArrayList<Object> exportBus = new ArrayList<Object>();
        String body = "INSERT INTO usuarios (";

        for (int i = 0; i < exportBus.size(); i++) {
            if (i != (exportBus.size()) - 1) {
                body = body + "?,";
            } else {
                body = body + "?)";
            }
        }
        System.out.println(body);

        return body;
    }

}
