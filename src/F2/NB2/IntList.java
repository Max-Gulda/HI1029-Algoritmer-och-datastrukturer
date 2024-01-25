package F2.NB2;

public class IntList {
    private int[] theList;
    private int size;
    private int nrOfElements;

    public IntList(int initialCapacity){
        nrOfElements = 0;
        size = initialCapacity;
        theList = new int[size];
    }

    public void add(int element){
        if(nrOfElements >= size) expand();
        System.out.println(nrOfElements);
        System.out.println(size);
        theList[nrOfElements++] = element;
    }

    public void add(int index, int element){
        this.testIndex(index);
        if(nrOfElements >= size) this.expand();

        int tempInt = theList[index];
        for (int i = nrOfElements; i > index; i--) {
            theList[i] = theList[i - 1];
        }
        theList[index] = element;
        nrOfElements++;
    }

    private void expand() {
        int[] tempList = new int[size * 2];
        System.arraycopy(theList, 0, tempList, 0, size);
        size *= 2;
        theList = tempList;
    }


    public int set(int index, int element){
        this.testIndex(index);
        int tempInt = theList[index];
        theList[index] = element;
        return tempInt;
    }

    public int indexOf(int element){
        for(int i = 0; i < nrOfElements; i++){
            if( theList[i] == element) return i;
        }
        return -1;
    }

    public void remove(int index){
        this.testIndex(index);
        for (int i = index; i < nrOfElements - 1; i++) {
            theList[i] = theList[i + 1];
        }
        nrOfElements--;
    }

    public int get(int index){
        this.testIndex(index);
        return theList[index];
    }

    public int size(){
        return nrOfElements;
    }

    private void testIndex(int index){
        if (index < 0 || index >= nrOfElements) throw new IndexOutOfBoundsException(Integer.toString(index));
    }

    @Override
    public String toString() {
        if(nrOfElements == 0) return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[");
        for(int i = 0; i < nrOfElements - 1; i++){
            b.append(theList[i]).append(", ");
        }
        b.append(theList[nrOfElements-1]).append("]");
        return b.toString();
    }
}
