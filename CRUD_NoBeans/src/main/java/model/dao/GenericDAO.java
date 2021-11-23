package model.dao;

import controller.ConnectionFactory;
import model.dao.StatementBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GenericDAO {

    StatementBuilder builder = new StatementBuilder();

    public void create(ArrayList exportBus) {
        Connection con = ConnectionFactory.getConnection();
        System.out.println(con);
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(builder.stmtCreate(exportBus));

            for (int i = 0; i<exportBus.size(); i++) {
                stmt.setObject(i+1, exportBus.get(i));
                System.out.println(exportBus.get(i));
            }
            System.out.println(stmt);
            stmt.setObject(6, 12);
            stmt.executeUpdate();
            //executa a minha sql

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete() {
        
    }

    public void update() {

    }

    public void load() {

    }
}
