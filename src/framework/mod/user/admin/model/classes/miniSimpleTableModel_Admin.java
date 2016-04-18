/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.classes;

import framework.mod.user.admin.model.tools.pager.pagina;
import framework.clss.DateO;
import framework.mod.user.admin.model.BLL.BLL_DB_Admin;
import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.admin.model.tools.LanguageAdm;
import framework.mod.user.admin.view.main_Admin;
import framework.tools.format;
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
    String[] columns = {LanguageAdm.getInstance().getProperty("col_name"), LanguageAdm.getInstance().getProperty("col_lastName"), LanguageAdm.getInstance().getProperty("col_hireDate"), LanguageAdm.getInstance().getProperty("col_salary")};

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
                dev = DateO.formDate(fila.getContract_data().toString());
                break;

            case 3:
                dev = fila.getSalary();
                dev = format.formMoneyOut((float)dev);
                break;
            
            case 4:
                dev = fila.getDni();
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
                fila.setSalary(Integer.parseInt(value.toString()));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Admin adm) {
        data.add(adm);
        fireTableDataChanged();
    }

    public void cargar() {
        data.clear();
        datosaux.clear();
        BLL_DB_Admin.BLL_DB_listAdmin();
        
        Admin _adm = null;
        for(int i=0; i<singletonAdmin.AdminTableArray.size(); i++) {
            _adm = singletonAdmin.AdminTableArray.get(i);
            addRow(_adm);
            datosaux.add(_adm);
            
            try {
                //Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    }

    public void filtrar() {
        data.clear();
        int cont=0;
        
        String nom=(String) ((JComboBox)main_Admin.combo).getSelectedItem();
        //nom.charAt(0) = nom.charAt(0);
        if(nom!=null){
            for(int i=0;i<datosaux.size();i++) {
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if(datosaux.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())){
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            main_Admin.lbl_entries.setText(String.valueOf(cont));
            pagina.initLinkBox();
        }
    }

    public Admin buscar(String adm) {
        data.clear();
        cargar();

        String res;
        for (int i = 0; i < data.size(); i++) {
            res = data.get(i).toString();
            if (res.contains(adm)) {
                return data.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Admin adm) {
        data.clear();
        cargar();

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(adm)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        data.remove(fila);
        fireTableDataChanged();
    }
}
