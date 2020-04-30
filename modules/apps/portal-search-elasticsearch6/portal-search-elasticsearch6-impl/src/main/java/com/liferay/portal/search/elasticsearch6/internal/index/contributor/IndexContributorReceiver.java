/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.index.contributor;

import com.liferay.portal.search.spi.model.index.contributor.IndexContributor;

/**
 * @author Adam Brandizzi
 */
public interface IndexContributorReceiver {

	public void addIndexContributor(IndexContributor indexContributor);

	public void removeIndexContributor(IndexContributor indexContributor);

}