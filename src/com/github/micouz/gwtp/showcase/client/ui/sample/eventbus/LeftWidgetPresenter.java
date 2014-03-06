package com.github.micouz.gwtp.showcase.client.ui.sample.eventbus;

import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.event.LeftWidgetClickEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class LeftWidgetPresenter extends PresenterWidget<LeftWidgetPresenter.MyView> implements ClickHandler {

	public interface MyView extends View {

		HasClickHandlers getButton();

	}

	@Inject
	public LeftWidgetPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
		view.getButton().addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		LeftWidgetClickEvent.fire(getEventBus());
	}

}
