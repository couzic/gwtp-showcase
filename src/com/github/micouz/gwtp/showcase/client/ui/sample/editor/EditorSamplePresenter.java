package com.github.micouz.gwtp.showcase.client.ui.sample.editor;

import com.github.micouz.gwtp.showcase.client.handlers.EditorSampleHandlers;
import com.github.micouz.gwtp.showcase.client.model.Person;
import com.github.micouz.gwtp.showcase.client.model.PersonBean;
import com.github.micouz.gwtp.showcase.client.place.NameTokens;
import com.github.micouz.gwtp.showcase.client.ui.sample.main.SampleMainPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class EditorSamplePresenter extends Presenter<EditorSamplePresenter.MyView, EditorSamplePresenter.MyProxy>
		implements EditorSampleHandlers {

	@ProxyCodeSplit
	@NameToken(NameTokens.editorSample)
	public interface MyProxy extends ProxyPlace<EditorSamplePresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, SampleMainPresenter.SAMPLE_SLOT, this);
	}

	interface Driver extends SimpleBeanEditorDriver<Person, PersonEditor> {
	}

	public interface MyView extends View, Editor<Person>, HasUiHandlers<EditorSampleHandlers> {

		void initDriver(Driver driver);

	}

	private final Driver driver = GWT.create(Driver.class);
	private Person person = new PersonBean("John", "Snow");

	@Inject
	public EditorSamplePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy);
		getView().setUiHandlers(this);
		getView().initDriver(driver);
		driver.edit(person);
	}

	@Override
	public void onSaveButtonClick() {
		person = driver.flush();
		if (driver.hasErrors()) {
			// A sub-editor reported errors
		}
		Window.alert("Person edited : " + person.getFirstName() + " " + person.getLastName());
	}
}
