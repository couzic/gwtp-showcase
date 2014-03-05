package com.github.micouz.gwtp.showcase.client.ui.main;

import com.github.micouz.gwtp.showcase.client.event.ConceptSelectedEvent;
import com.github.micouz.gwtp.showcase.client.event.ConceptSelectedEvent.ConceptSelectedHandler;
import com.github.micouz.gwtp.showcase.client.handlers.HeaderHandlers;
import com.github.micouz.gwtp.showcase.client.place.NameTokens;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasText;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class HeaderPresenter extends PresenterWidget<HeaderPresenter.MyView>
		implements HeaderHandlers, ConceptSelectedHandler {

	public interface MyView extends View, HasUiHandlers<HeaderHandlers> {

		HasText getTitle();

	}

	private final PlaceManager placeManager;

	@Inject
	public HeaderPresenter(EventBus eventBus, MyView view, PlaceManager placeManager) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.placeManager = placeManager;
	}

	@Override
	protected void onBind() {
		super.onBind();
		addRegisteredHandler(ConceptSelectedEvent.TYPE, this);
	}

	@Override
	public void onSearchSubmit() {
		placeManager.revealPlace(new PlaceRequest(NameTokens.searchResult), true);
	}

	@Override
	public void onConceptSelected(ConceptSelectedEvent event) {
		getView().getTitle().setText(event.getConceptName());
	}
}