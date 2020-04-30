/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.oauth;

import com.liferay.portal.kernel.oauth.Verifier;

/**
 * @author Brian Wing Shun Chan
 */
public class VerifierImpl implements Verifier {

	public VerifierImpl(org.scribe.model.Verifier verifier) {
		_verifier = verifier;
	}

	@Override
	public Object getWrappedVerifier() {
		return _verifier;
	}

	private final org.scribe.model.Verifier _verifier;

}