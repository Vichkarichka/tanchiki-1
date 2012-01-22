/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.Date;

public class Event
{
    private Long Id;
    private String Account;
    private String Password;
    private Date date;
    public Event()
    {
        
    }
    public Long getId()
    {
        return Id;
    }
    public void setId(Long id)
    {
        this.Id = id;
    }
    public Date getDate()
    {
        return date;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public String getAccount()
    {
        return Account;
    }
    public void setAccount(String account)
    {
        this.Account = account;
    }
    public String getPassword()
    {
        return Password;
    }
    public void setPassword(String password)
    {
        this.Password = password;
    }

}
