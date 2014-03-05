package com.github.micouz.gwtp.showcase.client.ui.main;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

public class MainPresenter extends Presenter<MainPresenter.MyView, MainPresenter.MyProxy> {

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<MainPresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealRootLayoutContentEvent.fire(this, this);
	}

	public interface MyView extends View {
	}

	@ContentSlot public static final Type<RevealContentHandler<?>> HEADER_SLOT = new Type<RevealContentHandler<?>>();
	@ContentSlot public static final Type<RevealContentHandler<?>> CONTENT_SLOT = new Type<RevealContentHandler<?>>();

	@Inject
	public MainPresenter(EventBus eventBus, MyView view, MyProxy proxy, HeaderPresenter header) {
		super(eventBus, view, proxy);
		setInSlot(HEADER_SLOT, header);
	}

}
