package blatt3;

public abstract class Directory {
	protected final CompositeDirectory parent;

	protected Directory(CompositeDirectory parent) {
		this.parent = parent;
	}

	abstract Cell lookup(int entity);
}
