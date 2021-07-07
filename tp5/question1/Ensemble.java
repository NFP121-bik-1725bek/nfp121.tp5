package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected Vector<T> table = new Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        return table.add(t);
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        Ensemble<T> res = new Ensemble<T>();
        Iterator<T> i1 = this.iterator();
        Iterator<? extends T> i2 = e.iterator();
        while (i1.hasNext()) {
            res.add(i1.next());
        }
        while (i2.hasNext()) {
            T iNext = i2.next();
            if (!res.contains(iNext)) {
                res.add(iNext);
            }
        }
        return res;
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        Ensemble<T> res = new Ensemble<T>();
        Iterator<T> i1 = this.iterator();
        while (i1.hasNext()) {
            T iNext = i1.next();
            if (e.contains(iNext)) {
                res.add(iNext);
            }
        }
        return res;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        Ensemble<T> res = new Ensemble<T>();
        Iterator<T> i1 = this.iterator();
        while (i1.hasNext()) {
            T iNext = i1.next();
            if (!e.contains(iNext)) {
                res.add(iNext);
            }
        }
        return res;
    }

    public Ensemble<T> diffSym(Ensemble<? extends T> e) {
        Ensemble<T> res = new Ensemble<T>();
        Iterator<T> i1 = this.iterator();
        Iterator<? extends T> i2 = e.iterator();
        while (i1.hasNext()) {
            res.add(i1.next());
        }
        while (i2.hasNext()) {
            T iNext = i2.next();
            if (res.contains(iNext)) {
                res.remove(iNext);
            } else {
                res.add(iNext);
            }
        }
        return res;
    }
}