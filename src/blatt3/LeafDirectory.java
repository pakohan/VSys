package blatt3;

/**
 * User: mogli
 * Date: 10.04.13
 * Time: 09:37
 */
public class LeafDirectory extends Directory {
    Cell c;
    int ent;

    protected LeafDirectory(Cell cell, CompositeDirectory parent) {
        super(parent);
        c = cell;
    }

    @Override
    Cell lookup(int entity) {
        return ent == entity ? c : parent.lookup(entity);
    }

    public void insert(int entity) {
        ent = entity;
        parent.insert(entity, this);
    }
}
