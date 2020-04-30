/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSInPersonSignerType;
import com.liferay.digital.signature.model.DSNotaryInfo;
import com.liferay.digital.signature.model.DSParticipantRole;
import com.liferay.digital.signature.model.DSParticipantVisitor;
import com.liferay.digital.signature.model.InPersonSignerNotaryDSParticipant;

/**
 * @author Michael C. Han
 */
public class InPersonSignerNotaryDSParticipantImpl
	extends SignerDSParticipantImpl
	implements InPersonSignerNotaryDSParticipant {

	public InPersonSignerNotaryDSParticipantImpl(
		DSNotaryInfo dsNotaryInfo, String emailAddress, String name,
		int routingOrder) {

		super(emailAddress, name, routingOrder);

		_dsNotaryInfo = dsNotaryInfo;

		setDSParticipantRole(DSParticipantRole.IN_PERSON_SIGNER);
	}

	@Override
	public DSInPersonSignerType getDSInPersonSignerType() {
		return DSInPersonSignerType.NOTARY;
	}

	@Override
	public DSNotaryInfo getDSNotaryInfo() {
		return _dsNotaryInfo;
	}

	@Override
	public <T> T translate(DSParticipantVisitor<T> dsParticipantVisitor) {
		return dsParticipantVisitor.visit(this);
	}

	private final DSNotaryInfo _dsNotaryInfo;

}