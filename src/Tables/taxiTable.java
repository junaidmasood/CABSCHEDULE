package Tables;

import java.util.*;
import cab_schedule.taxi;
import javax.swing.table.AbstractTableModel;

public class taxiTable extends AbstractTableModel
{
    private List<taxi> list = new ArrayList<taxi>();

    public taxiTable() 
    {}

    public taxi get(int row)
    {
        return list.get(row);
    }

    public void insert(taxi t) 
    {
        list.add(t);
        fireTableDataChanged();
    }

    public void update(int row, taxi t) {
        list.set(row, t);
        fireTableDataChanged();
    }

    public void delete(int row) 
    {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<taxi> l) 
    {
        list = l;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) 
    {
        switch (column) 
	{
            case 0:
                return "reg_no";
            case 1:
                return "status";
            case 2:
                return "driver";
            case 3:
                return "capacity";
            case 4:
                return "type";
            case 5:
                return "reading";
            case 6:
                return "wheeler";
            case 7:
                return "maintenance";
            case 8:
                return "x";
	    case 9:
                return "y";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).reg_no;
            case 1:
                return list.get(rowIndex).status;
            case 2:
                return list.get(rowIndex).driver;
            case 3:
                return list.get(rowIndex).capacity;
            case 4:
                return list.get(rowIndex).type;
            case 5:
                return list.get(rowIndex).reading;
            case 6:
                return list.get(rowIndex).wheeler;
            case 7:
                return list.get(rowIndex).maintenance;
            case 8:
                return list.get(rowIndex).x;
	    case 9:
		return list.get(rowIndex).y;
            default:
                return null;
        }
    }
    
    @Override
    public int getRowCount() 
    {
        return list.size();
    }

    @Override
    public int getColumnCount() 
    {
        return 10;
    }
}
