package tuit.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/*
 * @author:Felipe Pires;
 */

@SessionScoped
@Named
public class UserSession implements Serializable {

    private static final long serialVersionUID = 773496171272411714L;
    private User user;
	
	public void login(User user){
		this.user = user;		
	}
	
    public User getUser() {
        return user;
    }

	public Long getId(){
		return user.getId();
	}
	
	public String getName(){
		return user.getName();
	}
	

}
