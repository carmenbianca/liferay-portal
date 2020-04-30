/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSParticipantVisitor;
import com.liferay.digital.signature.model.EditorDSParticipant;

/**
 * @author Michael C. Han
 */
public class EditorDSParticipantImpl
	extends BaseParticipantModifyingDSParticipantImpl
	implements EditorDSParticipant {

	public EditorDSParticipantImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	public <T> T translate(DSParticipantVisitor<T> dsParticipantVisitor) {
		return dsParticipantVisitor.visit(this);
	}

}