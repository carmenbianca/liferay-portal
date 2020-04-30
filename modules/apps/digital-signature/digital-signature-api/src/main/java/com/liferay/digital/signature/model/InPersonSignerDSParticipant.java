/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface InPersonSignerDSParticipant extends SignerDSParticipant {

	public DSInPersonSignerType getDSInPersonSignerType();

	public String getHostEmailAddress();

	public String getHostName();

	public String getSignerEmailAddress();

	public String getSignerName();

}