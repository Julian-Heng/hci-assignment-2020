/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Misc;


/**
 *
 * @author student
 */
public class Pair<A, B>
{
    private A item1;
    private B item2;


    public Pair()
    {
    }


    public Pair(A item1, B item2)
    {
        this.item1 = item1;
        this.item2 = item2;
    }


    public A getItem1()
    {
        return item1;
    }


    public B getItem2()
    {
        return item2;
    }


    public void setItem1(A item1)
    {
        this.item1 = item1;
    }


    public void setItem2(B item2)
    {
        this.item2 = item2;
    }


    @Override
    public String toString()
    {
        return String.format("Pair(%s, %s)", item1, item2);
    }
}
