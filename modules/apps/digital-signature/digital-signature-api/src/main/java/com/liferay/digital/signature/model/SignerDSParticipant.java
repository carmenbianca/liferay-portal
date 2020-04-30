/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model;

import com.liferay.digital.signature.model.field.DSField;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface SignerDSParticipant extends DSParticipant {

	public Boolean getAutoNavigation();

	public Boolean getDefaultParticipant();

	public Collection<DSField<?>> getDSFields();

	public DSSignatureInfo getDSSignatureInfo();

	public Boolean getSignInEachLocation();

}