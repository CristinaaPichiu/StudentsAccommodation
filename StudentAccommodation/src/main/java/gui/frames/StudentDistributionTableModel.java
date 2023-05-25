package gui.frames;


import database.entity.StudentiEntity;
import database.repository.StudentRepository;

import javax.swing.table.AbstractTableModel;
import java.util.*;

class StudentDistributionTableModel extends AbstractTableModel {
    private final List<String> columnNames = Arrays.asList("SERIAL NUMBER", "GPA", "ASSIGNED DORMITORY");

    private List<List<Object>> data;

    public StudentDistributionTableModel(int flag) {
        data = new ArrayList<>();
        StudentRepository studRepo = new StudentRepository();
        List<StudentiEntity> studs=new ArrayList<>();

        if (flag == 1) {
            studs = studRepo.ShowStudentsDormitory1();
        } else if (flag == 2) {
            studs = studRepo.ShowStudentsDormitory2();
        } else if (flag == 3) {
            studs = studRepo.ShowStudentsDormitory3();
        } else if (flag == 4) {
            studs = studRepo.ShowStudentsDormitory4();
        } /*else {
            studs = studRepo.ShowStudentsDormitory5();
        }*/

        for (StudentiEntity student : studs) {
            List<Object> information = new ArrayList<>();
            information.add(0, student.getNrMatricol());
            information.add(1, student.getMedie());
            information.add(2, "C" + student.getCamineByIdCamin());

            data.add(information);
        }
    }

    public List<List<Object>> getData() {
        return data;
    }

    /**
     * Returns the number of rows in the table model.
     */
    public int getRowCount() {
        return data.size();
    }

    /**
     * Returns the number of columns in the table model.
     */
    public int getColumnCount() {
        return columnNames.size();
    }

    /**
     * Returns the column name for the column index.
     */
    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    /**
     * Returns data type of the column specified by its index.
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    /**
     * Returns the value of a table model at the specified
     * row index and column index.
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }
}
