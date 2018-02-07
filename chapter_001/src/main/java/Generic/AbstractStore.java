package Generic;

public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> items = new SimpleArray<>();

    @Override
    public void add(T model) {
        items.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return action(id, TypeAction.REPLACE, model);
    }

    @Override
    public boolean delete(String id) {
        return action(id, TypeAction.DELETE, null);
    }

    @Override
    public T findById(String id) {
        T user = null;
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                user = items.get(i);
                break;
            }
        }
        return user;
    }

    private Boolean action(String id, TypeAction typeAction, T model) {
        Boolean isDone = false;
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                if (typeAction == TypeAction.DELETE) {
                    items.delete(i);
                }
                if (typeAction == TypeAction.REPLACE) {
                    items.set(i, model);
                }
                isDone = true;
                break;
            }
        }
        return isDone;
    }
}
