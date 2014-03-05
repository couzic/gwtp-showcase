package com.github.micouz.gwtp.showcase.client.ui.main;

import com.github.micouz.gwtp.showcase.client.resource.Resources;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class MainView extends ViewImpl implements MainPresenter.MyView {

	public interface Binder extends UiBinder<Widget, MainView> {
	}

	private final Widget widget;

	@Override
	public Widget asWidget() {
		return widget;
	}

	@UiField Panel contentSlot;
	@UiField Panel headerSlot;

	@Inject
	public MainView(final Binder binder) {
		widget = binder.createAndBindUi(this);
		Resources.INSTANCE.style().ensureInjected();
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == MainPresenter.CONTENT_SLOT) {
			contentSlot.clear();
			contentSlot.add(content);
		} else if (slot == MainPresenter.HEADER_SLOT) {
			headerSlot.clear();
			headerSlot.add(content);
		} else
			super.setInSlot(slot, content);
	}
}
