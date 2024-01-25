package F1;

import java.util.Arrays;

public class NB0<E> {
    private E[] theList;
    private int nrOfElements;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public NB0(int size){
        nrOfElements = 0;
        maxSize = size;
        theList = (E[]) new Object[maxSize];
    }

    public NB0(){
        this(10);
    }

    public E set(int index, E element) throws IndexOutOfBoundsException{
        if ( index < 0 || index >= nrOfElements) throw new IndexOutOfBoundsException(Integer.toString(index));
        E oldObject = theList[index];
        theList[index] = element;
        return oldObject;
    }

    public boolean add(E element){
        if(nrOfElements == maxSize) this.expand();
        theList[nrOfElements++] = element;
        return true;
    }

    public void add(E element, int index){
        if(index < 0 || index > nrOfElements) throw new IndexOutOfBoundsException();
        if(nrOfElements + 1 == maxSize) this.expand();

        for(int i = index; i < nrOfElements; i++){
            theList[i + 1] = theList[i];
        }

        theList[index] = element;
        nrOfElements++;
    }

    private void expand(){
        maxSize *= 2;
        theList = Arrays.copyOf(theList, maxSize);
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > nrOfElements) throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds");
        return theList[index];
    }

    public boolean remove(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= nrOfElements) throw new IndexOutOfBoundsException();
        for(int i = index; i < nrOfElements - 1; i++){
            theList[i] = theList[i + 1];
        }
        //theList[nrOfElements - 1] = null;
        nrOfElements-=1;
        return true;

    }

    public int indexOf(E element){
        for(int i = 0; i < nrOfElements; i++){
            if (element.equals(theList[i])) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        if(nrOfElements == 0) return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[");
        for(int i = 0; i < nrOfElements - 1; i++){
            b.append(theList[i]).append(", ");
        }
        b.append(theList[nrOfElements - 1]).append("]");
        return b.toString();
    }
}
