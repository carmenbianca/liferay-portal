/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.ParticipantEmailAddressDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.ParticipantEmailAddressDSField;
import com.liferay.digital.signature.model.field.builder.ParticipantEmailAddressDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class ParticipantEmailAddressDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<ParticipantEmailAddressDSField>
	implements ParticipantEmailAddressDSFieldBuilder {

	public ParticipantEmailAddressDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<ParticipantEmailAddressDSField> getDSField() {
		ParticipantEmailAddressDSFieldImpl participantEmailAddressDSFieldImpl =
			new ParticipantEmailAddressDSFieldImpl(
				getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(participantEmailAddressDSFieldImpl);

		return participantEmailAddressDSFieldImpl;
	}

}