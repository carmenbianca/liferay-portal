/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.builder;

import com.liferay.digital.signature.model.DSDocument;
import com.liferay.digital.signature.model.DSEmailNotification;
import com.liferay.digital.signature.model.DSParticipant;
import com.liferay.digital.signature.model.DSSignaturePackage;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSSignaturePackageBuilder {

	public DSSignaturePackageBuilder addDSDocuments(
		Collection<DSDocument> documents);

	public DSSignaturePackageBuilder addDSDocuments(DSDocument... dsDocuments);

	public DSSignaturePackageBuilder addDSParticipants(
		Collection<DSParticipant> dsParticipants);

	public DSSignaturePackageBuilder addDSParticipants(
		DSParticipant... dsParticipants);

	public DSSignaturePackage getDSSignatureRequest();

	public DSSignaturePackageBuilder setAuthoritative(Boolean authoritative);

	public DSSignaturePackageBuilder setDSEmailNotification(
		DSEmailNotification dsEmailNotification);

	public DSSignaturePackageBuilder setDSSignatureRequestKey(
		String dsSignatureRequestKey);

}