package F8.NB263;

import java.util.Arrays;

public class HashTableOpen<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        boolean empty;
        Entry(K key, V value, boolean empty) {
            this.key = key;
            this.value = value;
            this.empty = empty;
        }
    }

    private Entry<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableOpen(int initialCapacity) {
        table = (Entry<K, V>[]) new Entry[initialCapacity];
        this.size = 0;
    }

    private int getHash(K key) {
        int hash = key.hashCode() % table.length;
        return hash < 0 ? hash + table.length : hash;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        Entry<K, V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[oldTable.length * 2];
        size = 0;
        for (Entry<K, V> e : oldTable) {
            if (e != null && !e.empty) {
                int index = getHash(e.key);
                while (table[index] != null) {
                    index = (index + 1) % table.length;
                }
                table[index] = new Entry<>(e.key, e.value, false);
                size++;
            }
        }
    }

    public V put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null key is not allowed.");
        if ((double) size / table.length > 0.75) rehash();

        int index = getHash(key);
        for (int i = 0; i < table.length; i++) {
            if (table[index] == null) {
                table[index] = new Entry<>(key, value, false);
                size++;
                return null;
            } else if (table[index].empty) {
                table[index] = new Entry<>(key, value, false);
                size++;
                return null;
            } else if (table[index].key.equals(key)) {
                V oldValue = table[index].value;
                table[index].value = value;
                return oldValue;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) return null;
        int index = getHash(key);
        for (int i = 0; i < table.length; i++) {
            if (table[index] == null) break;
            if (!table[index].empty && table[index].key.equals(key)) {
                V value = table[index].value;
                table[index].empty = true;
                table[index].value = null;
                size--;
                return value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

    public V get(K key) {
        if (key == null) return null;
        int index = getHash(key);
        for (int i = 0; i < table.length; i++) {
            if (table[index] == null || table[index].empty) return null;
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(Entry<K,V> e: table){
            if(e != null){
                if( !e.empty){
                    sb.append(e.value).append(", ");
                }
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        HashTableOpen<String, Integer> hto = new HashTableOpen<>(1);
        hto.put("Max", 28);
        hto.put("Jesper", 16);
        hto.put("Elias", 89);
        System.out.println(hto);
        hto.remove("Max");
        System.out.println(hto);
        hto.put("Max", 28);
        System.out.println(hto);
        System.out.println("Replacing ('Max', '" + hto.put("Max", 27) + "')" );
        System.out.println(hto);
    }
}
