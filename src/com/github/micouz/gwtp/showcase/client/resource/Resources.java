package com.github.micouz.gwtp.showcase.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface Resources extends ClientBundle {

	final Resources INSTANCE = GWT.create(Resources.class);
	
	StyleCSS style();
	
}
