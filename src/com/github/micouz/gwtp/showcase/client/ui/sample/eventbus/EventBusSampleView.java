package com.github.micouz.gwtp.showcase.client.ui.sample.eventbus;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class EventBusSampleView extends ViewImpl implements EventBusSamplePresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, EventBusSampleView> {
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@UiField Panel leftSlot;
	@UiField Panel rightSlot;

	@Inject
	public EventBusSampleView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == EventBusSamplePresenter.LEFT_SLOT) {
			leftSlot.clear();
			leftSlot.add(content);
		} else if (slot == EventBusSamplePresenter.RIGHT_SLOT) {
			rightSlot.clear();
			rightSlot.add(content);
		} else
			super.setInSlot(slot, content);
	}

}
