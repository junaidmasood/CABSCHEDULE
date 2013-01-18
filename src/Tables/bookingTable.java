package Tables;

import java.util.*;
import cab_schedule.booking;
import javax.swing.table.AbstractTableModel;

public class bookingTable extends AbstractTableModel
{
    private List<booking> list = new ArrayList<booking>();

    public bookingTable() 
    {}

    public booking get(int row)
    {
        return list.get(row);
    }

    public void insert(booking t) 
    {
        list.add(t);
        fireTableDataChanged();
    }

    public void update(int row, booking t) {
        list.set(row, t);
        fireTableDataChanged();
    }

    public void delete(int row) 
    {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<booking> l) 
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
                return "id";
	    case 1:
		return "pan_number";
	    case 2:
		return "taxi_reg";
	    case 3:
		return "x1";
	    case 4:
		return "y1";
	    case 5:
		return "x2";
	    case 6:
		return "y2";
	    case 7:
		return "start";
	    case 8:
		return "end";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).id;
            case 1:
                return list.get(rowIndex).pan_number;
            case 2:
                return list.get(rowIndex).taxi_reg;
            case 3:
                return list.get(rowIndex).x1;
            case 4:
                return list.get(rowIndex).y1;
	    case 5:
                return list.get(rowIndex).x2;
            case 6:
                return list.get(rowIndex).y2;
	    case 7:
		return list.get(rowIndex).start;
	    case 8:
		return list.get(rowIndex).end;
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
        return 9;
    }
}
