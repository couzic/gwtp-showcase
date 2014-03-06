package com.github.micouz.gwtp.showcase.client.ui.sample.eventbus;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class RightWidgetView extends ViewImpl implements RightWidgetPresenter.MyView {

	private final Panel panel = new FlowPanel();
	private final Label label = new Label();

	@Override
	public Widget asWidget() {
		return panel;
	}

	@Inject
	public RightWidgetView() {
		panel.add(new HTML("<h3>Right Widget</h3>"));
		panel.add(new HTML("<h5>This widget registers itself to the EventBus for events of type LeftWidgetClickEvent</h5>"));
		panel.add(new HTML("<h5>When a LeftWidgetClickEvent is fired on the EventBus, it is propagated to this widget</h5>"));
		panel.add(label);
	}

	@Override
	public HasText getLabel() {
		return label;
	}

}
