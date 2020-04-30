/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.spira;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public interface SpiraArtifact {

	public int getID();

	public String getName();

	public SpiraProject getSpiraProject();

	public JSONObject toJSONObject();

}