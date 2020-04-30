/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.CertifiedDeliveryDSParticipantImpl;
import com.liferay.digital.signature.model.CertifiedDeliveryDSParticipant;
import com.liferay.digital.signature.model.builder.CertifiedDeliveryDSParticipantBuilder;

/**
 * @author Michael C. Han
 */
public class CertifiedDeliveryDSParticipantBuilderImpl
	extends BaseDSParticipantBuilderImpl<CertifiedDeliveryDSParticipant>
	implements CertifiedDeliveryDSParticipantBuilder {

	public CertifiedDeliveryDSParticipantBuilderImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	protected CertifiedDeliveryDSParticipant createDSParticipant() {
		return new CertifiedDeliveryDSParticipantImpl(
			getEmailAddress(), getName(), getRoutingOrder());
	}

}