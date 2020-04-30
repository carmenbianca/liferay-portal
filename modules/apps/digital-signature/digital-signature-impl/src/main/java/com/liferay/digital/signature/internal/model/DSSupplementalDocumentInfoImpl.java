/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSDocumentDisplay;
import com.liferay.digital.signature.model.DSSignerAcknowledgement;
import com.liferay.digital.signature.model.DSSupplementalDocumentInfo;

/**
 * @author Michael C. Han
 */
public class DSSupplementalDocumentInfoImpl
	implements DSSupplementalDocumentInfo {

	@Override
	public DSDocumentDisplay getDSDocumentDisplay() {
		return _dsDocumentDisplay;
	}

	@Override
	public DSSignerAcknowledgement getDSSignerAcknowledgement() {
		return _dsSignerAcknowledgement;
	}

	@Override
	public Boolean getIncludeInDownload() {
		return _includeInDownload;
	}

	public void setDSDocumentDisplay(DSDocumentDisplay dsDocumentDisplay) {
		_dsDocumentDisplay = dsDocumentDisplay;
	}

	public void setDSSignerAcknowledgement(
		DSSignerAcknowledgement dsSignerAcknowledgement) {

		_dsSignerAcknowledgement = dsSignerAcknowledgement;
	}

	public void setIncludeInDownload(Boolean includeInDownload) {
		_includeInDownload = includeInDownload;
	}

	private DSDocumentDisplay _dsDocumentDisplay;
	private DSSignerAcknowledgement _dsSignerAcknowledgement;
	private Boolean _includeInDownload;

}