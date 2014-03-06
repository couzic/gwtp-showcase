package com.github.micouz.gwtp.showcase.client.ui.sample.eventbus;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class LeftWidgetView extends ViewImpl implements LeftWidgetPresenter.MyView {

	private final Panel panel = new FlowPanel();
	private final Button button = new Button("Fire Event");

	@Override
	public Widget asWidget() {
		return panel;
	}

	@Inject
	public LeftWidgetView() {
		panel.add(new HTML("<h3>Left Widget</h3>"));
		panel.add(new HTML("<h5>When this widget is clicked, it fires a LeftWidgetClickEvent on the Event Bus</h5>"));
		panel.add(button);
	}

	@Override
	public HasClickHandlers getButton() {
		return button;
	}

}
