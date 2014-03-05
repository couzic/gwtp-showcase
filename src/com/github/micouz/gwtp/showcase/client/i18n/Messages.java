package com.github.micouz.gwtp.showcase.client.i18n;

import com.google.gwt.i18n.client.Constants;

public interface Messages extends Constants {

	@DefaultStringValue("GWT-Platform Showcase")
	String gwtpShowcase();
	
	@DefaultStringValue("Home")
	String home();
	
	@DefaultStringValue("Search")
	String search();

	@DefaultStringValue("Search Results")
	String searchResults();

}