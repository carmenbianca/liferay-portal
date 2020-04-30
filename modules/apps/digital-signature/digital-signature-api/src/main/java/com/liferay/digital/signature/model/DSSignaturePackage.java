/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model;

import java.util.Collection;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSSignaturePackage {

	public Boolean getAuthoritative();

	public Collection<DSDocument> getDSDocuments();

	public DSEmailNotification getDSEmailNotification();

	public Map<DSParticipantRole, Collection<DSParticipant>>
		getDSParticipants();

	public String getDSSignaturePackageKey();

}