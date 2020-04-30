/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.list.retriever;

import com.liferay.info.pagination.Pagination;

import java.util.Optional;

/**
 * @author Eudaldo Alonso
 */
public class DefaultLayoutListRetrieverContext
	implements LayoutListRetrieverContext {

	@Override
	public Optional<Pagination> getPaginationOptional() {
		return Optional.of(_pagination);
	}

	@Override
	public Optional<long[]> getSegmentsExperienceIdsOptional() {
		return Optional.of(_segmentsExperienceIds);
	}

	public void setPagination(Pagination pagination) {
		_pagination = pagination;
	}

	public void setSegmentsExperienceIdsOptional(
		long[] segmentsExperienceIdsOptional) {

		_segmentsExperienceIds = segmentsExperienceIdsOptional;
	}

	private Pagination _pagination;
	private long[] _segmentsExperienceIds;

}