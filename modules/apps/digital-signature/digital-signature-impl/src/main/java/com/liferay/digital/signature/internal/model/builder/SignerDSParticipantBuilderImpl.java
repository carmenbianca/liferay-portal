/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.SignerDSParticipantImpl;
import com.liferay.digital.signature.model.SignerDSParticipant;
import com.liferay.digital.signature.model.builder.SignerDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public class SignerDSParticipantBuilderImpl
	extends BaseSigningDSParticipantBuilderImpl<SignerDSParticipant>
	implements SignerDSParticipantBuilder {

	public SignerDSParticipantBuilderImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	protected SignerDSParticipantImpl createSignerDSParticipantImpl() {
		return new SignerDSParticipantImpl(
			getEmailAddress(), getName(), getRoutingOrder());
	}

}