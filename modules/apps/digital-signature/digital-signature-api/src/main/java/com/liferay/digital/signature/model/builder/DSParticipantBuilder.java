/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.builder;

import com.liferay.digital.signature.model.DSEmailNotification;
import com.liferay.digital.signature.model.DSParticipant;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSParticipantBuilder {

	public <T extends DSParticipant> T getDSParticipant();

	public DSParticipantBuilder setAccessCode(String accessCode);

	public DSParticipantBuilder setClientUserKey(String clientUserKey);

	public DSParticipantBuilder setCustomFieldKeys(String... customFieldKeys);

	public DSParticipantBuilder setDSEmailNotification(
		DSEmailNotification dsEmailNotification);

	public DSParticipantBuilder setNote(String note);

	public DSParticipantBuilder setParticipantKey(String participantKey);

	public DSParticipantBuilder setRoleName(String roleName);

}