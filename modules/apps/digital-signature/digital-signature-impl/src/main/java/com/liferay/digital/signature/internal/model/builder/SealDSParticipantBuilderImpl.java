/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.DSSealInfoImpl;
import com.liferay.digital.signature.internal.model.DSSealProviderOptionsImpl;
import com.liferay.digital.signature.internal.model.SealDSParticipantImpl;
import com.liferay.digital.signature.model.DSSealInfo;
import com.liferay.digital.signature.model.SealDSParticipant;
import com.liferay.digital.signature.model.builder.SealDSParticipantBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class SealDSParticipantBuilderImpl
	extends BaseDSParticipantBuilderImpl<SealDSParticipant>
	implements SealDSParticipantBuilder {

	public SealDSParticipantBuilderImpl(
		String emailAddress, String name, String participantKey,
		int routingOrder) {

		super(emailAddress, name, routingOrder);

		setParticipantKey(participantKey);
	}

	@Override
	public SealDSParticipantBuilder addDSSealInfo(
		Boolean sealDocumentsWithFieldsOnly, String sealName,
		String sealProviderName) {

		DSSealInfoImpl dsSealInfoImpl = new DSSealInfoImpl(
			sealDocumentsWithFieldsOnly, sealName, sealProviderName);

		_dsSealInfos.put(sealName, dsSealInfoImpl);

		return this;
	}

	@Override
	public SealDSParticipantBuilder addDSSealInfo(
		String sealName, String sealProviderName) {

		DSSealInfoImpl dsSealInfoImpl = new DSSealInfoImpl(
			sealName, sealProviderName);

		_dsSealInfos.put(sealName, dsSealInfoImpl);

		return this;
	}

	@Override
	public SealDSParticipantBuilder addMobilePhoneNumber(
		String mobilePhoneNumber, String sealName, String signerRole) {

		DSSealProviderOptionsImpl dsSealProviderOptionsImpl =
			addDSSealProviderOptions(sealName, signerRole);

		dsSealProviderOptionsImpl.setMobilePhoneNumber(mobilePhoneNumber);

		return this;
	}

	@Override
	public SealDSParticipantBuilder addOneTimePassword(
		String oneTimePassword, String sealName, String signerRole) {

		DSSealProviderOptionsImpl dsSealProviderOptionsImpl =
			addDSSealProviderOptions(sealName, signerRole);

		dsSealProviderOptionsImpl.setOneTimePassword(oneTimePassword);

		return this;
	}

	protected DSSealProviderOptionsImpl addDSSealProviderOptions(
		String sealName, String signerRole) {

		DSSealInfoImpl dsSealInfoImpl = (DSSealInfoImpl)_dsSealInfos.get(
			sealName);

		if (dsSealInfoImpl == null) {
			throw new IllegalArgumentException(
				"No digital signature info with seal name: " + sealName);
		}

		DSSealProviderOptionsImpl dsSealProviderOptionsImpl =
			new DSSealProviderOptionsImpl();

		dsSealProviderOptionsImpl.setRoleName(signerRole);

		dsSealInfoImpl.setDSSealProviderOptions(dsSealProviderOptionsImpl);

		return dsSealProviderOptionsImpl;
	}

	@Override
	protected SealDSParticipant createDSParticipant() {
		SealDSParticipantImpl sealDSParticipantImpl = new SealDSParticipantImpl(
			getEmailAddress(), getName(), getParticipantKey(),
			getRoutingOrder());

		sealDSParticipantImpl.addDSSealInfos(_dsSealInfos.values());

		return sealDSParticipantImpl;
	}

	private Map<String, DSSealInfo> _dsSealInfos = new HashMap<>();

}