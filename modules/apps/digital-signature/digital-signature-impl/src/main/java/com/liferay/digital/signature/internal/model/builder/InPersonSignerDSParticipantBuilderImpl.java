/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.InPersonSignerDSParticipantImpl;
import com.liferay.digital.signature.internal.model.SignerDSParticipantImpl;
import com.liferay.digital.signature.model.InPersonSignerDSParticipant;
import com.liferay.digital.signature.model.builder.InPersonSignerDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public class InPersonSignerDSParticipantBuilderImpl
	extends BaseSigningDSParticipantBuilderImpl<InPersonSignerDSParticipant>
	implements InPersonSignerDSParticipantBuilder {

	public InPersonSignerDSParticipantBuilderImpl(
		String hostEmailAddress, String hostName, int routingOrder,
		String signerEmailAddress, String signerName) {

		super(signerEmailAddress, signerName, routingOrder);

		_hostEmailAddress = hostEmailAddress;
		_hostName = hostName;
	}

	@Override
	protected SignerDSParticipantImpl createSignerDSParticipantImpl() {
		return new InPersonSignerDSParticipantImpl(
			_hostEmailAddress, _hostName, getRoutingOrder(), getEmailAddress(),
			getName());
	}

	private final String _hostEmailAddress;
	private final String _hostName;

}