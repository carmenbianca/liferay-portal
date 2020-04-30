/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface RadioGroupDSField extends UserEntryDSField<RadioGroupDSField> {

	public String getGroupName();

	public List<RadioDSField> getRadioDSFields();

	@Override
	public default <S> S visit(DSFieldVisitor<S> dsFieldVisitor) {
		return dsFieldVisitor.visit(this);
	}

}