package Decorator;

interface Pizza
{
    int Cost();
    String description();
    void display();
}

class BasePizza implements Pizza
{

    @Override
    public int Cost() {
        return 10;
    }

    @Override
    public void display() {
        System.out.println(description());
    }

    @Override
    public String description() {
       return "Base pizza";
    }
    
}

abstract class PizzaToppings implements Pizza
{
    protected Pizza pizza;

    public PizzaToppings(Pizza pizza) {
        this.pizza = pizza;
    }
    
    
}

class CheeseToppings extends PizzaToppings
{
    CheeseToppings(Pizza p)
    {
        super(p);
    }
    public void display() {
        System.out.print(description());
    }

    @Override
    public int Cost() {
        return pizza.Cost()+20;
    }

    @Override
    public String description() {
       return pizza.description()+" with cheese topping";
    }
    
}

class VeggiesTopping extends PizzaToppings
{
    VeggiesTopping(Pizza p)
    {
        super(p);
    }

    @Override
    public void display() {
        System.out.print(description());
    }

    @Override
    public int Cost() {
        return pizza.Cost()+20;
    }

    @Override
    public String description() {
        return pizza.description()+" with veggies topping";
    }
    
}
public class DecoratorDesignPattern {

    public static void main(String[] args) {
        Pizza pizza=new BasePizza();
        pizza=new VeggiesTopping(pizza);
        pizza =new CheeseToppings(pizza);    
        System.out.println(pizza.Cost());
        pizza.display();
    }
}