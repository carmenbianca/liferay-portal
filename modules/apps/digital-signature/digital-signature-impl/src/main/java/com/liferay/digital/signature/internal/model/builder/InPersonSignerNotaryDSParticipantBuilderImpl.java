/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.DSNotaryInfoImpl;
import com.liferay.digital.signature.internal.model.InPersonSignerNotaryDSParticipantImpl;
import com.liferay.digital.signature.internal.model.SignerDSParticipantImpl;
import com.liferay.digital.signature.model.InPersonSignerNotaryDSParticipant;
import com.liferay.digital.signature.model.builder.InPersonSignerNotaryDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public class InPersonSignerNotaryDSParticipantBuilderImpl
	extends BaseSigningDSParticipantBuilderImpl
		<InPersonSignerNotaryDSParticipant>
	implements InPersonSignerNotaryDSParticipantBuilder {

	public InPersonSignerNotaryDSParticipantBuilderImpl(
		String emailAddress, String name, String notaryEmailAddress,
		String notaryName, String notaryParticipantKey, int routingOrder) {

		super(emailAddress, name, routingOrder);

		_notaryEmailAddress = notaryEmailAddress;
		_notaryName = notaryName;
		_notaryParticipantKey = notaryParticipantKey;
	}

	@Override
	protected SignerDSParticipantImpl createSignerDSParticipantImpl() {
		return new InPersonSignerNotaryDSParticipantImpl(
			new DSNotaryInfoImpl(
				_notaryEmailAddress, _notaryName, _notaryParticipantKey),
			getEmailAddress(), getName(), getRoutingOrder());
	}

	private final String _notaryEmailAddress;
	private final String _notaryName;
	private final String _notaryParticipantKey;

}