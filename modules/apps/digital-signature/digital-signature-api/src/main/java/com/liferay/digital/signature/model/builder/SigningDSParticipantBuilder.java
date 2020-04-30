/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.builder;

import com.liferay.digital.signature.model.field.DSField;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface SigningDSParticipantBuilder {

	public <S extends DSParticipantBuilder> S addDSField(DSField<?> dsField);

	public <S extends DSParticipantBuilder> S addDSFields(
		Collection<DSField<?>> dsFields);

	public <S extends DSParticipantBuilder> S addDSFields(
		DSField<?>... dsFields);

	public <S extends DSParticipantBuilder> S setAutoNavigation(
		Boolean autoNavigation);

	public <S extends DSParticipantBuilder> S setDefaultParticipant(
		Boolean defaultParticipant);

	public <S extends DSParticipantBuilder> S setSignatureInfo(
		String signatureFont, String signatureInitials, String signatureName);

	public <S extends DSParticipantBuilder> S setSignInEachLocation(
		Boolean signInEachLocation);

}