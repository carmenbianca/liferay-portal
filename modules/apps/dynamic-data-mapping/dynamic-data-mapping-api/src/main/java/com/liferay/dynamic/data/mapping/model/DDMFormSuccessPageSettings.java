/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.model;

import com.liferay.petra.lang.HashUtil;

import java.io.Serializable;

import java.util.Objects;

/**
 * @author Leonardo Barros
 */
public class DDMFormSuccessPageSettings implements Serializable {

	public DDMFormSuccessPageSettings() {
		_body = new LocalizedValue();
		_title = new LocalizedValue();
	}

	public DDMFormSuccessPageSettings(
		DDMFormSuccessPageSettings ddmFormSuccessPageSettings) {

		_body = new LocalizedValue(ddmFormSuccessPageSettings._body);
		_enabled = ddmFormSuccessPageSettings._enabled;
		_title = new LocalizedValue(ddmFormSuccessPageSettings._title);
	}

	public DDMFormSuccessPageSettings(
		LocalizedValue body, LocalizedValue title, boolean enabled) {

		_body = body;
		_title = title;
		_enabled = enabled;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DDMFormSuccessPageSettings)) {
			return false;
		}

		DDMFormSuccessPageSettings ddmFormSuccessPageSettings =
			(DDMFormSuccessPageSettings)obj;

		if (Objects.equals(_body, ddmFormSuccessPageSettings._body) &&
			Objects.equals(_enabled, ddmFormSuccessPageSettings._enabled) &&
			Objects.equals(_title, ddmFormSuccessPageSettings._title)) {

			return true;
		}

		return false;
	}

	public LocalizedValue getBody() {
		return _body;
	}

	public LocalizedValue getTitle() {
		return _title;
	}

	@Override
	public int hashCode() {
		int hash = HashUtil.hash(0, _body);

		hash = HashUtil.hash(hash, _enabled);

		return HashUtil.hash(hash, _title);
	}

	public boolean isEnabled() {
		return _enabled;
	}

	public void setBody(LocalizedValue body) {
		_body = body;
	}

	public void setEnabled(boolean enabled) {
		_enabled = enabled;
	}

	public void setTitle(LocalizedValue title) {
		_title = title;
	}

	private LocalizedValue _body;
	private boolean _enabled;
	private LocalizedValue _title;

}