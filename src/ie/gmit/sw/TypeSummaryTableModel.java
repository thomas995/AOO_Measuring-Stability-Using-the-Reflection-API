package ie.gmit.sw;

import javax.swing.table.*;
/**
 * @author Thomas
 *
 */
public class TypeSummaryTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 777L;
	private String[] cols = {"Class", "Afferent", "Efferent", "Stability"};

	// Sample table layout
	private Object[][] data =
		{
		{"Stuff 1", "Other Stuff 1", "Even More Stuff 1"},
		{"Stuff 2", "Other Stuff 2", "Even More Stuff 2"},
		{"Stuff 3", "Other Stuff 3", "Even More Stuff 3"},
		{"Stuff 4", "Other Stuff 4", "Even More Stuff 4"},
		{"Stuff 5", "Other Stuff 5", "Even More Stuff 5"},
		{"Stuff 6", "Other Stuff 6", "Even More Stuff 6"},
		{"Stuff 7", "Other Stuff 7", "Even More Stuff 7"}
	};
    //
	// getters and setters used for the table values
	//
	/**
	 * @param data
	 */
	public void setTableData(Object[][] data)
	{

	    this.data = data;
    }

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount()
	{
        return cols.length;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getRowCount()
     */
    public int getRowCount()
    {
        return data.length;
	}


    /* (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    public String getColumnName(int col)
    {
    	return cols[col];
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    public Object getValueAt(int row, int col)
    {
        return data[row][col];
	}

    /* (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
     */
    public Class<?> getColumnClass(int c)
    {
        return getValueAt(0, c).getClass();
	}
}