interface AcessCell<T>{
    public abstract T getValue();
    public abstract void setValue(T value);
}

class ManagerCell <T> implements AcessCell<T>{
    Cell<T> cell;
    public ManagerCell(Cell<T> cell){
        this.cell = cell;
    }

    @Override
    public T getValue() {
        return cell.getValue();
    }

    @Override
    public void setValue(T value) {
        cell.setValue(value);
    }

}

public class FlexMatriz<T>{
    private Cell<T> sentinel;
    private int columns;
    private int rows;
    
    public FlexMatriz(int rows, int columns){
        this.columns = columns;
        this.rows = rows;
        sentinel = new Cell<T>();

        if(columns <= 0 || rows <= 0){
            throw new IndexOutOfBoundsException("TAMANHO INVÁLIDO");
        }
        generateMatriz();       
    }

    public FlexMatriz(FlexMatriz<T> flex){
        this.columns = flex.getColumns();
        this.rows = flex.getRows();
        sentinel = new Cell<T>();
        generateMatriz();

        for(int i =0; i < rows; i++){
            for(int j =0; j < columns; j++){
                this.at(i,j).setValue(flex.at(i, j).getValue());        
            }
        }
               
    }

    private void generateMatriz(){
        Cell<T> lineAux = sentinel;
        for(int i = 0; i < columns - 1; i++){
            Cell<T> newCell = new Cell<T>();
            lineAux.setNext(newCell);
            newCell.setPrevius(lineAux);
            lineAux = newCell;
        }

        Cell<T> cursorLine;
        Cell<T> lineOld = cursorLine = sentinel; 
        int auxLength = columns == 1 ? 1 : 0;

        for(int i =0; i < rows - 1; i++){
            Cell<T> newLineAux = new Cell<T>();
            for (int j = 0; j < (columns + auxLength) - 1; j++) {
                newLineAux.setTop(lineOld);
                lineOld.setBottom(newLineAux);
                lineOld = lineOld.getNext();

                Cell<T> newCell = new Cell<T>();
                newLineAux.setNext(newCell);
                newCell.setPrevius(newLineAux);
                newLineAux = newCell;
            }
            newLineAux.setTop(lineOld);
            lineOld.setBottom(newLineAux);
            lineOld = cursorLine = cursorLine.getBottom();
        }
    }

    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }


    public AcessCell<T> at(int line, int column){
        Cell<T> temp = sentinel;

        if(line < 0 || column < 0 || column > columns || line > rows){
            throw new IndexOutOfBoundsException("Valor fora do escopo");
        }

        for(int i = 0; i < line; i++){
            temp = temp.getBottom();
        }

        for(int j = 0; j < column; j++){
            temp = temp.getNext();
        }

        return new ManagerCell<T>(temp);
    }
    

    @Override
    public String toString() {
        String returnValue = new String();
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                    returnValue += "[" + i  + "]" + "[" + j + "]" + "=" + this.at(i, j).getValue() + "\t";
            }
            returnValue += "\n";
        }
        return returnValue;
    }

}