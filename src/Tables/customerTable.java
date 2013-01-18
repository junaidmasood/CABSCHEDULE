package Tables;
import java.util.*;
import cab_schedule.customer;
import javax.swing.table.AbstractTableModel;
//a new edit
public class customerTable extends AbstractTableModel
{
    private List<customer> list = new ArrayList<customer>();

    public customerTable() 
    {}

    public customer get(int row)
    {
        return list.get(row);
    }

    public void insert(customer t) 
    {
        list.add(t);
        fireTableDataChanged();
    }

    public void update(int row, customer t) {
        list.set(row, t);
        fireTableDataChanged();
    }

    public void delete(int row) 
    {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<customer> l) 
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
                return "pan_number";
	    case 1:
		return "password";
	    case 2:
		return "name";
	    case 3:
		return "mob";
	    case 4:
		return "address";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).pan_number;
            case 1:
                return list.get(rowIndex).password;
            case 2:
                return list.get(rowIndex).name;
            case 3:
                return list.get(rowIndex).mob;
            case 4:
                return list.get(rowIndex).address;
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
        return 5;
    }
}
