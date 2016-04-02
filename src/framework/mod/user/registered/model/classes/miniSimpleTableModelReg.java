/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.classes;

import framework.clss.DateO;
import framework.mod.user.registered.model.tools.LanguageReg;
import framework.mod.user.registered.model.tools.pager.paginaReg;
import framework.mod.user.registered.view.main_Reg;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author osotemi
 */
public class miniSimpleTableModelReg extends AbstractTableModel{
    public static ArrayList<RegisteredU> dataReg = new ArrayList<RegisteredU>();
    public static ArrayList<RegisteredU> datosauxReg = new ArrayList<RegisteredU>();
    String[] columns = {LanguageReg.getInstance().getProperty("col_name"), LanguageReg.getInstance().getProperty("col_lastName"), LanguageReg.getInstance().getProperty("col_hireDate"), LanguageReg.getInstance().getProperty("col_salary")};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columns[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return dataReg.size();
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
        RegisteredU fila = (RegisteredU) dataReg.get(row);

        switch (col) {
            case 0:
                dev = fila.getName();
                break;

            case 1:
                dev = fila.getLastname();
                break;

            case 2:
                dev = DateO.formDate(fila.getBorn_date().toString());
                break;

            case 3:
                dev = fila.getEmail();
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
        RegisteredU fila = (RegisteredU) dataReg.get(row);

        switch (col) {
            case 0:
                fila.setName(String.valueOf(value));
                break;

            case 1:
                fila.setLastname(String.valueOf(value));
                break;

            case 2:
                fila.setBorn_date(new DateO(value.toString()));
                break;
            
            case 3:
                fila.setEmail(String.valueOf(value));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(RegisteredU adm) {
        dataReg.add(adm);
        fireTableDataChanged();
    }

    public void cargar() {
        dataReg.clear();
        datosauxReg.clear();
        
        RegisteredU _regu = null;
        java.util.Date date= new java.util.Date();
        for(int i=0; i<singletonReg.RegTableArray.size(); i++) {
            _regu = singletonReg.RegTableArray.get(i);
            addRow(_regu);
            datosauxReg.add(_regu);
            
            try {
                //Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    }

    public void filtrar() {
        dataReg.clear();
        int cont=0;
        
        String nom=(String) ((JComboBox)main_Reg.comboReg).getSelectedItem();
        //nom.charAt(0) = nom.charAt(0);
        if(nom!=null){
            for(int i=0;i<datosauxReg.size();i++) {
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if(datosauxReg.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())){
                    addRow(datosauxReg.get(i));
                    cont++;
                }
            }
            main_Reg.lbl_entries.setText(String.valueOf(cont));
            paginaReg.initLinkBox();
        }
    }

    public RegisteredU buscar(String regu) {
        dataReg.clear();
        cargar();

        String res;
        for (int i = 0; i < dataReg.size(); i++) {
            res = dataReg.get(i).toString();
            if (res.contains(regu)) {
                return dataReg.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(RegisteredU regu) {
        dataReg.clear();
        cargar();

        for (int i = 0; i < dataReg.size(); i++) {
            if (dataReg.get(i).equals(regu)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        dataReg.remove(fila);
        fireTableDataChanged();
    }
}
