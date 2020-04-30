/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface CheckboxDSField extends DSField<CheckboxDSField> {

	public Boolean getSelected();

	@Override
	public default <S> S visit(DSFieldVisitor<S> dsFieldVisitor) {
		return dsFieldVisitor.visit(this);
	}

}