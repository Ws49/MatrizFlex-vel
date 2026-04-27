public class Cell <T>{
    private Cell<T> top;
    private Cell<T> bottom;
    private Cell<T> previus;
    private Cell<T> next;
    private T value;


    public Cell(Cell<T> top, Cell<T> bottom, Cell<T> previus, Cell<T> next, T value){
        this.top = top;
        this.bottom = bottom;
        this.previus = previus;
        this.next = next;
        this.value = value;
    }

    public Cell(){
        this.top = null;
        this.bottom = null;
        this.previus = null;
        this.next = null;
        this.value = null;
    }


    public void setTop(Cell<T> top) {
        this.top = top;
    }

    public void setBottom(Cell<T> bottom) {
        this.bottom = bottom;
    }

    public void setNext(Cell<T> next) {
        this.next = next;
    }

    public void setPrevius(Cell<T> previus) {
        this.previus = previus;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public Cell<T> getTop() {
        return  top;
    }
    public Cell<T> getNext() {
        return next;
    }

    public Cell<T> getPrevius() {
        return previus;
    }
    public Cell<T> getBottom() {
        return bottom;
    }


    public T getValue() {
        return value;
    }
}
