/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.EditorDSParticipantImpl;
import com.liferay.digital.signature.model.EditorDSParticipant;
import com.liferay.digital.signature.model.builder.EditorDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public class EditorDSParticipantBuilderImpl
	extends BaseParticipantModifyingDSParticipantBuilderImpl
		<EditorDSParticipant> implements EditorDSParticipantBuilder {

	public EditorDSParticipantBuilderImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	protected EditorDSParticipant createDSParticipant() {
		return new EditorDSParticipantImpl(
			getEmailAddress(), getName(), getRoutingOrder()) {

			{
				setCanEditParticipantEmailAddresses(
					getCanEditParticipantEmailAddresses());
				setCanEditParticipantNames(getCanEditParticipantNames());
			}
		};
	}

}