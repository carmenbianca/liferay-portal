/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.RadioGroupDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.RadioDSField;
import com.liferay.digital.signature.model.field.RadioGroupDSField;
import com.liferay.digital.signature.model.field.builder.RadioGroupDSFieldBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class RadioGroupDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<RadioGroupDSField>
	implements RadioGroupDSFieldBuilder {

	public RadioGroupDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public RadioGroupDSFieldBuilder addRadioDSField(RadioDSField radioDSField) {
		_radioDSFields.add(radioDSField);

		return this;
	}

	@Override
	public RadioGroupDSFieldBuilder addRadioDSFields(
		RadioDSField... radioDSFields) {

		Collections.addAll(_radioDSFields, radioDSFields);

		return this;
	}

	@Override
	public DSField<RadioGroupDSField> getDSField() {
		RadioGroupDSFieldImpl radioGroupDSFieldImpl = new RadioGroupDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				addRadioDSFields(_radioDSFields);
				setGroupName(_groupName);
			}
		};

		populateFields(radioGroupDSFieldImpl);

		return radioGroupDSFieldImpl;
	}

	@Override
	public RadioGroupDSFieldBuilder setGroupName(String groupName) {
		_groupName = groupName;

		return this;
	}

	private String _groupName;
	private List<RadioDSField> _radioDSFields = new ArrayList<>();

}