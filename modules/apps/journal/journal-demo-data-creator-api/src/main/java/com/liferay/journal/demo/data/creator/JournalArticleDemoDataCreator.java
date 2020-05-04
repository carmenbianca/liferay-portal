/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.demo.data.creator;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;

import java.io.IOException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jürgen Kappler
 */
@ProviderType
public interface JournalArticleDemoDataCreator {

	public JournalArticle create(long userId, long groupId)
		throws IOException, PortalException;

	public void delete() throws PortalException;

}