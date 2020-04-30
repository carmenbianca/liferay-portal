/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.RadioDSField;
import com.liferay.digital.signature.model.field.RadioGroupDSField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class RadioGroupDSFieldImpl
	extends UserEntryDSFieldImpl<RadioGroupDSField>
	implements RadioGroupDSField {

	public RadioGroupDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	public void addRadioDSField(RadioDSField radioDSField) {
		_radioDSFields.add(radioDSField);
	}

	public void addRadioDSFields(List<RadioDSField> radioDSFields) {
		_radioDSFields.addAll(radioDSFields);
	}

	@Override
	public String getGroupName() {
		return _groupName;
	}

	@Override
	public List<RadioDSField> getRadioDSFields() {
		return _radioDSFields;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	private String _groupName;
	private List<RadioDSField> _radioDSFields = new ArrayList<>();

}