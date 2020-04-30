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
public interface ApproveDSField extends StyledDSField<ApproveDSField> {

	public String getApprovalText();

	@Override
	public default <S> S visit(DSFieldVisitor<S> dsFieldVisitor) {
		return dsFieldVisitor.visit(this);
	}

}