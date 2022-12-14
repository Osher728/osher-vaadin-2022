package com.osher.cursovaadin.ui.routes.login;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver{

	private LoginForm login = new LoginForm();
	
	public LoginView() {
		addClassName("login-view");
		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);
		login.setAction("login");
		add(new H1("Curso Vaadin"), login);
	}
	
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if(event.getLocation().getQueryParameters().getParameters().containsKey("error")) {
			login.setError(true);
		}
	}

}
