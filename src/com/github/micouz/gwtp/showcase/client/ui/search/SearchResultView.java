package com.github.micouz.gwtp.showcase.client.ui.search;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SearchResultView extends ViewImpl implements SearchResultPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, SearchResultView> {
	}

	@Inject
	public SearchResultView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
