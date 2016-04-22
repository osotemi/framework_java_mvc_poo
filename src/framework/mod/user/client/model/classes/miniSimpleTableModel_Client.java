/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.classes;

import framework.clss.DateO;
import framework.mod.user.client.model.BLL.BLL_DB_Client;
import framework.mod.user.client.model.tools.LanguageClt;
import framework.mod.user.client.model.tools.pager.paginaClt;
import framework.mod.user.client.view.main_Client;
import framework.tools.format;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author osotemi
 */
public class miniSimpleTableModel_Client  extends AbstractTableModel{
    public static ArrayList<Client> dataClt = new ArrayList<Client>();
    public static ArrayList<Client> datosauxClt = new ArrayList<Client>();
    String[] columns = {LanguageClt.getInstance().getProperty("col_name"), LanguageClt.getInstance().getProperty("col_lastName"), LanguageClt.getInstance().getProperty("DRW_lblBornDate"), LanguageClt.getInstance().getProperty("DRW_lblShopAccount")};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columns[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return dataClt.size();
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
        Client fila = (Client) dataClt.get(row);

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
                dev = fila.getShop_acount();
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
        Client fila = (Client) dataClt.get(row);

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
                fila.setShop_acount(Integer.parseInt(value.toString()));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Client adm) {
        dataClt.add(adm);
        fireTableDataChanged();
    }

    public void cargar() {
        dataClt.clear();
        datosauxClt.clear();
        BLL_DB_Client.BLL_DB_listClient();
        
        if(singletonClient.ClienTableArray != null){
            for(Client clt : singletonClient.ClienTableArray) {
                addRow(clt);
                datosauxClt.add(singletonClient.ephemeralClient);
            }
        }
        
    }

    public void filtrar() {
        dataClt.clear();
        int cont=0;
        
        String nom=(String) ((JComboBox)main_Client.comboClt).getSelectedItem();
        //nom.charAt(0) = nom.charAt(0);
        if(nom!=null){
            for(int i=0;i<datosauxClt.size();i++) {
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if(datosauxClt.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())){
                    addRow(datosauxClt.get(i));
                    cont++;
                }
            }
            main_Client.lbl_entries.setText(String.valueOf(cont));
            paginaClt.initLinkBox();
        }
    }

    public Client buscar(String adm) {
        dataClt.clear();
        cargar();

        String res;
        for (int i = 0; i < dataClt.size(); i++) {
            res = dataClt.get(i).toString();
            if (res.contains(adm)) {
                return dataClt.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Client adm) {
        dataClt.clear();
        cargar();

        for (int i = 0; i < dataClt.size(); i++) {
            if (dataClt.get(i).equals(adm)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        dataClt.remove(fila);
        fireTableDataChanged();
    }
}
