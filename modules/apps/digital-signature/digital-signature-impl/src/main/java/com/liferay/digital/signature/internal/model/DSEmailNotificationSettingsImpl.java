/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSEmailNotificationSettings;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public class DSEmailNotificationSettingsImpl
	implements DSEmailNotificationSettings {

	public void addBccEmailAddresses(Collection<String> bccEmailAddresses) {
		_bccEmailAddresses.addAll(bccEmailAddresses);
	}

	@Override
	public Set<String> getBccEmailAddresses() {
		return _bccEmailAddresses;
	}

	@Override
	public String getOverrideReplyEmailAddress() {
		return _overrideReplyEmailAddress;
	}

	@Override
	public String getOverrideReplyName() {
		return _overrideReplyName;
	}

	public void setOverrideReplyEmailAddress(String overrideReplyEmailAddress) {
		_overrideReplyEmailAddress = overrideReplyEmailAddress;
	}

	public void setOverrideReplyName(String overrideReplyName) {
		_overrideReplyName = overrideReplyName;
	}

	private final Set<String> _bccEmailAddresses = new HashSet<>();
	private String _overrideReplyEmailAddress;
	private String _overrideReplyName;

}