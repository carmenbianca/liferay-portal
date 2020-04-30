/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.builder;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface SealDSParticipantBuilder extends DSParticipantBuilder {

	public SealDSParticipantBuilder addDSSealInfo(
		Boolean sealDocumentsWithFieldsOnly, String sealName,
		String sealProviderName);

	public SealDSParticipantBuilder addDSSealInfo(
		String sealName, String sealProviderName);

	public SealDSParticipantBuilder addMobilePhoneNumber(
		String mobilePhoneNumber, String sealName, String signerRole);

	public SealDSParticipantBuilder addOneTimePassword(
		String oneTimePasssword, String sealName, String signerRole);

}