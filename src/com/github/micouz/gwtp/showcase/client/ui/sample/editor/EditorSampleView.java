package com.github.micouz.gwtp.showcase.client.ui.sample.editor;

import com.github.micouz.gwtp.showcase.client.handlers.EditorSampleHandlers;
import com.github.micouz.gwtp.showcase.client.ui.sample.editor.EditorSamplePresenter.Driver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class EditorSampleView extends ViewWithUiHandlers<EditorSampleHandlers> implements EditorSamplePresenter.MyView {

	private final Widget widget;

	@Override
	public Widget asWidget() {
		return widget;
	}

	public interface Binder extends UiBinder<Widget, EditorSampleView> {
	}

	@UiField PersonEditor editor;

	@Inject
	public EditorSampleView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@UiHandler("saveButton")
	public void onSaveButtonClick(ClickEvent event) {
		if (getUiHandlers() != null)
			getUiHandlers().onSaveButtonClick();
	}

	@Override
	public void initDriver(Driver driver) {
		driver.initialize(editor);
	}

}
