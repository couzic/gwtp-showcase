package com.github.micouz.gwtp.showcase.client.ui.sample.eventbus;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class LeftWidgetClickEvent extends GwtEvent<LeftWidgetClickEvent.Handler> {

	public static Type<Handler> TYPE = new Type<Handler>();

	public interface Handler extends EventHandler {

		void onLeftWidgetClick(LeftWidgetClickEvent event);
	}

	public LeftWidgetClickEvent() {
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onLeftWidgetClick(this);
	}

	@Override
	public Type<Handler> getAssociatedType() {
		return TYPE;
	}

	public static Type<Handler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source) {
		source.fireEvent(new LeftWidgetClickEvent());
	}
}
