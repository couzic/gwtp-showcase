package com.github.micouz.gwtp.showcase.client.ui.sample.main;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SampleMainView extends ViewImpl implements SampleMainPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, SampleMainView> {
	}

	@Inject
	public SampleMainView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@UiField Panel listSlot;
	@UiField Panel sampleSlot;

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == SampleMainPresenter.LIST_SLOT) {
			listSlot.clear();
			listSlot.add(content);
		} else if (slot == SampleMainPresenter.SAMPLE_SLOT) {
			sampleSlot.clear();
			sampleSlot.add(content);
		} else
			super.setInSlot(slot, content);
	}
}
