package Observer;

import java.util.ArrayList;
import java.util.List;

interface SubscriberPerson {
    void notifications(String msg);
}

interface Item
{
    void addObserver(SubscriberPerson sub);
    void removeObserver(SubscriberPerson sub);
    void notifyObservers();
}
class Observer implements SubscriberPerson
{   private String name;
    
    public Observer(String name) {
    this.name = name;
 }

    public void notifications(String msg)
    {
            System.out.println("Notification recevied for "+name+" "+msg);
    }

}
class OberservableItem implements Item
{
    List<SubscriberPerson> observers=new ArrayList<>();
    int quantity=0;
    void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void notifyObservers()
        {
            for(SubscriberPerson observer:observers)
            {
                observer.notifications("In stock "+quantity+" units");
            }
        }

    void changeState(int quantity)
    {
        this.quantity=quantity;
        if(quantity>0)
        {
            notifyObservers();
        }
    }

   
    @Override
    public void removeObserver(SubscriberPerson sub) {
        observers.remove(sub);
    }

    @Override
    public void addObserver(SubscriberPerson sub) {
        observers.add(sub);
    }
}

public class ObserverDesignPattern {

    public static void main(String[] args) {
        OberservableItem iphone=new OberservableItem();
        Observer person1=new Observer("Person 1");
        Observer person2=new Observer("Person 2");

        iphone.addObserver(person1);
        iphone.addObserver(person2);

        iphone.changeState(10);
        iphone.removeObserver(person2);
        iphone.changeState(9);
    }
}