/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

/**
 * @author Michael C. Han
 */
public abstract class BaseParticipantModifyingDSParticipantImpl
	extends BaseDSParticipantImpl {

	public BaseParticipantModifyingDSParticipantImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	public Boolean getCanEditParticipantEmailAddresses() {
		return _canEditParticipantEmailAddresses;
	}

	public Boolean getCanEditParticipantNames() {
		return _canEditParticipantNames;
	}

	public void setCanEditParticipantEmailAddresses(
		Boolean canEditParticipantEmailAddresses) {

		_canEditParticipantEmailAddresses = canEditParticipantEmailAddresses;
	}

	public void setCanEditParticipantNames(Boolean canEditParticipantNames) {
		_canEditParticipantNames = canEditParticipantNames;
	}

	private Boolean _canEditParticipantEmailAddresses;
	private Boolean _canEditParticipantNames;

}