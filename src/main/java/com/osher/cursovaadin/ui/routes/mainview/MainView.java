package com.osher.cursovaadin.ui.routes.mainview;

import javax.annotation.security.PermitAll;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route("")
@PageTitle("Main View")
@PermitAll
public class MainView extends AppLayout {

		public MainView() {
			addToNavbar(new H1("Welcome!"));
		}
}
