package com.github.micouz.gwtp.showcase.client.ui.sample.main;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;

public class SampleListPresenter extends PresenterWidget<SampleListPresenter.MyView> {

	public interface MyView extends View {
	}

	@Inject
	public SampleListPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}
}
