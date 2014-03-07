package com.github.micouz.gwtp.showcase.client.ui.main;

import com.github.gwtbootstrap.client.ui.Brand;
import com.github.gwtbootstrap.client.ui.Form.SubmitEvent;
import com.github.micouz.gwtp.showcase.client.handlers.HeaderHandlers;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class HeaderView extends ViewWithUiHandlers<HeaderHandlers> implements HeaderPresenter.MyView {

	public interface Binder extends UiBinder<Widget, HeaderView> {
	}

	private final Widget widget;

	@Override
	public Widget asWidget() {
		return widget;
	}

	@UiField Brand title;

	@Inject
	public HeaderView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public HasText getTitle() {
		return title;
	}

	@UiHandler("searchBox")
	void onSubmit(SubmitEvent event) {
		getUiHandlers().onSearchSubmit();
	}
	
	@UiHandler("french")
	void onFrenchLinkClick(ClickEvent event) {
		UrlBuilder url = Window.Location.createUrlBuilder().setParameter(
				"locale", "fr");
		Window.Location.assign(url.buildString());
	}

}
