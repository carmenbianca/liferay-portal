/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.ApproveDSFieldImpl;
import com.liferay.digital.signature.model.field.ApproveDSField;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.builder.ApproveDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class ApproveDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<ApproveDSField>
	implements ApproveDSFieldBuilder {

	public ApproveDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<ApproveDSField> getDSField() {
		ApproveDSFieldImpl approveDSFieldImpl = new ApproveDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setApprovalText(_approvalText);
			}
		};

		populateFields(approveDSFieldImpl);

		return approveDSFieldImpl;
	}

	@Override
	public ApproveDSFieldBuilder setApprovalText(String approvalText) {
		_approvalText = approvalText;

		return this;
	}

	private String _approvalText;

}