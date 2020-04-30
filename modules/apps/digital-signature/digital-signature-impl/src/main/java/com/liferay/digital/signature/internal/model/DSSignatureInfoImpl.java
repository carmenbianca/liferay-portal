/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSSignatureInfo;

/**
 * @author Michael C. Han
 */
public class DSSignatureInfoImpl implements DSSignatureInfo {

	@Override
	public String getSignatureFont() {
		return _signatureFont;
	}

	@Override
	public String getSignatureInitials() {
		return _signatureInitials;
	}

	@Override
	public String getSignatureName() {
		return _signatureName;
	}

	public void setSignatureFont(String signatureFont) {
		_signatureFont = signatureFont;
	}

	public void setSignatureInitials(String signatureInitials) {
		_signatureInitials = signatureInitials;
	}

	public void setSignatureName(String signatureName) {
		_signatureName = signatureName;
	}

	private String _signatureFont;
	private String _signatureInitials;
	private String _signatureName;

}