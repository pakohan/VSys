package blatt3;

import java.util.HashMap;
import java.util.Map;

/**
 * User: mogli
 * Date: 10.04.13
 * Time: 09:33
 */
public class CompositeDirectory extends Directory {
    Map<Integer, Directory> m;

    protected CompositeDirectory(CompositeDirectory parent) {
        super(parent);
        m = new HashMap<Integer, Directory>();
    }

    Cell lookup(int entity){
    //    Directory d =  m.get(new Integer(entity));
        Directory d =  m.get(entity);
        if (d == null && parent != null) {
            d = parent;
        }
        return d.lookup(entity);
    }

    public void insert(int entity, Directory l) {
        m.put(entity,l);
        if (parent != null) {
            parent.insert(entity, l);
        }
    }
}
