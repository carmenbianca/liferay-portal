/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.criteria.contributor;

import com.liferay.segments.criteria.Criteria;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides methods for retrieving segment criteria contributors defined by
 * {@link SegmentsCriteriaContributor} implementations.
 *
 * @author Eduardo García
 */
@ProviderType
public interface SegmentsCriteriaContributorRegistry {

	public List<SegmentsCriteriaContributor> getSegmentsCriteriaContributors(
		String className);

	public List<SegmentsCriteriaContributor> getSegmentsCriteriaContributors(
		String className, Criteria.Type type);

}