package com.github.micouz.gwtp.showcase.client.ui.sample.editor;

import com.github.micouz.gwtp.showcase.client.model.Person;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PersonEditor extends Composite implements Editor<Person> {

	private static PersonEditorUiBinder uiBinder = GWT
			.create(PersonEditorUiBinder.class);

	interface PersonEditorUiBinder extends UiBinder<Widget, PersonEditor> {
	}

	@UiField TextBox firstName;
	@UiField TextBox lastName;

	public PersonEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
