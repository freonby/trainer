package by.dunaenergo.training.listeners;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerImpl implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent ev) {
		Date d = new Date(ev.getSession().getCreationTime());
		System.out.println("session created: " + d);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent ev) {

		System.out.println("session destroyed:");

	}

}
