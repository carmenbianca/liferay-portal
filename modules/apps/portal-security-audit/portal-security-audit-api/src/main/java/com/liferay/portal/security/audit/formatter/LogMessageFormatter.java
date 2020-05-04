/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit.formatter;

import com.liferay.portal.kernel.audit.AuditMessage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Mika Koivisto
 */
@ProviderType
public interface LogMessageFormatter {

	public String format(AuditMessage auditMessage);

}