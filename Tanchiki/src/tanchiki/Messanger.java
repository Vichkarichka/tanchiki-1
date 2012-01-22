package tanchiki;

public class Messanger 
{
    private boolean new_message;
    private String text;
    
    Messanger()
    {
        new_message = false;
        text = "";
    }

    public boolean isNew_message() 
    {
        return new_message;
    }

    public String getText() 
    {
        new_message = false;
        return text;
    }

    public void setText(String text) 
    {
        this.text = text;
        new_message = true;
    }
}
