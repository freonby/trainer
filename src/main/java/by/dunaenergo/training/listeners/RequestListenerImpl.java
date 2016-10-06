package by.dunaenergo.training.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListenerImpl implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent ev) {

	}

	@Override
	public void requestInitialized(ServletRequestEvent ev) {
		System.out.println(" new request: " + ev.getServletRequest().getRemoteAddr());

	}

}
