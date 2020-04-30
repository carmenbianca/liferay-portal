/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSSealInfo;
import com.liferay.digital.signature.model.DSSealProviderOptions;

import java.util.Objects;

/**
 * @author Michael C. Han
 */
public class DSSealInfoImpl implements DSSealInfo {

	public DSSealInfoImpl(
		Boolean sealDocumentsWithFieldsOnly, String sealName,
		String sealProviderName) {

		_sealDocumentsWithFieldsOnly = sealDocumentsWithFieldsOnly;
		_sealName = sealName;
		_sealProviderName = sealProviderName;
	}

	public DSSealInfoImpl(String sealName, String sealProviderName) {
		this(false, sealName, sealProviderName);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DSSealInfoImpl)) {
			return false;
		}

		DSSealInfoImpl dsSealInfoImpl = (DSSealInfoImpl)object;

		if (Objects.equals(_sealName, dsSealInfoImpl._sealName)) {
			return true;
		}

		return false;
	}

	@Override
	public DSSealProviderOptions getDSSealProviderOptions() {
		return _dsSealProviderOptions;
	}

	@Override
	public Boolean getSealDocumentsWithFieldsOnly() {
		return _sealDocumentsWithFieldsOnly;
	}

	@Override
	public String getSealName() {
		return _sealName;
	}

	@Override
	public String getSealProviderName() {
		return _sealProviderName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(_sealName);
	}

	public void setDSSealProviderOptions(
		DSSealProviderOptions dsSealProviderOptions) {

		_dsSealProviderOptions = dsSealProviderOptions;
	}

	private DSSealProviderOptions _dsSealProviderOptions;
	private final Boolean _sealDocumentsWithFieldsOnly;
	private final String _sealName;
	private final String _sealProviderName;

}