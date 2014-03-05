package com.github.micouz.gwtp.showcase.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import java.lang.String;
import com.google.gwt.event.shared.HasHandlers;

public class ConceptSelectedEvent extends GwtEvent<ConceptSelectedEvent.ConceptSelectedHandler> {

	public static Type<ConceptSelectedHandler> TYPE = new Type<ConceptSelectedHandler>();
	private String conceptName;

	public interface ConceptSelectedHandler extends EventHandler {
	
		void onConceptSelected(ConceptSelectedEvent event);
	}

	public ConceptSelectedEvent(String conceptName) {
		this.conceptName = conceptName;
	}

	public String getConceptName() {
		return conceptName;
	}

	@Override
	protected void dispatch(ConceptSelectedHandler handler) {
		handler.onConceptSelected(this);
	}

	@Override
	public Type<ConceptSelectedHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<ConceptSelectedHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source, String conceptName) {
		source.fireEvent(new ConceptSelectedEvent(conceptName));
	}
}
