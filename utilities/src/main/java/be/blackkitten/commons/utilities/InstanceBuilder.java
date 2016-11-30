package be.blackkitten.commons.utilities;

public abstract class InstanceBuilder<T> {

    private T instance;
    private boolean hasBeenBuilt;

    public InstanceBuilder() {
        instance = createInstance();
    }

    protected abstract T createInstance();

    protected final T instance() {
        return instance;
    }

    public T build() {
        if (hasBeenBuilt) {
            throw new IllegalStateException("Builders can build only once");
        }
        hasBeenBuilt = true;
        return instance;
    }
}