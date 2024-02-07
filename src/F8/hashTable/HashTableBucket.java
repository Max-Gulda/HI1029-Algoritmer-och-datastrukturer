package F8.hashTable;

import F8.linkedList.SingleLinkedList;

import java.util.Iterator;

public class HashTableBucket<K, V> {
    private static class Entry<K, V> {
        public K key;
        public V data;
        public Entry(K key, V data) {
            this.key = key;
            this.data = data;
        }
    }

    private SingleLinkedList<Entry<K, V>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int size) {
        table = new SingleLinkedList[size];
        this.size = 0;
    }

    private int getHash(K key) {
        int index = key.hashCode() % table.length;
        return index < 0 ? index + table.length : index;
    }

    public V put(K key, V value) {
        if (key == null) return null;
        if ((double)size / table.length > 0.75) rehash();

        int index = getHash(key);

        if (table[index] == null) {
            table[index] = new SingleLinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                V oldValue = entry.data;
                entry.data = value;
                return oldValue;
            }
        }
        size++;
        table[index].add(new Entry<>(key, value));
        return null;
    }


    @SuppressWarnings("unchecked")
    private void rehash() {
        SingleLinkedList<Entry<K, V>>[] oldTable = table;
        table = new SingleLinkedList[oldTable.length * 2];
        size = 0;

        for (SingleLinkedList<Entry<K, V>> bucket : oldTable) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.data);
                }
            }
        }
    }

    public V get(K key) {
        if (key == null) return null;
        int index = getHash(key);
        if (table[index] != null) {
            for (Entry<K, V> ent : table[index]) {
                if (ent.key.equals(key)) return ent.data;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getHash(key);
        if (table[index] == null) return null;

        Iterator<Entry<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                V value = entry.data;
                iterator.remove();
                if (table[index].isEmpty()) {
                    table[index] = null;
                }
                size--;
                return value;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (SingleLinkedList<Entry<K, V>> list : table) {
            if (list != null) {
                for (Entry<K, V> e : list) {
                    sb.append(e.data).append(", ");
                }
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        HashTableBucket<String, Integer> htb = new HashTableBucket<>(4);

        htb.put("Elias", 13);
        htb.put("Max", 37);
        htb.put("Jesper", 2);
        System.out.println("Efter att ha lagt till element: " + htb);

        System.out.println("Hämta 'Max': " + htb.get("Max"));
        System.out.println("Hämta 'Elias': " + htb.get("Elias"));

        int maxVal = htb.put("Max", 73);
        System.out.println("Ersätt ('Max', '" + maxVal + "') med: " + htb.get("Max"));

        System.out.println("Ta bort 'Jesper': " + htb.remove("Jesper"));
        System.out.println("Efter att ha tagit bort 'Jesper': " + htb);

        System.out.println("Ta bort 'IckeExisterande': " + htb.remove("IckeExisterande"));

        htb.put("David", 25);
        htb.put("Björn", 50);
        htb.put("Janne", 75);
        System.out.println("Efter att ha lagt till fler element (för att utlösa omhashning): " + htb);

        System.out.println("Testa att lägga till null som nyckel och värde:");

        try {
            htb.put(null, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Hämta null-nyckel: " + htb.get(null));

        htb.put("TestNullVärde", null);

        System.out.println("Hämta 'TestNullVärde': " + htb.get("TestNullVärde"));

        System.out.println("Slutlig hashtabell: " + htb);
    }
}
