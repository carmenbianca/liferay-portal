/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSNotaryInfo;

/**
 * @author Michael C. Han
 */
public class DSNotaryInfoImpl implements DSNotaryInfo {

	public DSNotaryInfoImpl(
		String emailAddress, String name, String participantKey) {

		_emailAddress = emailAddress;
		_name = name;
		_participantKey = participantKey;
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getParticipantKey() {
		return _participantKey;
	}

	private final String _emailAddress;
	private final String _name;
	private final String _participantKey;

}