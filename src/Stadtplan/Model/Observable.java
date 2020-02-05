package Stadtplan.Model;

import Stadtplan.View.Observer;

public interface Observable {

    void Attach(Observer o);
    void Detach(Observer o);
    void Notify();
}
