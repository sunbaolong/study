package designmode.observer;

import java.util.Observable;

/**
 * Created by sunbaolong on 2017/11/21.
 */
public class Teacher extends Observable {

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;

        setChanged();
        notifyObservers(info);
    }
}
