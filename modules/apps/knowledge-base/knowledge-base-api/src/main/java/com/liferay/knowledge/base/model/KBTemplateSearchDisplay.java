/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.model;

import java.io.Serializable;

import java.util.List;

/**
 * @author Peter Shin
 */
public interface KBTemplateSearchDisplay extends Serializable {

	public int[] getCurStartValues();

	public List<KBTemplate> getResults();

	public int getTotal();

	public void setCurStartValues(int[] curStartValues);

	public void setResults(List<KBTemplate> results);

	public void setTotal(int total);

}