/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query.function.score;

import com.liferay.portal.search.query.MultiValueMode;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface DecayScoreFunction extends ScoreFunction {

	public Double getDecay();

	public String getField();

	public MultiValueMode getMultiValueMode();

	public Object getOffset();

	public Object getOrigin();

	public Object getScale();

	public void setMultiValueMode(MultiValueMode multiValueMode);

}