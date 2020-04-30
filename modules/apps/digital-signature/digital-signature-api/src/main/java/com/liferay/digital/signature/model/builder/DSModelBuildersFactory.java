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
public interface DSModelBuildersFactory {

	public AgentDSParticipantBuilder createAgentDSParticipantBuilder(
		String emailAddress, String name, int routingOrder);

	public CarbonCopyDSParticipantBuilder createCarbonCopyDSParticipantBuilder(
		String emailAddress, String name, int routingOrder);

	public CertifiedDeliveryDSParticipantBuilder
		createCertifiedDeliveryDSParticipantBuilder(
			String emailAddress, String name, int routingOrder);

	public DSDocumentBuilder createDSDocumentBuilder(
		String documentKey, String name);

	public DSEmailNotificationBuilder createDSEmailNotificationBuilder(
		String message, String subject);

	public DSSignaturePackageBuilder createDSSignatureRequestBuilder();

	public EditorDSParticipantBuilder createEditorDSParticipantBuilder(
		String emailAddress, String name, int routingOrder);

	public InPersonSignerDSParticipantBuilder
		createInPersonSignerDSParticipantBuilder(
			String hostEmailAddress, String hostName, int routingOrder,
			String signerEmailAddress, String signerName);

	public InPersonSignerNotaryDSParticipantBuilder
		createInPersonSignerNotaryDSParticipantBuilder(
			String emailAddress, String name, String notaryEmailAddress,
			String notaryName, String notaryParticipantKey, int routingOrder);

	public IntermediaryDSParticipantBuilder
		createIntermediaryDSParticipantBuilder(
			String emailAddress, String name, int routingOrder);

	public SealDSParticipantBuilder createSealDSParticipantBuilder(
		String emailAddress, String name, String participantKey,
		int routingOrder);

	public SignerDSParticipantBuilder createSignerDSParticipantBuilder(
		String emailAddress, int routingOrder, String name);

}