/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSDocument;
import com.liferay.digital.signature.model.DSEmailNotification;
import com.liferay.digital.signature.model.DSParticipant;
import com.liferay.digital.signature.model.DSParticipantRole;
import com.liferay.digital.signature.model.DSSignaturePackage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public class DSSignaturePackageImpl implements DSSignaturePackage {

	public void addDSDocuments(Collection<DSDocument> dsDocuments) {
		_dsDocuments.addAll(dsDocuments);
	}

	@Override
	public Boolean getAuthoritative() {
		return _authoritative;
	}

	@Override
	public Collection<DSDocument> getDSDocuments() {
		return Collections.unmodifiableCollection(_dsDocuments);
	}

	@Override
	public DSEmailNotification getDSEmailNotification() {
		return _dsEmailNotification;
	}

	@Override
	public Map<DSParticipantRole, Collection<DSParticipant>>
		getDSParticipants() {

		return Collections.unmodifiableMap(_dsParticipantsMap);
	}

	@Override
	public String getDSSignaturePackageKey() {
		return _dsSignaturePackageKey;
	}

	public void setAuthoritative(Boolean authoritative) {
		_authoritative = authoritative;
	}

	public void setDSEmailNotification(
		DSEmailNotification dsEmailNotification) {

		_dsEmailNotification = dsEmailNotification;
	}

	public void setDSParticipantMap(
		Map<DSParticipantRole, Collection<DSParticipant>> dsParticipantMap) {

		_dsParticipantsMap = dsParticipantMap;
	}

	public void setDSSignatureRequestKey(String dsSignatureRequestKey) {
		_dsSignaturePackageKey = dsSignatureRequestKey;
	}

	private Boolean _authoritative;
	private final Set<DSDocument> _dsDocuments = new HashSet<>();
	private DSEmailNotification _dsEmailNotification;
	private Map<DSParticipantRole, Collection<DSParticipant>>
		_dsParticipantsMap = new HashMap<>();
	private String _dsSignaturePackageKey;

}