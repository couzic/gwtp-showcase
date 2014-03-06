package com.github.micouz.gwtp.showcase.client.ui.sample.eventbus;

import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.event.LeftWidgetClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasText;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class RightWidgetPresenter extends PresenterWidget<RightWidgetPresenter.MyView>
		implements LeftWidgetClickEvent.Handler {

	public interface MyView extends View {
		
		HasText getLabel();
		
	}

	@Inject
	public RightWidgetPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
		eventBus.addHandler(LeftWidgetClickEvent.TYPE, this);
	}

	@Override
	public void onLeftWidgetClick(LeftWidgetClickEvent event) {
		getView().getLabel().setText("Left Widget was clicked !!!");
	}
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().getLabel().setText(null);
	}
	
}
