package Explorer;
public class TestFan //������
{
    public static void main(String[] args) 
    {
        Fan f1=new Fan();//����class Fan
        Fan f2=new Fan();
        f1.setOn();
        f1.setSpeed(Fan.FAST);
        f1.setRadius(10);
        f1.setColor("yellow");
        f2.setSpeed(Fan.MEDIUM);
        System.out.print("f1����  "+f1);
        System.out.print("f2����  "+f2);
    }
}
class Fan//������
{
    public static final int SLOW=1;//final�൱��c�����е�const�����ɸ���
    public static final int MEDIUM=2;
    public static final int FAST=3;
    private int speed=SLOW;
    private boolean on=false;
    private double radius=5;
    private String color="blue";
    public Fan()
    {
    }
    public boolean getOn()
    {
        return on;
    }
    public void setOn()
    {
        on=!on;
    }
    public int getSpeed()
    {
        return speed;
    }
    public void setSpeed(int x)
    {
        if(on&&SLOW<=x&&x<=FAST)
            speed=x;
    }
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(double x)
    {
        if(x>0)
            radius=x;
    }
    public String getColor()
    {
        return color;
    }
    public void setColor(String x)
    {
        color=x;
    }
    public String toString()
    {
        if(on)
            return "Speed:"+speed+"  Color:"+color+"  Radius:"+radius;
        else
        {
            System.out.printf("\n");
            return "fan is off"+"  Color:"+color+"  Radius:"+radius;
        }
    }
}