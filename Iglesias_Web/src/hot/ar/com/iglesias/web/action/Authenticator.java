package ar.com.iglesias.web.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

    boolean authenticate();

}
