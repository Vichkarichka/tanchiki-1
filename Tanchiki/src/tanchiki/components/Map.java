package tanchiki.components;

import java.util.ArrayList;
import java.util.Iterator;

// Описание всех видов поверхностей карты
enum Plane
{
    Сoncrete,       // Бетон    ...
    Soil,           // Почва    отлично передвижение
    Water;          // Вода     передвигаться могут только со специальными гусенецами и очень ограниченой скоростью
    // ..........................
    // ..........................
}

public class Map 
{
    ArrayList<ArrayList<Plane>>     earth;
    int                             height,
                                    width;
    
    public Map(int width, int height)
    {
        this.width  = width;
        this.height = height;
        earth       = new ArrayList<ArrayList<Plane>>(height);
        for (ArrayList<Plane> arrayList : earth) 
        {
            arrayList = new ArrayList<Plane>(width);
            for (int q=0; q<arrayList.size(); q++) 
            {
                arrayList.set(q, Plane.Soil);                
            }
        }
    }
}
