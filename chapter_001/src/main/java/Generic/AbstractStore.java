package Generic;

import java.util.Objects;

public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> items = new SimpleArray<>(new Object[]{null});

    @Override
    public void add(T model) {
        items.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        Boolean isDone = false;
        Integer index = findIndex(id);
        if (index != null) {
            items.set(index, model);
            isDone = true;
        }
        return isDone;
    }

    @Override
    public boolean delete(String id) {
        Boolean isDone = false;
        Integer index = findIndex(id);
        if (index != null) {
            items.delete(index);
            isDone = true;
        }
        return isDone;
    }

    private Integer findIndex(String id) {
        Integer index = null;

        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(id, items.get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public T findById(String id) {
        T user = null;
        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(id, items.get(i).getId())) {
                user = items.get(i);
                break;
            }
        }
        return user;
    }
}
