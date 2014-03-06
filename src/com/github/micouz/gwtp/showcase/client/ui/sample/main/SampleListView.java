package com.github.micouz.gwtp.showcase.client.ui.sample.main;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SampleListView extends ViewImpl implements SampleListPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, SampleListView> {
	}

	@Inject
	public SampleListView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
