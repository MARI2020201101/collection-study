package list;

public class MyVector {

    Object[] data = null;
    int capacity = 0;
    int size = 0;

    public MyVector(int capacity) throws IllegalAccessException {
        if(capacity<0){
            throw new IllegalAccessException("유효하지 않은 값입니다. : " + capacity);
        }
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector() throws IllegalAccessException {
        this(10);
    }

    public void ensureCapacity(int minCapacity){
        if(minCapacity - data.length > 0)
            setCapacity(minCapacity);
    }

    public boolean add(Object obj){
        ensureCapacity(size+1);
        data[size++]=obj;
        return true;
    }

    public Object get(int index){
        Object obj = null;
        if(index>size || index < 0){
            throw new ArrayIndexOutOfBoundsException("인덱스 범위를 넘어갔습니다. : "+ index);
        }
        obj = data[index];
        return obj;
    }

    public Object remove(int index){
        Object oldObj = null;
        if(index>size || index < 0){
            throw new ArrayIndexOutOfBoundsException("인덱스 범위를 넘어갔습니다. : "+ index);
        }
        oldObj = data[index];
        if(index!=size-1){
            System.arraycopy(data, index+1, data, index,size-index-1);
        }
        data[size-1]=null;
        size--;
        return oldObj;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void trimToSize(){
        setCapacity(size);
    }

    public void setCapacity(int capacity) {
        if(capacity<0)  return;
        if(this.capacity==capacity) return;

        this.capacity = capacity;
        Object[] tmp = new Object[capacity];
        System.arraycopy(data,0,tmp,0, size);
        data = tmp;
    }

    public void clear(){
        for(int i = 0; i<size ; i++){
            data[i] =null;
        }
        size=0;
    }

    public Object[] toArray(){
        Object[] result = null;
        System.arraycopy(data,0,result,0,size);
        return result;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
