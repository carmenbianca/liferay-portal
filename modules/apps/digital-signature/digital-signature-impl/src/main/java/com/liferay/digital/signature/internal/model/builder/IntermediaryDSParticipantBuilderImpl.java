/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.IntermediaryDSParticipantImpl;
import com.liferay.digital.signature.model.IntermediaryDSParticipant;
import com.liferay.digital.signature.model.builder.IntermediaryDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public class IntermediaryDSParticipantBuilderImpl
	extends BaseParticipantModifyingDSParticipantBuilderImpl
		<IntermediaryDSParticipant>
	implements IntermediaryDSParticipantBuilder {

	public IntermediaryDSParticipantBuilderImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	protected IntermediaryDSParticipant createDSParticipant() {
		return new IntermediaryDSParticipantImpl(
			getEmailAddress(), getName(), getRoutingOrder()) {

			{
				setCanEditParticipantEmailAddresses(
					getCanEditParticipantEmailAddresses());
				setCanEditParticipantNames(getCanEditParticipantNames());
			}
		};
	}

}