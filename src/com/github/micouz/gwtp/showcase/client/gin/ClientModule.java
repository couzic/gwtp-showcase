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
import com.github.micouz.gwtp.showcase.client.ui.SearchResultPresenter;
import com.github.micouz.gwtp.showcase.client.ui.SearchResultView;

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
	}
}
