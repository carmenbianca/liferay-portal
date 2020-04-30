/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.AgentDSParticipantImpl;
import com.liferay.digital.signature.model.AgentDSParticipant;
import com.liferay.digital.signature.model.builder.AgentDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public class AgentDSParticipantBuilderImpl
	extends BaseParticipantModifyingDSParticipantBuilderImpl<AgentDSParticipant>
	implements AgentDSParticipantBuilder {

	public AgentDSParticipantBuilderImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	protected AgentDSParticipant createDSParticipant() {
		return new AgentDSParticipantImpl(
			getEmailAddress(), getName(), getRoutingOrder()) {

			{
				setCanEditParticipantEmailAddresses(
					getCanEditParticipantEmailAddresses());
				setCanEditParticipantNames(getCanEditParticipantNames());
			}
		};
	}

}