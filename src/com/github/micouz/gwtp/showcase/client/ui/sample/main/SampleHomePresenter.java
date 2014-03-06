package com.github.micouz.gwtp.showcase.client.ui.sample.main;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.github.micouz.gwtp.showcase.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleMainPresenter;

public class SampleHomePresenter extends Presenter<SampleHomePresenter.MyView, SampleHomePresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.sample)
	public interface MyProxy extends ProxyPlace<SampleHomePresenter> {
	}

	@Inject
	public SampleHomePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, SampleMainPresenter.SAMPLE_SLOT, this);
	}
}
