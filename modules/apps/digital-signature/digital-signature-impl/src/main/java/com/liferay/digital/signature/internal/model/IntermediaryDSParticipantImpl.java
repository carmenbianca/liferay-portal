/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSParticipantRole;
import com.liferay.digital.signature.model.DSParticipantVisitor;
import com.liferay.digital.signature.model.IntermediaryDSParticipant;

/**
 * @author Michael C. Han
 */
public class IntermediaryDSParticipantImpl
	extends BaseParticipantModifyingDSParticipantImpl
	implements IntermediaryDSParticipant {

	public IntermediaryDSParticipantImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);

		setDSParticipantRole(DSParticipantRole.INTERMEDIARY);
	}

	@Override
	public <T> T translate(DSParticipantVisitor<T> dsParticipantVisitor) {
		return dsParticipantVisitor.visit(this);
	}

}