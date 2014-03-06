package com.github.micouz.gwtp.showcase.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.github.micouz.gwtp.showcase.client.place.ClientPlaceManager;
import com.github.micouz.gwtp.showcase.client.ui.main.MainPresenter;
import com.github.micouz.gwtp.showcase.client.ui.main.MainView;
import com.github.micouz.gwtp.showcase.client.ui.main.HomePresenter;
import com.github.micouz.gwtp.showcase.client.ui.main.HomeView;
import com.github.micouz.gwtp.showcase.client.place.DefaultPlace;
import com.github.micouz.gwtp.showcase.client.place.NameTokens;
import com.github.micouz.gwtp.showcase.client.ui.main.HeaderPresenter;
import com.github.micouz.gwtp.showcase.client.ui.main.HeaderView;
import com.github.micouz.gwtp.showcase.client.ui.search.SearchResultPresenter;
import com.github.micouz.gwtp.showcase.client.ui.search.SearchResultView;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleHomePresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleHomeView;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleListPresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleListView;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleMainPresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleMainView;
import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.EventBusSamplePresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.EventBusSampleView;
import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.LeftWidgetPresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.LeftWidgetView;
import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.RightWidgetPresenter;
import com.github.micouz.gwtp.showcase.client.ui.sample.eventbus.RightWidgetView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(MainPresenter.class, MainPresenter.MyView.class,
				MainView.class, MainPresenter.MyProxy.class);

		bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class, HomePresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);

		bindSingletonPresenterWidget(HeaderPresenter.class, HeaderPresenter.MyView.class, HeaderView.class);

		bindPresenter(	SearchResultPresenter.class,
						SearchResultPresenter.MyView.class,
						SearchResultView.class,
						SearchResultPresenter.MyProxy.class);

		bindPresenter(	SampleMainPresenter.class,
						SampleMainPresenter.MyView.class,
						SampleMainView.class,
						SampleMainPresenter.MyProxy.class);

		bindSingletonPresenterWidget(SampleListPresenter.class, SampleListPresenter.MyView.class, SampleListView.class);

		bindPresenter(	SampleHomePresenter.class,
						SampleHomePresenter.MyView.class,
						SampleHomeView.class,
						SampleHomePresenter.MyProxy.class);

		bindPresenter(	EventBusSamplePresenter.class,
						EventBusSamplePresenter.MyView.class,
						EventBusSampleView.class,
						EventBusSamplePresenter.MyProxy.class);

		bindPresenterWidget(LeftWidgetPresenter.class, LeftWidgetPresenter.MyView.class, LeftWidgetView.class);

		bindPresenterWidget(RightWidgetPresenter.class, RightWidgetPresenter.MyView.class, RightWidgetView.class);
	}
}
