/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.renderer.internal.util;

import com.liferay.dynamic.data.mapping.form.field.type.internal.DDMFormFieldOptionsFactoryImpl;
import com.liferay.dynamic.data.mapping.form.field.type.internal.checkbox.multiple.CheckboxMultipleDDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.form.field.type.internal.date.DateDDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.form.field.type.internal.grid.GridDDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.form.field.type.internal.numeric.NumericDDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.form.field.type.internal.radio.RadioDDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.form.field.type.internal.select.SelectDDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.form.field.type.internal.text.TextDDMFormFieldTemplateContextContributor;
import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.util.PortalImpl;

import org.powermock.api.mockito.PowerMockito;

/**
 * @author Rafael Praxedes
 */
public class DDMFormFieldTemplateContextContributorTestHelper
	extends PowerMockito {

	public CheckboxMultipleDDMFormFieldTemplateContextContributor
			createCheckboxMultipleDDMFormFieldTemplateContextContributor()
		throws Exception {

		CheckboxMultipleDDMFormFieldTemplateContextContributor
			checkboxMultipleDDMFormFieldTemplateContextContributor =
				new CheckboxMultipleDDMFormFieldTemplateContextContributor();

		field(
			CheckboxMultipleDDMFormFieldTemplateContextContributor.class,
			"jsonFactory"
		).set(
			checkboxMultipleDDMFormFieldTemplateContextContributor, _jsonFactory
		);

		return checkboxMultipleDDMFormFieldTemplateContextContributor;
	}

	public DateDDMFormFieldTemplateContextContributor
		createDateDDMFormFieldTemplateContextContributor() {

		return new DateDDMFormFieldTemplateContextContributor();
	}

	public GridDDMFormFieldTemplateContextContributor
			createGridDDMFormFieldTemplateContextContributor()
		throws Exception {

		GridDDMFormFieldTemplateContextContributor
			gridDDMFormFieldTemplateContextContributor =
				new GridDDMFormFieldTemplateContextContributor();

		field(
			GridDDMFormFieldTemplateContextContributor.class, "jsonFactory"
		).set(
			gridDDMFormFieldTemplateContextContributor, _jsonFactory
		);

		return gridDDMFormFieldTemplateContextContributor;
	}

	public NumericDDMFormFieldTemplateContextContributor
			createNumericDDMFormFieldTemplateContextContributor()
		throws Exception {

		return new NumericDDMFormFieldTemplateContextContributor();
	}

	public RadioDDMFormFieldTemplateContextContributor
			createRadioDDMFormFieldTemplateContextContributor()
		throws Exception {

		RadioDDMFormFieldTemplateContextContributor
			radioDDMFormFieldTemplateContextContributor =
				new RadioDDMFormFieldTemplateContextContributor();

		field(
			RadioDDMFormFieldTemplateContextContributor.class, "jsonFactory"
		).set(
			radioDDMFormFieldTemplateContextContributor, _jsonFactory
		);

		return radioDDMFormFieldTemplateContextContributor;
	}

	public SelectDDMFormFieldTemplateContextContributor
			createSelectDDMFormFieldTemplateContextContributor()
		throws Exception {

		SelectDDMFormFieldTemplateContextContributor
			selectDDMFormFieldTemplateContextContributor =
				new SelectDDMFormFieldTemplateContextContributor();

		field(
			SelectDDMFormFieldTemplateContextContributor.class,
			"ddmFormFieldOptionsFactory"
		).set(
			selectDDMFormFieldTemplateContextContributor,
			new DDMFormFieldOptionsFactoryImpl()
		);

		field(
			SelectDDMFormFieldTemplateContextContributor.class, "jsonFactory"
		).set(
			selectDDMFormFieldTemplateContextContributor, _jsonFactory
		);

		field(
			SelectDDMFormFieldTemplateContextContributor.class, "portal"
		).set(
			selectDDMFormFieldTemplateContextContributor, _portal
		);

		return selectDDMFormFieldTemplateContextContributor;
	}

	public TextDDMFormFieldTemplateContextContributor
			createTextDDMFormFieldTemplateContextContributor()
		throws Exception {

		TextDDMFormFieldTemplateContextContributor
			textDDMFormFieldTemplateContextContributor =
				new TextDDMFormFieldTemplateContextContributor();

		field(
			TextDDMFormFieldTemplateContextContributor.class,
			"ddmFormFieldOptionsFactory"
		).set(
			textDDMFormFieldTemplateContextContributor,
			new DDMFormFieldOptionsFactoryImpl()
		);

		return textDDMFormFieldTemplateContextContributor;
	}

	private final JSONFactory _jsonFactory = new JSONFactoryImpl();
	private final Portal _portal = new PortalImpl();

}