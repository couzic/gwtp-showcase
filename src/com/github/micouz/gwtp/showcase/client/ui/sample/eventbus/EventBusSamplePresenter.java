package com.github.micouz.gwtp.showcase.client.ui.sample.eventbus;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.github.micouz.gwtp.showcase.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleMainPresenter;

public class EventBusSamplePresenter extends Presenter<EventBusSamplePresenter.MyView, EventBusSamplePresenter.MyProxy> {

	@ProxyCodeSplit
	@NameToken(NameTokens.eventBusSample)
	public interface MyProxy extends ProxyPlace<EventBusSamplePresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, SampleMainPresenter.SAMPLE_SLOT, this);
	}

	public interface MyView extends View {
	}

	@ContentSlot public static final Type<RevealContentHandler<?>> LEFT_SLOT = new Type<RevealContentHandler<?>>();
	@ContentSlot public static final Type<RevealContentHandler<?>> RIGHT_SLOT = new Type<RevealContentHandler<?>>();
	
	@Inject
	public EventBusSamplePresenter(EventBus eventBus, MyView view, MyProxy proxy, LeftWidgetPresenter leftWidget,
			RightWidgetPresenter rightWidget) {
		super(eventBus, view, proxy);
		setInSlot(LEFT_SLOT, leftWidget);
		setInSlot(RIGHT_SLOT, rightWidget);
	}

}
