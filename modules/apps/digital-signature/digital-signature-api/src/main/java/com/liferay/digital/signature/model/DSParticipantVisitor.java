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
public interface DSParticipantVisitor<T> {

	public T visit(AgentDSParticipant agentDSParticipant);

	public T visit(CarbonCopyDSParticipant carbonCopyDSParticipant);

	public T visit(
		CertifiedDeliveryDSParticipant certifiedDeliveryDSParticipant);

	public T visit(EditorDSParticipant editorDSParticipant);

	public T visit(InPersonSignerDSParticipant inPersonSignerDSParticipant);

	public T visit(
		InPersonSignerNotaryDSParticipant inPersonSignerNotaryDSParticipant);

	public T visit(IntermediaryDSParticipant intermediaryDSParticipant);

	public T visit(SealDSParticipant sealDSParticipant);

	public T visit(SignerDSParticipant signerDSParticipant);

}