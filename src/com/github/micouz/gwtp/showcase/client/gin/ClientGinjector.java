package com.github.micouz.gwtp.showcase.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.github.micouz.gwtp.showcase.client.gin.ClientModule;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.inject.client.AsyncProvider;
import com.github.micouz.gwtp.showcase.client.ui.main.MainPresenter;
import com.github.micouz.gwtp.showcase.client.ui.main.HomePresenter;
import com.github.micouz.gwtp.showcase.client.ui.search.SearchResultPresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleHomePresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleMainPresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.EventBusSamplePresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<MainPresenter> getMainPresenter();

	AsyncProvider<HomePresenter> getHomePresenter();

	AsyncProvider<SearchResultPresenter> getSearchResultPresenter();

	AsyncProvider<SampleMainPresenter> getSampleMainPresenter();

	AsyncProvider<SampleHomePresenter> getSampleHomePresenter();

	AsyncProvider<EventBusSamplePresenter> getEventBusSamplePresenter();
}
