/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.impl;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Alexander Chow
 */
public class RepositoryImpl extends RepositoryBaseImpl {

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(Repository.class);
	}

	@Override
	public String getTypeSettings() {
		if (_typeSettingsUnicodeProperties == null) {
			return super.getTypeSettings();
		}

		return _typeSettingsUnicodeProperties.toString();
	}

	@Override
	public UnicodeProperties getTypeSettingsProperties() {
		if (_typeSettingsUnicodeProperties == null) {
			_typeSettingsUnicodeProperties = new UnicodeProperties(true);

			_typeSettingsUnicodeProperties.fastLoad(super.getTypeSettings());
		}

		return _typeSettingsUnicodeProperties;
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettingsUnicodeProperties = null;

		super.setTypeSettings(typeSettings);
	}

	@Override
	public void setTypeSettingsProperties(
		UnicodeProperties typeSettingsUnicodeProperties) {

		_typeSettingsUnicodeProperties = typeSettingsUnicodeProperties;

		super.setTypeSettings(_typeSettingsUnicodeProperties.toString());
	}

	private UnicodeProperties _typeSettingsUnicodeProperties;

}