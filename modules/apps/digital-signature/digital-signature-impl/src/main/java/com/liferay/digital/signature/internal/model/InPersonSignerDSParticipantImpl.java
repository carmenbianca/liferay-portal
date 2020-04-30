/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSInPersonSignerType;
import com.liferay.digital.signature.model.DSParticipantRole;
import com.liferay.digital.signature.model.DSParticipantVisitor;
import com.liferay.digital.signature.model.InPersonSignerDSParticipant;

/**
 * @author Michael C. Han
 */
public class InPersonSignerDSParticipantImpl
	extends SignerDSParticipantImpl implements InPersonSignerDSParticipant {

	public InPersonSignerDSParticipantImpl(
		String hostEmailAddress, String hostName, int routingOrder,
		String signerEmailAddress, String signerName) {

		super(signerEmailAddress, signerName, routingOrder);

		setDSParticipantRole(DSParticipantRole.IN_PERSON_SIGNER);

		_hostEmailAddress = hostEmailAddress;
		_hostName = hostName;
	}

	@Override
	public DSInPersonSignerType getDSInPersonSignerType() {
		return DSInPersonSignerType.IN_PERSON;
	}

	@Override
	public String getHostEmailAddress() {
		return _hostEmailAddress;
	}

	@Override
	public String getHostName() {
		return _hostName;
	}

	@Override
	public String getSignerEmailAddress() {
		return getEmailAddress();
	}

	@Override
	public String getSignerName() {
		return getName();
	}

	@Override
	public <T> T translate(DSParticipantVisitor<T> dsParticipantVisitor) {
		return dsParticipantVisitor.visit(this);
	}

	private final String _hostEmailAddress;
	private final String _hostName;

}