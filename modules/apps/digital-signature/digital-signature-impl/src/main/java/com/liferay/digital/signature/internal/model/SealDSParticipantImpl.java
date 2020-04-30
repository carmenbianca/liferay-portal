/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSParticipantRole;
import com.liferay.digital.signature.model.DSParticipantVisitor;
import com.liferay.digital.signature.model.DSSealInfo;
import com.liferay.digital.signature.model.SealDSParticipant;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public class SealDSParticipantImpl
	extends BaseDSParticipantImpl implements SealDSParticipant {

	public SealDSParticipantImpl(
		String emailAddress, String name, String participantKey,
		int routingOrder) {

		super(emailAddress, name, routingOrder);

		setDSParticipantRole(DSParticipantRole.SEAL);
		setParticipantKey(participantKey);
	}

	public void addDSSealInfos(Collection<DSSealInfo> dsSealInfos) {
		_dsSealInfos.addAll(dsSealInfos);
	}

	@Override
	public Collection<DSSealInfo> getDSSealInfos() {
		return Collections.unmodifiableCollection(_dsSealInfos);
	}

	@Override
	public <T> T translate(DSParticipantVisitor<T> dsParticipantVisitor) {
		return dsParticipantVisitor.visit(this);
	}

	private Set<DSSealInfo> _dsSealInfos = new HashSet<>();

}