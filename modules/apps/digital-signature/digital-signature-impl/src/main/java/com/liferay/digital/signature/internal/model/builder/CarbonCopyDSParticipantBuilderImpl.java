/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.CarbonCopyDSParticipantImpl;
import com.liferay.digital.signature.model.CarbonCopyDSParticipant;
import com.liferay.digital.signature.model.builder.CarbonCopyDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public class CarbonCopyDSParticipantBuilderImpl
	extends BaseDSParticipantBuilderImpl<CarbonCopyDSParticipant>
	implements CarbonCopyDSParticipantBuilder {

	public CarbonCopyDSParticipantBuilderImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	protected CarbonCopyDSParticipant createDSParticipant() {
		return new CarbonCopyDSParticipantImpl(
			getEmailAddress(), getName(), getRoutingOrder());
	}

}