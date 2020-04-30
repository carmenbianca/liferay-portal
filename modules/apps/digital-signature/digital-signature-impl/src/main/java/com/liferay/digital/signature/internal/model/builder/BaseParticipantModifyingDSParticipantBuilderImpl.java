/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.model.DSParticipant;
import com.liferay.digital.signature.model.builder.DSParticipantBuilder;
import com.liferay.digital.signature.model.builder.ParticipantModifyingDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public abstract class BaseParticipantModifyingDSParticipantBuilderImpl
	<T extends DSParticipant>
		extends BaseDSParticipantBuilderImpl<T>
		implements ParticipantModifyingDSParticipantBuilder {

	public BaseParticipantModifyingDSParticipantBuilderImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	public <S extends DSParticipantBuilder> S
		setCanEditParticipantEmailAddresses(
			Boolean canEditParticipantEmailAddresses) {

		_canEditParticipantEmailAddresses = canEditParticipantEmailAddresses;

		return (S)this;
	}

	@Override
	public <S extends DSParticipantBuilder> S setCanEditParticipantNames(
		Boolean canEditParticipantNames) {

		_canEditParticipantNames = canEditParticipantNames;

		return (S)this;
	}

	protected Boolean getCanEditParticipantEmailAddresses() {
		return _canEditParticipantEmailAddresses;
	}

	protected Boolean getCanEditParticipantNames() {
		return _canEditParticipantNames;
	}

	private Boolean _canEditParticipantEmailAddresses;
	private Boolean _canEditParticipantNames;

}