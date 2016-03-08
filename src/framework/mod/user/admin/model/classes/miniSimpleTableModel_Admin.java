/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.classes;

import framework.mod.user.admin.model.tools.pager.pagina;
import framework.clss.DateO;
import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author osotemi
 */
public class miniSimpleTableModel_Admin extends AbstractTableModel{
    public static ArrayList<Admin> data = new ArrayList<Admin>();
    public static ArrayList<Admin> datosaux = new ArrayList<Admin>();
    String[] columns = {"Nombre", "Apellidos", "Contratacion", "Actividad"};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columns[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return data.size();
    }

    //Devuelve el numero de columns
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        Admin fila = (Admin) data.get(row);

        switch (col) {
            case 0:
                dev = fila.getName();
                break;

            case 1:
                dev = fila.getLastname();
                break;

            case 2:
                dev = fila.getContract_data().toString();
                break;

            case 3:
                dev = fila.getActivity();
                break;

        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        Admin fila = (Admin) data.get(row);

        switch (col) {
            case 0:
                fila.setName(String.valueOf(value));
                break;

            case 1:
                fila.setLastname(String.valueOf(value));
                break;

            case 2:
                fila.setContract_data(new DateO(value.toString()));
                break;
            
            case 3:
                fila.setActivity(Integer.parseInt(value.toString()));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Admin usu) {
        data.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        data.clear();
        datosaux.clear();
        
        Admin _adm = null;
        java.util.Date date= new java.util.Date();
        for(int i=1;i<=singletonAdmin.AdminTableArray.size();i++) {
            _adm = singletonAdmin.AdminTableArray.get(i);
            addRow(_adm);
            datosaux.add(_adm);
            
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    }

    /*public void filtrar() {
        data.clear();
        int cont=0;
        
        String nom=(String) ((JComboBox)combo).getSelectedItem();   
        if(nom!=null){
            for(int i=0;i<datosaux.size();i++) {
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if(datosaux.get(i).getFirst_name().toLowerCase().startsWith(nom.toLowerCase())){
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            interfaz_actor.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + nom);
            pagina.initLinkBox();
        }
    }

    public actor buscar(String u) {
        data.clear();
        cargar();

        String res;
        for (int i = 0; i < data.size(); i++) {
            res = data.get(i).toString();
            if (res.contains(u)) {
                return data.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(actor u) {
        data.clear();
        cargar();

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        data.remove(fila);
        fireTableDataChanged();
    }*/
}
