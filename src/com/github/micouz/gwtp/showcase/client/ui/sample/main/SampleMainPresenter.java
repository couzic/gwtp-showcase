package com.github.micouz.gwtp.showcase.client.ui.sample.main;

import com.github.micouz.gwtp.showcase.client.ui.main.MainPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class SampleMainPresenter extends Presenter<SampleMainPresenter.MyView, SampleMainPresenter.MyProxy> {

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPresenter.CONTENT_SLOT, this);
	}

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<SampleMainPresenter> {
	}

	public interface MyView extends View {
	}

	@ContentSlot public static final Type<RevealContentHandler<?>> LIST_SLOT = new Type<RevealContentHandler<?>>();
	@ContentSlot public static final Type<RevealContentHandler<?>> SAMPLE_SLOT = new Type<RevealContentHandler<?>>();

	@Inject
	public SampleMainPresenter(EventBus eventBus, MyView view, MyProxy proxy, SampleListPresenter list) {
		super(eventBus, view, proxy);
		setInSlot(LIST_SLOT, list);
	}
}
