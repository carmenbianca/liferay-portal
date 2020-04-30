/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSParticipant {

	public String getAccessCode();

	public String getClientUserKey();

	public Collection<String> getCustomFieldKeys();

	public DSEmailNotification getDSEmailNotification();

	public DSParticipantRole getDSParticipantRole();

	public String getEmailAddress();

	public String getName();

	public String getNote();

	public String getParticipantKey();

	public String getRoleName();

	public int getRoutingOrder();

	public <T> T translate(DSParticipantVisitor<T> dsParticipantVisitor);

}