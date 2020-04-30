/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.SocialSecurityNumberDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.SocialSecurityNumberDSField;
import com.liferay.digital.signature.model.field.builder.SocialSecurityNumberDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class SocialSecurityNumberDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<SocialSecurityNumberDSField>
	implements SocialSecurityNumberDSFieldBuilder {

	public SocialSecurityNumberDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<SocialSecurityNumberDSField> getDSField() {
		SocialSecurityNumberDSFieldImpl socialSecurityNumberDSFieldImpl =
			new SocialSecurityNumberDSFieldImpl(
				getDocumentKey(), getFieldKey(), getPageNumber()) {

				{
					setSenderRequired(_senderRequired);
				}
			};

		populateFields(socialSecurityNumberDSFieldImpl);

		return socialSecurityNumberDSFieldImpl;
	}

	@Override
	public SocialSecurityNumberDSFieldBuilder setSenderRequired(
		Boolean senderRequired) {

		_senderRequired = senderRequired;

		return this;
	}

	private Boolean _senderRequired;

}