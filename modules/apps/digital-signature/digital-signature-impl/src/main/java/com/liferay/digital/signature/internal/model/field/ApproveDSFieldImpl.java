/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.ApproveDSField;

/**
 * @author Michael C. Han
 */
public class ApproveDSFieldImpl
	extends StyledDSFieldImpl<ApproveDSField> implements ApproveDSField {

	public ApproveDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public String getApprovalText() {
		return _approvalText;
	}

	public void setApprovalText(String approvalText) {
		_approvalText = approvalText;
	}

	private String _approvalText;

}